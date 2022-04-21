package com.example.myucc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Admission: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)
        InfoPage()
        Hyperlink()

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
    private fun InfoPage() {
        val requirements: Array<String> = resources.getStringArray(R.array.admissionRequirement)
        val admit = findViewById<ListView>(R.id.RequirementsList)
        val adapter = ArrayAdapter<String>(this,R.layout.content,requirements)
        admit.adapter = adapter

    }
    fun Hyperlink(){
        val link = findViewById<TextView>(R.id.tvApply)
        link.setMovementMethod(LinkMovementMethod.getInstance())
    }
}