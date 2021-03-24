package com.osaigbovo.twitterclone.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.osaigbovo.twitterclone.R
import com.osaigbovo.twitterclone.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels({ requireActivity() })
    private var fragmentHomeBinding: FragmentHomeBinding? = null
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding = binding

        fragmentHomeBinding!!.toolbarHome.setupWithNavController(findNavController())

        fragmentHomeBinding!!.swipeRefreshLayout.setOnRefreshListener {
            homeViewModel.getTweet()
        }
    }

    override fun onResume() {
        super.onResume()
        displayTweets()
    }

    override fun onDestroyView() {
        fragmentHomeBinding = null
        super.onDestroyView()
    }

    private fun displayTweets() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            homeViewModel.tweetsState.collect {
                when {
                    it.isLoading -> {
                        bindLoading(it.isLoading)
                        displayError(it.error, false)
                    }
                    it.tweets?.isNotEmpty() == true -> {
                        bindLoading(it.isLoading)
                        displayError(it.error, false)
                        homeAdapter = HomeAdapter(it.tweets)
                        fragmentHomeBinding!!.recyclerView.adapter = homeAdapter

                        homeAdapter.onItemClickListener = { tweet ->
                            // Navigate to Tweet Details.
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                                    tweet
                                )
                            )
                        }
                    }
                    it.error != null -> {
                        bindLoading(it.isLoading)
                        displayError(it.error, true)
                    }
                }
            }
        }
    }

    private fun bindLoading(isLoading: Boolean) {
        fragmentHomeBinding!!.swipeRefreshLayout.isRefreshing = isLoading
    }

    private fun displayError(errorText: String?, visible: Boolean) {
        fragmentHomeBinding!!.textError.apply {
            text = errorText
            visibility = if (visible) View.VISIBLE else View.GONE
        }
    }
}