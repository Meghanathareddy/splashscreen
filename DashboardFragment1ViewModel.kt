package com.example.splashscreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.model.Data

import com.example.splashscreen.model.UsersListResponse
import com.example.splashscreen.repository.UserList
import kotlinx.coroutines.launch

class DashboardFragment1ViewModel:ViewModel() {

        val userListData: UserList = UserList()
        val usersListResponses: MutableLiveData<List<Data>> = MutableLiveData()

         fun usersListResponse(){
             viewModelScope.launch {
                 try{
                     val  usersListResponse = userListData.getUsersList()
                     usersListResponses.postValue(usersListResponse.body()?.data)
//                     Log.d("userName:", usersListResponse.body()?.copy().toString())

                 }catch (ex:Exception){
                     ex.printStackTrace()
                 }

             }

        }

}