package com.example.littlelemonandroidcapstone.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemonandroidcapstone.domain.usecase.UseCases
import com.example.littlelemonandroidcapstone.util.Network
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _onBoardingIsCompleted = MutableStateFlow(false)
    val onBoardingIsCompleted: StateFlow<Boolean> = _onBoardingIsCompleted

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.insertProductsUseCase.invoke(Network.getMenuItemsFromNetwork())
        }

        viewModelScope.launch(Dispatchers.IO) {
            _onBoardingIsCompleted.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value.isCompleted
        }
    }

}