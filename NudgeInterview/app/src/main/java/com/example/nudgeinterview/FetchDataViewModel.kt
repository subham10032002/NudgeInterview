package com.example.nudgeinterview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FetchDataViewModel(application: Application) : AndroidViewModel(application) {

    private val _loginState = MutableStateFlow(UserState(success = false))
    val loginState: StateFlow<UserState> = _loginState

    val userRep = UserRepository()

    init {
        checkUserState()
    }

    private fun checkUserState() {
        val savedUser = userRep.getUser()
        if (savedUser != null) {
            _loginState.value = UserState(true)
        }
    }
    fun fetchData(userName: String, password: String){
        // Simulate fetch Data
        viewModelScope.launch {
        // Simulating Network call for fetching the Data
            delay(2000)
           try {
               val user = userRep.fetchLoginData("userName", "Password")
               if (user.equals("Success")) {
                   _loginState.value = UserState(true)
                   userRep.saveUser(user.getOrThrow())
               } else {
                   _loginState.value = UserState(false)
               }
           } catch(e: Exception) {
               Log.e("FetchDataViewModel", "error while fetching the data")
           }

        }
    }

}

class UserRepository() {

    fun fetchLoginData(userName: String, password: String) : Result<String> {
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000) // simulating network call
        }
        return Result.success("Success")
    }

    fun saveUser(user: String) {
        // save the user data in shared preference
    }

    fun getUser() : String? {
        return "Success"
    }
}

data class UserState(
    val success: Boolean
)