package com.yxjme.materialdesigin

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CollapsingToolbarsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbars)

        val mRecyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)
        val layoutManager = LinearLayoutManager(CollapsingToolbarsActivity@this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = MyAdpater(this,R.layout.item_main_layout,list.size)
    }


    val list = mutableListOf<String>()
        .apply {
            add("大声道发0")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
            add("大声道发")
        }


    inner class MyAdpater(ctn: Context, itemView: Int, size: Int) : BaseAdapter(ctn, itemView, size){
        private var tv : TextView? = null
        @SuppressLint("WrongViewCast")
        override fun findViewHolder(itemView: View) {
            tv = itemView.findViewById<TextView>(R.id.textTitle)
        }
        override fun childBindViewHolder(holder: MyViewHolder, p: Int) {
            tv?.text = list[p]
        }
    }
}
