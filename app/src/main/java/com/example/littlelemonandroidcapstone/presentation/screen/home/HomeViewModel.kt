package com.example.littlelemonandroidcapstone.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import com.example.littlelemonandroidcapstone.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _menuItemList = MutableStateFlow<List<MenuItem>>(emptyList())
    val menItemList = _menuItemList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllMenuItemUseCase.invoke().collect { value ->
                _menuItemList.value = value
            }
        }
    }
}