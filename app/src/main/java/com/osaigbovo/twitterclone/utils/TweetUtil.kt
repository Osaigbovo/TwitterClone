package com.osaigbovo.twitterclone.utils

import com.osaigbovo.twitterclone.R
import com.osaigbovo.twitterclone.data.model.Tweet

fun generateTweets(): List<Tweet> {
    val tweets = arrayListOf<Tweet>()

    tweets.add(
        Tweet(
            1,
            "Patricia Smith",
            "@OneMorePatricia",
            "30m",
            "A car (or automobile) is a wheeled motor vehicle used for transportation. Most definitions of cars say that they run primarily on roads, seat one to eight people.",
            R.drawable.profile_1,
            "https://specials-images.forbesimg.com/imageserve/5d3703e2f1176b00089761a6/960x0.jpg?cropX1=836&cropX2=5396&cropY1=799&cropY2=3364",
            "#61045F",
            0,
            5,
            1,
            "3:30",
            "24 Mar 21"
        )
    )

    tweets.add(
        Tweet(
            2,
            "Ariel Pollich",
            "@Ariel49",
            "40m",
            "If you want to provide more content in your notification, also consider using one of the expandable notification templates instead of building a custom layout.",
            R.drawable.profile_2,
            null,
            "#333B2E",
            4,
            500,
            10,
            "3:20",
            "24 Mar 21"
        )
    )

    tweets.add(
        Tweet(
            3,
            "Tom Hulme",
            "@thulme",
            "30m",
            "I missed my best friend's wedding because I was at work. Arghhhhhhh. Don't they look cute.",
            R.drawable.profile_3,
            "data:image/jpeg;base64,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",
            "#61045F",
            0,
            5,
            1,
            "3:30",
            "24 Mar 21"
        ),
    )

    tweets.add(
        Tweet(
            4,
            "Adam Ho",
            "@Makenna38",
            "50m",
            "I just had the best ice cream EVER!!!",
            R.drawable.profile_4,
            "data:image/jpeg;base64,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",
            "#44322E",
            1,
            8,
            25,
            "3:10",
            "24 Mar 21"
        )
    )

    tweets.add(
        Tweet(
            5,
            "Zia Burkett",
            "@Burketto",
            "23m",
            "Coroutines aim to simplify code that executes asynchronously. When talking about coroutines in the JVM, the block of code passed as a lambda to a coroutine builder ultimately gets executed on a specific JVM thread.",
            R.drawable.profile_5,
            "",
            "#3689F3",
            5,
            7,
            5,
            "3:27",
            "24 Mar 21"
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
            1,
            "3:38",
            "24 Mar 21"
        )
    )

    return tweets
}