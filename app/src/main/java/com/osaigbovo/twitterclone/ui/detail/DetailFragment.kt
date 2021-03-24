package com.osaigbovo.twitterclone.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.osaigbovo.twitterclone.R
import com.osaigbovo.twitterclone.data.model.Tweet
import com.osaigbovo.twitterclone.databinding.FragmentDetailBinding
import com.osaigbovo.twitterclone.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val homeViewModel: HomeViewModel by viewModels({ requireActivity() })
    private var fragmentDetailBinding: FragmentDetailBinding? = null
    private var tweet: Tweet? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)
        fragmentDetailBinding = binding

        fragmentDetailBinding!!.toolbar.setupWithNavController(findNavController())

        tweet = arguments?.let { DetailFragmentArgs.fromBundle(it).tweet }
        tweet?.let { displayTweet(it) }
    }

    override fun onDestroyView() {
        fragmentDetailBinding = null
        super.onDestroyView()
    }

    private fun displayTweet(tweet: Tweet){

    }
}