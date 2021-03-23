package com.osaigbovo.twitterclone.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.osaigbovo.twitterclone.R
import com.osaigbovo.twitterclone.databinding.FragmentDetailBinding
import com.osaigbovo.twitterclone.databinding.FragmentHomeBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

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