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
            "A car (or automobile) is a wheeled motor vehicle used for transportation. Most definitions of cars say that they run primarily on roads, seat one to eight people.",
            R.drawable.profile_1,
            "https://specials-images.forbesimg.com/imageserve/5d3703e2f1176b00089761a6/960x0.jpg?cropX1=836&cropX2=5396&cropY1=799&cropY2=3364",
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
            "32m",
            "This has been my ideal laptop for a long time now. I am taking donations!",
            R.drawable.profile_6,
            "https://www.idgcdn.com.au/dimg/700x700/dimg/microsoft_windows_10_s_surface_laptop_1800x1200-100814366-orig_1.jpg",
            "#61045F",
            0,
            5,
            1
        )
    )

    return tweets
}