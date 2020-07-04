package com.example.android.tacorando.taco

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.tacorando.network.TacoApi
import com.example.android.tacorando.network.TacoItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TacoViewModel : ViewModel() {

    // The internal MutableLiveData String that stroes the status of the most recent request
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    /**
     * Call getPlaidDataValues on init so that we can display status immediately
     */
    init {
        getTacoRecipes()
    }

    private fun getTacoRecipes() {
        // Call the TacoApi to enqueue the Retrofit request, implementing the callbacks
        TacoApi.retrofitService.getTaco().enqueue(object: Callback<List<TacoItem>> {
            override fun onFailure(call: Call<List<TacoItem>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<List<TacoItem>>, response: Response<List<TacoItem>>) {
                _response.value = response.body()?.get(0).toString()
            }
        })
    }
}