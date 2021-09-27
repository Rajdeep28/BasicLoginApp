package com.example.basicloginapp.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicloginapp.RecyclerList
import com.example.basicloginapp.network.RetroInstance
import com.example.basicloginapp.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewActivityViewModel: ViewModel() {
    lateinit var recyclerList: MutableLiveData<RecyclerList>

    init {
        recyclerList = MutableLiveData()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList>{
        return recyclerList
    }
    fun makeApiCall(input: String){
        val retroInstance = RetroInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromApi(input)
        call.enqueue(object : Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful) {
                   // recyclerViewAdapter.setListData(response.body()?.items!!)
                   // recyclerViewAdapter.notifyDataSetChanged()
                    recyclerList.postValue(response.body())

                }
                else{
                    recyclerList.postValue(null)
                }
            }
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
               // Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
                recyclerList.postValue(null)
            }
        })
    }
}