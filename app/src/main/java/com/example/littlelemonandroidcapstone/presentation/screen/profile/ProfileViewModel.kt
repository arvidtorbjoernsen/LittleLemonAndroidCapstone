package com.example.littlelemonandroidcapstone.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemonandroidcapstone.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun removeOnBoardingState(isCompleted: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.removeOnboardingUseCase.invoke(isCompleted = isCompleted)
        }
    }

}