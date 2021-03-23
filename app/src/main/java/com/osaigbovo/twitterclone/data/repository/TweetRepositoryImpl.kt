package com.osaigbovo.twitterclone.data.repository

import com.osaigbovo.twitterclone.data.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TweetRepositoryImpl @Inject constructor() : TweetRepository {

    override suspend fun getTweets(): Flow<Result<*>> {
        TODO("Not yet implemented")
    }
}