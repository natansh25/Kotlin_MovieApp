package infinity1087.android.com.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import infinity1087.android.com.myapplication.activity.DetailActivity
import infinity1087.android.com.myapplication.R
import infinity1087.android.com.myapplication.model.Result
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerAdapter(val contex: Context, val movies: List<Result>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(contex).inflate(R.layout.item_list, p0, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {

        return movies.size

    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        val data = movies.get(p1)
        p0.setData(data.poster_path)


    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                val result: Result = movies.get(position)

                val intent = Intent(contex, DetailActivity::class.java)
                intent.putExtra("data", result)
                contex.startActivity(intent)
            }
        }

        fun setData(path: String) {
            Log.d("image path", path)
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + path).error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_foreground).into(itemView.imageView)
        }


    }
}