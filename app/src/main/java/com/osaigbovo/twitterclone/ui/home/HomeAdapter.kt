package com.osaigbovo.twitterclone.ui.home

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.osaigbovo.twitterclone.data.model.Tweet
import com.osaigbovo.twitterclone.databinding.ItemTweetBinding
import com.osaigbovo.twitterclone.utils.GlideApp
import java.util.*
import kotlin.collections.ArrayList

class HomeAdapter(
    tweets: List<Tweet>?
) : RecyclerView.Adapter<HomeAdapter.TweetsViewHolder>() {

    var mTweetsDiffer: AsyncListDiffer<Tweet> = AsyncListDiffer(this, TWEETS_DIFF_CALLBACK)
    var mTweetsDifferFiltered: AsyncListDiffer<Tweet> = AsyncListDiffer(this, TWEETS_DIFF_CALLBACK)

    var onItemClickListener: ((Tweet) -> Unit)? = null

    init {
        mTweetsDifferFiltered.submitList(tweets)
        mTweetsDiffer.submitList(tweets)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsViewHolder {
        return TweetsViewHolder(
            ItemTweetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(tweetsViewHolder: TweetsViewHolder, position: Int) {
        val tweet: Tweet = mTweetsDifferFiltered.currentList.get(position)
        tweetsViewHolder.bind(tweet, onItemClickListener)
    }

    override fun getItemCount(): Int =
        when {
            mTweetsDifferFiltered.currentList.isEmpty() -> 0
            else -> mTweetsDifferFiltered.currentList.size
        }

    inner class TweetsViewHolder(
        private var itemTweetBinding: ItemTweetBinding
    ) : RecyclerView.ViewHolder(itemTweetBinding.root) {

        fun bind(tweet: Tweet, onItemClickListener: ((Tweet) -> Unit)?) =
            with(itemView) {
                tweet.prof?.let { itemTweetBinding.imageProfile.setImageResource(it) }
                itemTweetBinding.textHandle.text = tweet.handle
                itemTweetBinding.textName.text = tweet.name
                itemTweetBinding.textTweet.text = tweet.content
                itemTweetBinding.textTime.text = tweet.minutes
                itemTweetBinding.textCommentCount.text = tweet.comment.toString()
                itemTweetBinding.textRetweetCount.text = tweet.rt.toString()
                itemTweetBinding.textLikeCount.text = tweet.like.toString()

                if(tweet.tweet_image.isNullOrEmpty()){
                    itemTweetBinding.imageTweet.visibility = View.GONE
                } else {
                    itemTweetBinding.imageTweet.visibility = View.VISIBLE
                    GlideApp.with(this)
                        .load(tweet.tweet_image)
                        .centerCrop()
                        .into(itemTweetBinding.imageTweet)
                }

                setOnClickListener { onItemClickListener?.invoke(tweet) }
            }
    }

    companion object {
        var TWEETS_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Tweet>() {
            override fun areItemsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
                return oldItem == newItem
            }
        }
    }
}