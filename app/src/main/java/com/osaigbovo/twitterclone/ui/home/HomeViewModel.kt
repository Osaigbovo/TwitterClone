package com.osaigbovo.twitterclone.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osaigbovo.twitterclone.data.model.Tweet
import com.osaigbovo.twitterclone.data.result.Result
import com.osaigbovo.twitterclone.domain.LatestTweetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val latestTweetUseCase: LatestTweetUseCase,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _tweetsState = MutableStateFlow(TweetsViewState(isLoading = true))
    val tweetsState = _tweetsState.asStateFlow()

    init {
        getTweet()
    }

    fun getTweet() {
        viewModelScope.launch {
            latestTweetUseCase(Unit).collect {
                when(it){
                    is Result.Loading -> {
                        _tweetsState.value =
                            TweetsViewState(true, null, null)
                    }
                    is Result.Success -> {
                        _tweetsState.value =
                            TweetsViewState(false, null, it.data as List<Tweet>?)
                    }
                    is Result.Error -> {
                        _tweetsState.value =
                            TweetsViewState(false, it.exception.message, null)
                    }
                }
            }
        }
    }
}

data class TweetsViewState(
    var isLoading: Boolean,
    val error: String? = null,
    val tweets: List<Tweet>? = null
)