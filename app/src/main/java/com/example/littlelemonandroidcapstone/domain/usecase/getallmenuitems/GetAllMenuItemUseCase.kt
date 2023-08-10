package com.example.littlelemonandroidcapstone.domain.usecase.getallmenuitems


import com.example.littlelemonandroidcapstone.data.repository.Repository
import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

class GetAllMenuItemUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<MenuItem>> = repository.getAllMenuItems()

}