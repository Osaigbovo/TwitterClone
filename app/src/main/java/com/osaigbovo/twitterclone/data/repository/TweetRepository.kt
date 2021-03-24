package com.osaigbovo.twitterclone.data.repository

import kotlinx.coroutines.flow.Flow
import com.osaigbovo.twitterclone.data.result.Result

interface TweetRepository {
    suspend fun getTweets(): Flow<Result<*>>
}