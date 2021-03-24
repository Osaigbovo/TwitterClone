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
import com.osaigbovo.twitterclone.utils.GlideApp
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

    private fun displayTweet(tweet: Tweet) {
        tweet.prof?.let { fragmentDetailBinding!!.imageProfile.setImageResource(it) }
        fragmentDetailBinding!!.textName.text = tweet.name
        fragmentDetailBinding!!.textHandle.text = tweet.handle
        fragmentDetailBinding!!.textTweet.text = tweet.content
        fragmentDetailBinding!!.textLikeCount.text = tweet.like.toString()

        val quoteCount = 3
        val retweet = tweet.rt?.minus(3)

        fragmentDetailBinding!!.textQuoteCount.text = quoteCount.toString()
        fragmentDetailBinding!!.textRetweetCount.text = retweet.toString()
        fragmentDetailBinding!!.textTimeDay.text = tweet.time
        fragmentDetailBinding!!.textDate.text = tweet.date

        if(tweet.tweet_image.isNullOrEmpty()){
            fragmentDetailBinding!!.imageTweet.visibility = View.GONE
        } else {
            fragmentDetailBinding!!.imageTweet.visibility = View.VISIBLE
            GlideApp.with(this)
                .load(tweet.tweet_image)
                .centerCrop()
                .into(fragmentDetailBinding!!.imageTweet)
        }
    }
}