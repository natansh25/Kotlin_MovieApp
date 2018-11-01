package infinity1087.android.com.myapplication.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ApiClient
{
    companion object {
        internal val MOVIE_DB_URL = "http://api.themoviedb.org/3/"
        internal val API_KEY = "api_key"
        val api_key = ""
        private var retrofit: Retrofit? = null
    }

    public fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(MOVIE_DB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}