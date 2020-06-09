package com.yxjme.materialdesigin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    /*列表数据*/
    var list = mutableListOf<String>().apply {
        add("App bars: top")
        add("Bottom Sheets")
        add("Buttons")
        add("MaterialCardView")
        add("Collapsing Toolbars")
        add("Navigation Views")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.actionBar?.title = getString(R.string.main_text)

        val layoutManager = LinearLayoutManager(MainActivity@this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mainRecyclerView.layoutManager = layoutManager
        mainRecyclerView.adapter = MyAdapter(MainActivity@ this, R.layout.item_main_layout, list.size)
    }




    inner class MyAdapter(ctn: Context, itemView: Int, count: Int) : BaseAdapter(ctn, itemView, count){
        var textTitle :TextView ?= null
        override fun findViewHolder(itemView: View) {
             textTitle =  itemView.findViewById(R.id.textTitle)
        }
        override fun childBindViewHolder(holder: MyViewHolder, p: Int) {
            textTitle?.text = list[p]
            textTitle?.setOnClickListener{
                toDoTask(p)
            }
        }
    }


    /**
     */
    private fun toDoTask(position: Int) {
        when(position){
            0->{toActivity(AppBarsActivity::class.java)}
            1->{toActivity(BottomSheetsActivity::class.java)}
            2->{toActivity(ButtonsActivity::class.java)}
            3->{toActivity(MaterialCardViewActivity::class.java)}
            4->{toActivity(CollapsingToolbarsActivity::class.java)}
            5->{toActivity(NavigationViewsActivity::class.java)}
        }
    }



    /**
     *
     */
    private fun toActivity(cls:Class<*>) {
        startActivity(Intent(MainActivity@this,cls))
    }
}
