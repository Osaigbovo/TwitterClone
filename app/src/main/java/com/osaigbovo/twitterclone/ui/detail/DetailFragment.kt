package com.osaigbovo.twitterclone.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.osaigbovo.twitterclone.R
import com.osaigbovo.twitterclone.databinding.FragmentDetailBinding
import com.osaigbovo.twitterclone.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val homeViewModel: HomeViewModel by viewModels({ requireActivity() })

    private var fragmentDetailBinding: FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)
        fragmentDetailBinding = binding
    }

    override fun onDestroyView() {
        fragmentDetailBinding = null
        super.onDestroyView()
    }
}