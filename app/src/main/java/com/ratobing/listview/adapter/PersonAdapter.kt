package com.ratobing.listview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ratobing.listview.R
import com.ratobing.listview.models.Person

class PersonAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var person = arrayListOf<Person>()

    override fun getCount(): Int = person.size

    override fun getItem(position: Int): Any = person[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val person = getItem(position) as Person
        viewHolder.bind(person)
        return itemView
    }


    private inner class ViewHolder internal constructor(view: View){
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)

        internal fun bind(person: Person){
            txtName.text = person.name
            txtDescription.text = person.description
            imgPhoto.setImageResource(person.photo)
        }
    }

}