package com.example.littlelemonandroidcapstone.domain.usecase.saveproductusecase


import com.example.littlelemonandroidcapstone.data.repository.Repository
import com.example.littlelemonandroidcapstone.domain.model.MenuItem

class InsertProductsUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(menuItems: List<MenuItem>) = repository.insertMenuItems(menuItems)

}