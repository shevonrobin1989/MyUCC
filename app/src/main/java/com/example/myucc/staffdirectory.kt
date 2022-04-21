package com.example.myucc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        //Launches the Directory Activity from the Image
        val directoryImage: ImageButton = findViewById(R.id.itDirectory)
        directoryImage.setOnClickListener{
            val intent = Intent(this, staffdirectory::class.java)
            startActivity(intent)
        }

        //Launches the Courses Activity from the Image
        val  coursesImage: ImageButton = findViewById(R.id.itCourses)
        coursesImage.setOnClickListener{
            val intent = Intent(this, courses::class.java)
            startActivity(intent)
        }

        //Launches the Admission Activity from the Image
        val  admissionImage: ImageButton = findViewById(R.id.itAdmission)
        admissionImage.setOnClickListener{
            val intent = Intent(this, Admission::class.java)
            startActivity(intent)
        }

        //Launches the Timetable Activity from the Image
        val  timetableImage: ImageButton = findViewById(R.id.itTimetables)
        timetableImage.setOnClickListener{
            val intent = Intent(this, timetable::class.java)
            startActivity(intent)
        }

        //Enable the user to send email to hod address when clicked
        val  menu: FloatingActionButton = findViewById(R.id.Menu)
        menu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}