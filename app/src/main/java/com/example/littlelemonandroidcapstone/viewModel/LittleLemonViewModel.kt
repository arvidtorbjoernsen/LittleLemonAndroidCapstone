//package com.example.littlelemonandroidcapstone.viewModel
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.littlelemonandroidcapstone.domain.model.MenuItem
//import com.example.littlelemonandroidcapstone.util.MenuItemNetwork
//import com.example.littlelemonandroidcapstone.util.MenuNetwork
//import dagger.hilt.android.lifecycle.HiltViewModel
//import io.ktor.client.HttpClient
//import io.ktor.client.call.body
//import io.ktor.client.engine.android.Android
//import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
//import io.ktor.client.request.get
//import io.ktor.http.ContentType
//import io.ktor.serialization.kotlinx.json.json
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.distinctUntilChanged
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class LittleLemonViewModel @Inject constructor(
//    private val repository: LittleLemonRepository,
//    private val useCases: UseCases
//) :
//    ViewModel() {
//
//    private val _onBoardingIsCompleted = MutableStateFlow(false)
//    val onBoardingIsCompleted: StateFlow<Boolean> = _onBoardingIsCompleted
//
//    init {
//        viewModelScope.launch {
//            useCases.insertProductsUseCase.invoke(DataDummy.generateDummyProduct())
//        }
//
//        viewModelScope.launch(Dispatchers.IO) {
//            _onBoardingIsCompleted.value =
//                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
//        }
//    }
//
//    private val httpClient = HttpClient(Android) {
//        install(ContentNegotiation) {
//            json(contentType = ContentType("text", "plain"))
//        }
//    }
//
//    private suspend fun fetchMenu(): List<MenuItemNetwork> {
//        val url =
//            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
//        val menuNetwork = httpClient.get(url).body<MenuNetwork>()
//        return menuNetwork.menu
//    }
//
//

//}