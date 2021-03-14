package com.ratobing.listview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.ratobing.listview.adapter.PersonAdapter
import com.ratobing.listview.models.Person

class ListViewActivity : AppCompatActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var persons = arrayListOf<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = PersonAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()


        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, persons[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare(){
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices){
            val person = Person(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position],
            )
            persons.add(person)
        }
        adapter.person = persons
    }


}