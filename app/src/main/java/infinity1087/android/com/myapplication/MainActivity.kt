package infinity1087.android.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import infinity1087.android.com.myapplication.model.ModieData
import infinity1087.android.com.myapplication.model.Result
import infinity1087.android.com.myapplication.service.ApiClient
import infinity1087.android.com.myapplication.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val apiService:ApiInterface = ApiClient.getClient().create(ApiInterface.class)


        val apiServices = ApiInterface.create()
        val call = apiServices.getPopularMovies(ApiInterface.api_key)

        call.enqueue(object : Callback<ModieData> {
            override fun onFailure(call: Call<ModieData>, t: Throwable) {
            }

            override fun onResponse(call: Call<ModieData>, response: Response<ModieData>) {
                Log.d("xxx",response.raw().request().url().toString())
            }
        })

    }
}
