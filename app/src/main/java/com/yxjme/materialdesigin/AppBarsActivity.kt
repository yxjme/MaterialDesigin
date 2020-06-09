package com.yxjme.materialdesigin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar

class AppBarsActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bars)

        val bottom_app_bar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        bottom_app_bar.setNavigationOnClickListener {
            when(it.id){
                R.id.one ->{
                    Snackbar.make(bottom_app_bar,"測試one",Snackbar.LENGTH_LONG).show()
                }
                R.id.twe ->{
                    Snackbar.make(bottom_app_bar,"測試twe",Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}
