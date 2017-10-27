package com.bmpl.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter : BaseAdapter{

    var context: Context
    private var layoutInflater : LayoutInflater

    var array = arrayOf("Data 1","Data 2", "Data 3",
                        "Data 4","Data 5", "Data 6",
                        "Data 7","Data 8", "Data 9",
                        "Data 10","Data 11", "Data 12")

    var images = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher)


    override fun getView(p0: Int, view: View?, viewGroup: ViewGroup?): View {

        var viewHolder = ViewHolder()

        var v  : View = layoutInflater.inflate(R.layout.adapter_custom, viewGroup, false)

        viewHolder.textView = v.findViewById(R.id.textView) as TextView

        viewHolder.textView.setCompoundDrawablesRelativeWithIntrinsicBounds(images[p0], 0, 0, 0)
        viewHolder.textView.text = array[p0]
        return v
    }

    override fun getItem(p0: Int): Any {
        return images[p0]
    }

    override fun getItemId(p0: Int): Long {
    return p0.toLong()
    }

    override fun getCount(): Int {
    return images.size
    }

    constructor(mainActivity: MainActivity){
        context = mainActivity
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    class ViewHolder{
        lateinit var textView : TextView
    }

}