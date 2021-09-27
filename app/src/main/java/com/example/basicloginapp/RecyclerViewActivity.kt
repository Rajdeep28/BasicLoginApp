package com.example.basicloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.basicloginapp.network.RetroInstance
import com.example.basicloginapp.network.RetroService
import com.example.basicloginapp.viewmodel.RecyclerViewActivityViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            var decoration = DividerItemDecoration(applicationContext,VERTICAL)
            addItemDecoration(decoration)
        }
    }

    fun createData(){
      //  var item = ArrayList<RecyclerData>()

       /* item.add(RecyclerData("Java","Java Description"))
        item.add(RecyclerData("C","C Description"))
        item.add(RecyclerData("C++","C++ Description"))
        item.add(RecyclerData("Kotlin","Kotlin Description"))
        item.add(RecyclerData("Android","Android Description"))
        item.add(RecyclerData("IOS","Ios Description",))*/
        /*item.add("C")
        item.add("C++")
        item.add("Kotlin")
        item.add("Android")
        item.add("IOS")*/

        /*recyclerViewAdapter.setListData(item)
        recyclerViewAdapter.notifyDataSetChanged()*/

       /* val retroInstance = RetroInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromApi("newyork")
        call.enqueue(object : Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful) {
                    recyclerViewAdapter.setListData(response.body()?.items!!)
                    recyclerViewAdapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })*/

        var viewModel = ViewModelProviders.of(this).get(RecyclerViewActivityViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this,Observer<RecyclerList>{
            if (it != null){
                recyclerViewAdapter.setListData(it.items)
                recyclerViewAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })
        searchButton.setOnClickListener {
            viewModel.makeApiCall(searchBoxId.text.toString())
        }
    }
}