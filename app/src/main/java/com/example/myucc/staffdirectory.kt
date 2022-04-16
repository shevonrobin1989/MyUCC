package com.example.myucc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class staffdirectory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staffdirectory)

        val facultyList: Array<String> = resources.getStringArray(R.array.facultyStaff)

        val adapter = ArrayAdapter<String>(this, R.layout.row, facultyList)

        val listView: ListView = findViewById(R.id.FacultyList)

        listView.adapter = adapter

        listView.setOnItemClickListener{ parent, view, position, id ->

            val intent = Intent(this, FacultyProfiles::class.java);

            intent.putExtra("listIndex", position.toString());

            this.startActivity(intent);

        }
    }
}