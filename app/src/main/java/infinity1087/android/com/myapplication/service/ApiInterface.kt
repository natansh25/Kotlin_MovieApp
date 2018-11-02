package infinity1087.android.com.myapplication.service

import infinity1087.android.com.myapplication.model.ModieData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {


    @GET("movie/{filter}")
    fun getMovies(@Path("filter") filter: String, @Query("api_key") apiKey: String): Call<ModieData>

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<ModieData>


    companion object {
        internal val MOVIE_DB_URL = "http://api.themoviedb.org/3/"
        internal val API_KEY = "api_key"
        val api_key = ""
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(MOVIE_DB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }


}

