package infinity1087.android.com.myapplication.activity

import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.ActionBar
import android.support.v7.view.SupportActionModeWrapper
import android.util.Log
import android.view.MenuItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import infinity1087.android.com.myapplication.R
import infinity1087.android.com.myapplication.model.Result
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var result: Result = intent.getParcelableExtra("data")

        val rating: Int = (result.vote_count)
        val cal = 5 * rating / 10

        ratingbar.rating = cal.toFloat()

        Picasso.get().load("https://image.tmdb.org/t/p/w500" + result.backdrop_path).into(img_backDrop)
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + result.poster_path).into(img_poster)

        txt_title.text = result.title
        txt_plot.text = result.overview
        txt_releaseDate.text = result.release_date


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item!!.itemId == android.R.id.home) {
            finish()
            true
        } else {

            super.onOptionsItemSelected(item)
        }


    }
}
