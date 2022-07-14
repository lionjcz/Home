package com.jekma.maxe.model.room_database

import androidx.lifecycle.LiveData

class UserRepository(private val dataUao:UserDao) {

    val readAllData:LiveData<List<User>> = dataUao.readAllData()

    fun addUser(user: User){
        dataUao.addUser(user)
    }

    fun deleteUser(id:Int){
        dataUao.deleteData(id)
    }

}