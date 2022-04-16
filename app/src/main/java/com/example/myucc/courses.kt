package com.example.myucc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class courses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

            val courseList: Array<String> = resources.getStringArray(R.array.facultyCourses)
            val adapter = ArrayAdapter<String>(this, R.layout.row, courseList)

            val listView: ListView = findViewById(R.id.CourseList)

            listView.adapter = adapter

            listView.setOnItemClickListener { parent, view, position, id ->

                val intent = Intent(this, FacultyCourse::class.java);

                intent.putExtra("courseIndex", position.toString());

                this.startActivity(intent);
            }

    }
}