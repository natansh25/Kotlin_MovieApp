package infinity1087.android.com.myapplication.activity

import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.ActionBar
import android.util.Log
import infinity1087.android.com.myapplication.R
import infinity1087.android.com.myapplication.model.Result

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ActionBar.DISPLAY_SHOW_HOME

        var result: Result = intent.getParcelableExtra("data")


    }
}
