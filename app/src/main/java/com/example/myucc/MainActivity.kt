package com.example.myucc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val mail: String = "ucconline@ucc.edu.jm"
    private val url: String = "https://ucc.edu.jm/apply/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Launches the Directory Activity from the Image
        val directoryImage: ImageButton = findViewById(R.id.itDirectory)
        directoryImage.setOnClickListener{
            val intent = Intent(this@MainActivity, staffdirectory::class.java)
            startActivity(intent)
        }

        //Launches the Directory Activity from the Button
        val directory: Button = findViewById(R.id.btnDirectory)
        directory.setOnClickListener{
            val intent = Intent(this@MainActivity, staffdirectory::class.java)
            startActivity(intent)
        }

        //Launches the Courses Activity from the Image
        val  coursesImage: ImageButton = findViewById(R.id.itCourses)
        coursesImage.setOnClickListener{
            val intent = Intent()
            startActivity(intent)
        }

        //Launches the Courses Activity from the Button
        val  courses: Button = findViewById(R.id.btnCourse)
        courses.setOnClickListener{
            val intent = Intent()
            startActivity(intent)
        }

        //Launches the Timetable Activity from the Image
        val  timetableImage: ImageButton = findViewById(R.id.itTimetables)
        timetableImage.setOnClickListener{
            val intent = Intent()
            startActivity(intent)
        }

        //Launches the Timetable Activity from the Button
        val  timetable: Button = findViewById(R.id.btnTimetable)
        timetable.setOnClickListener{
            val intent = Intent()
            startActivity(intent)
        }

        //Launches the Admission Activity from the Image
        val  admissionImage: ImageButton = findViewById(R.id.itAdmission)
        admissionImage.setOnClickListener{
            val intent = Intent()
            startActivity(intent)
        }

        //Launches the Admission Activity from the Button
        val  admission: Button = findViewById(R.id.btnAdmission)
        admission.setOnClickListener{
            val intent = Intent()
            startActivity(intent)
        }

        //Launches the Social Media Activity from the Image
        val  socialmediaImage: ImageButton = findViewById(R.id.SocialMedia)
        socialmediaImage.setOnClickListener{
            val intent = Intent()
            startActivity(intent)
        }

        //Enable the user to send email to hod address when clicked
        val  hodEmail: FloatingActionButton = findViewById(R.id.Email)
        hodEmail.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",mail,null))
            intent.putExtra(Intent.EXTRA_EMAIL, mail)
            startActivity(intent)
        }

    }
}