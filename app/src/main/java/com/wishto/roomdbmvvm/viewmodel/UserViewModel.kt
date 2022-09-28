package com.wishto.roomdbmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.wishto.roomdbmvvm.db.UserDatabase
import com.wishto.roomdbmvvm.model.User
import com.wishto.roomdbmvvm.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(applicaion: Application) : AndroidViewModel(applicaion) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {

        val userDao = UserDatabase.getDatabase(applicaion).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(userModel: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(userModel)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }
}