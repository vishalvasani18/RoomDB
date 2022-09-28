package com.wishto.roomdbmvvm.repositories

import androidx.lifecycle.LiveData
import com.wishto.roomdbmvvm.db.UserDao
import com.wishto.roomdbmvvm.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(userModel: User) {
            userDao.addUser(userModel)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }
}