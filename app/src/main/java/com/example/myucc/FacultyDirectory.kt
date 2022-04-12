package com.example.myucc

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FacultyDirectory: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)

        val facultyList: Array<String> = resources.getStringArray(R.array.facultyStaff)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, facultyList)

        val listView: ListView = findViewById(R.id.FacultyList)

        listView.adapter = adapter

        listView.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, "Clicked item : " + position, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, FacultyProfiles::class.java);

            intent.putExtra("listIndex", position.toString());

            this.startActivity(intent);

        }
    }
}