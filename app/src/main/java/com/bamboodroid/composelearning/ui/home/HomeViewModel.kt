package com.bamboodroid.composelearning.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private val _selectedTab: MutableLiveData<BottomTabs> = MutableLiveData()
    val selectedTab: LiveData<BottomTabs>
        get() = _selectedTab

    private val _userProfileImageUrl: MutableLiveData<String> = MutableLiveData()
    val userProfileImageUrl: LiveData<String>
        get() = _userProfileImageUrl

    init {
        _userProfileImageUrl.value = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Albert_Einstein_Head.jpg/576px-Albert_Einstein_Head.jpg"
    }

    fun selectTab(newTab: BottomTabs) {
        _selectedTab.value = newTab
    }

    fun createNewChat() {

    }
}
