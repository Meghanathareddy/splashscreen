//package com.example.splashscreen.viewmodel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.splashscreen.model.Json4Kotlin_Base
//import kotlinx.coroutines.launch
//import retrofit2.Response
//
//class LinkViewModel(private val repository: Repository): ViewModel() {
//
//
//    val myResponse: MutableLiveData<Response<Json4Kotlin_Base>> = MutableLiveData()
//    val myResponse2:MutableLiveData<Response<Json4Kotlin_Base>> = MutableLiveData()
//    val myCustomPost:MutableLiveData<Response<Json4Kotlin_Base>> = MutableLiveData()
//    fun getPost(){
//        viewModelScope.launch{
//            val response:Response<Json4Kotlin_Base> = repository.getPost()
//            myResponse.value = response
//        }
//
//    }
//
//    fun getPost2(number:Int){
//        viewModelScope.launch{
//            val response:Response<Json4Kotlin_Base> = repository.getPost2(number)
//            myResponse2.value = response
//        }
//
//    }
//
//    fun getCustomPost(id:Int){
//        viewModelScope.launch{
//            val response:Response<Json4Kotlin_Base> = repository.getCustomPost(id)
//            myCustomPost.value = response
//        }
//
//    }
//}