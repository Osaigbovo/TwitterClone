package com.osaigbovo.twitterclone.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    // private val driverVerifyUseCase: DriverVerifyUseCase,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {

    }
}