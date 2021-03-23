package com.osaigbovo.twitterclone.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tweet(
    val name: String?,
    val handle: String?,
    val minutes: String?,
    val content: String?,
    val prof: Int?,
    val conImg: String?,
    val comment: Int?,
    val rt: String?,
    val like: Int?
) : Parcelable