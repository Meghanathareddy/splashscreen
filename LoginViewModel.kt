package com.example.splashscreen


import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.model.LoginResponse
import com.example.splashscreen.repository.Authentication
import com.example.splashscreen.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class LoginViewModel():ViewModel() {

    val emailLiveData:MutableLiveData<String?> = MutableLiveData()
     val passwordLiveData:MutableLiveData<String?> = MutableLiveData()
    val loginLiveData:MutableLiveData<String> = MutableLiveData()
    private val loginRepository:Authentication by lazy { LoginRepository() }
    val fullScreenLoader:MutableLiveData<Boolean> = MutableLiveData()
    var shp: SharedPreferences? = null
    var shpEditor: SharedPreferences.Editor? = null
    private fun validateEmail(email:String): Boolean {
        /*
        It validate email entered in the input
         */

        //if the email input field is empty
        if (email.isEmpty()){
            emailLiveData.postValue ("Field can not be empty")
            return false

        }
        //Matching the input email to a predefined email Pattern
//        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            emailLiveData.postValue ( "Please enter a valid email Address")
//            return false
//
//        }
        else{
            emailLiveData.postValue( null)
            return true

        }

    }
    private fun validatePassword(password:String):Boolean{
        /*
        It validate email entered in the input
         */

        //if the email input field is empty
        if (password.isEmpty()){
            passwordLiveData.postValue ("Field can not be empty")
            return false

        }
        //Matching the input email to a predefined email Pattern
//        else if (!PASSWORD_PATTERN.matcher(password).matches()){
//            passwordLiveData.postValue ( "Password is too weak")
//            return false
//
//        }
        else{
            passwordLiveData.postValue( null)
            return true
        }

    }


    fun confirmInput(email: String, password: String){
        /*
        It validate email entered in the input
         */
        if (validateEmail(email) and validatePassword(password) ) {
            fullScreenLoader.postValue(true)
            viewModelScope.launch(Dispatchers.IO) {
                try {

                    val response = loginRepository.sigIn(email, password)
                    fullScreenLoader.postValue(false)
                    if(response.isSuccessful){
//                   getSharedPreferences("login", Context.MODE_PRIVATE)
                        Log.d("response", response.body().toString())
                        loginLiveData.postValue(response.body()?.token.toString())
                    }else{
                        loginLiveData.postValue("")

                    }
                }catch (ex:Exception){
                    ex.printStackTrace()
                }


            }

        }

    }

    companion object{
        private  var  PASSWORD_PATTERN: Pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")

    }






}