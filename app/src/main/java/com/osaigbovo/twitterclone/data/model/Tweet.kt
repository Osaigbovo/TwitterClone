package com.osaigbovo.twitterclone.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tweet(
    val id: Int?,
    val name: String?,
    val handle: String?,
    val minutes: String?,
    val content: String?,
    val prof: Int?,
    val tweet_image: String?,
    val conImg: String?,
    val comment: Int?,
    val rt: Int?,
    val like: Int?,
    val time: String?,
    val date: String?
) : Parcelable