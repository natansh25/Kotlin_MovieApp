package infinity1087.android.com.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import infinity1087.android.com.myapplication.R
import infinity1087.android.com.myapplication.adapter.RecyclerAdapter
import infinity1087.android.com.myapplication.model.ModieData
import infinity1087.android.com.myapplication.model.Result
import infinity1087.android.com.myapplication.service.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.function.Supplier

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = GridLayoutManager(applicationContext,2)


        recyclerView.layoutManager = layoutManager
        recyclerView.isNestedScrollingEnabled=false


        val apiServices = ApiInterface.create()
        val call = apiServices.getPopularMovies(ApiInterface.api_key)

        call.enqueue(object : Callback<ModieData> {
            override fun onFailure(call: Call<ModieData>, t: Throwable) {
            }

            override fun onResponse(call: Call<ModieData>, response: Response<ModieData>) {
                Log.d("xxx", response.raw().request().url().toString())
                val result:List<Result> = response.body()!!.results
                val adapter = RecyclerAdapter(applicationContext, result)
                recyclerView.adapter = adapter
            }
        })

    }
}
