package com.osaigbovo.twitterclone.utils

import com.osaigbovo.twitterclone.R
import com.osaigbovo.twitterclone.data.model.Tweet

fun generateTweets(): List<Tweet> {
    val tweets = arrayListOf<Tweet>()

    tweets.add(
        Tweet(
            1,
            "Doug Judy",
            "@Judy98",
            "30m",
            "Hey there !!",
            R.drawable.profile_1,
            "",
            "#61045F",
            0,
            5,
            1
        )
    )

    tweets.add(
        Tweet(
            2,
            "Ariel Pollich",
            "@Ariel49",
            "40m",
            "Hey there !!",
            R.drawable.profile_2,
            "",
            "#333B2E",
            4,
            500,
            10
        )
    )

    tweets.add(
        Tweet(
            3,
            "Doug Judy",
            "@Judy98",
            "30m",
            "Hey there !!",
            R.drawable.profile_3,
            "",
            "#61045F",
            0,
            5,
            1
        ),
    )

    tweets.add(
        Tweet(
            4,
            "Sasha Ho",
            "@Makenna38",
            "50m",
            "Hey there !!",
            R.drawable.profile_4,
            "",
            "#44322E",
            1,
            8,
            25
        )
    )

    tweets.add(
        Tweet(
            5,
            "Zia Burkett",
            "@Burketto",
            "23m",
            "Hey there !!",
            R.drawable.profile_5,
            "",
            "#3689F3",
            5,
            1,
            5
        )
    )

    tweets.add(
        Tweet(
            6,
            "Doug Judy",
            "@Judy98",
            "30m",
            "Hey there !!",
            R.drawable.profile_6,
            "",
            "#61045F",
            0,
            5,
            1
        )
    )

    return tweets
}