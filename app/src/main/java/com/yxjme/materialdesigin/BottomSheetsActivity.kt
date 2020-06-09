package com.yxjme.materialdesigin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetsActivity : AppCompatActivity() {


    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheets)
        val  nested_scroll_view = findViewById<NestedScrollView>(R.id.nested_scroll_view)
        val behavior = BottomSheetBehavior.from(nested_scroll_view)
        behavior.isHideable = false
        behavior.setBottomSheetCallback(MyBottomSheetCallback())

    }


    /**
     * 回调
     */
    inner class MyBottomSheetCallback: BottomSheetBehavior.BottomSheetCallback(){
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            /**/
            Log.v("====onSlide=====","当前拖动的系数 = ${slideOffset}")
        }
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when(newState){
                /** The bottom sheet is dragging. */
                BottomSheetBehavior.STATE_DRAGGING ->{}
                /** The bottom sheet is settling. */
                BottomSheetBehavior.STATE_SETTLING ->{}
                /** The bottom sheet is expanded. */
                BottomSheetBehavior.STATE_EXPANDED ->{}
                /** The bottom sheet is collapsed. */
                BottomSheetBehavior.STATE_COLLAPSED ->{}
                /** The bottom sheet is hidden. */
                BottomSheetBehavior.STATE_HIDDEN ->{}
                /** The bottom sheet is half-expanded (used when mFitToContents is false). */
                BottomSheetBehavior.STATE_HALF_EXPANDED ->{}
            }
        }
    }



    /**
     * 点击事件
     *
     * 展示 bottom sheets
     *
     * BottomSheetDialog本身已经有个CoordinateLayout根布局，它会把你的布局文件包裹起来
     *
     * bottomSheetBehavior.isHideable  默认为true可以拖动隐藏  false一直显示在底部
     *
     * bottomSheetBehavior.isDraggable 默认为true 可以拖拽  false不可以拖拽
     *
     */
    fun btn1(v:View):Unit{
        val dialog = BottomSheetDialog(BottomSheetsActivity@this)
        val contentView  = View.inflate(BottomSheetsActivity@this,R.layout.dialog_bottom_sheets_layout,null)
        dialog.setContentView(contentView)
        val bottomSheetBehavior = BottomSheetBehavior.from(contentView.parent as View)
        bottomSheetBehavior.peekHeight = 730
        bottomSheetBehavior.isHideable = true
        bottomSheetBehavior.isDraggable = true
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        dialog.show()
    }



    /**
     *
     */
    fun btn2(v:View):Unit{

    }
}
