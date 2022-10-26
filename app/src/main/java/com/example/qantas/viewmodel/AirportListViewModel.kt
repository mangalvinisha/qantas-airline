package com.example.qantas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qantas.model.AirportData
import com.example.qantas.services.RetrofitService
import kotlinx.coroutines.*

class AirportListViewModel
constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val responseList = MutableLiveData<ArrayList<AirportData>>()
    var job: Job? = null
    val loading = MutableLiveData<Boolean>()

    fun fetchData() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getFlightList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    responseList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getFlightList() = retrofitService.getAirportData()

}
