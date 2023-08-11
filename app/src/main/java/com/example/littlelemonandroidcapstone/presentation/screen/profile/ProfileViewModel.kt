package com.example.littlelemonandroidcapstone.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemonandroidcapstone.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun removeOnBoardingState(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.removeOnboardingUseCase.invoke(
                isCompleted = isCompleted,
                userFirstName = userFirstName,
                userLastName = userLastName,
                userEmail = userEmail
            )
        }
    }

    private val _userFirstName = MutableStateFlow("")
    private val _userLastName = MutableStateFlow("")
    private val _userEmail = MutableStateFlow("")
    val userFirstName: StateFlow<String> = _userFirstName
    val userLastName: StateFlow<String> = _userLastName
    val userEmail: StateFlow<String> = _userEmail

    fun readOnBoardingState() {
        viewModelScope.launch(Dispatchers.IO) {
            _userFirstName.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value.userFirstName
            _userLastName.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value.userLastName
            _userEmail.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value.userEmail
        }
    }

}