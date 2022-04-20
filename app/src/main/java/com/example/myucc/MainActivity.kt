package com.example.myucc

import android.content.Intent
import android.content.ActivityNotFoundException
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val mail: String = "ithod@ucc.edu.jm"
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
            val intent = Intent(this@MainActivity, courses::class.java)
            startActivity(intent)
        }

        //Launches the Courses Activity from the Button
        val  courses: Button = findViewById(R.id.btnCourse)
        courses.setOnClickListener{
            val intent = Intent(this@MainActivity, com.example.myucc.courses::class.java)
            startActivity(intent)
        }

        //Launches the Timetable Activity from the Image
        val  timetableImage: ImageButton = findViewById(R.id.itTimetables)
        timetableImage.setOnClickListener{
            val intent = Intent(this@MainActivity, timetable::class.java)
            startActivity(intent)
        }

        //Launches the Timetable Activity from the Button
        val  timetable: Button = findViewById(R.id.btnTimetable)
        timetable.setOnClickListener{
            val intent = Intent(this@MainActivity, com.example.myucc.timetable::class.java)
            startActivity(intent)
        }

        //Launches the Admission Activity from the Image
        val  admissionImage: ImageButton = findViewById(R.id.itAdmission)
        admissionImage.setOnClickListener{
            val intent = Intent(this@MainActivity, Admission::class.java)
            startActivity(intent)
        }

        //Launches the Admission Activity from the Button
        val  admission: Button = findViewById(R.id.btnAdmission)
        admission.setOnClickListener{
            val intent = Intent(this@MainActivity, Admission::class.java)
            startActivity(intent)
        }

        val ivfacebook: ImageButton = findViewById(R.id.facebook_link)
        val ivinstagram: ImageButton = findViewById(R.id.instagram_link)
        val ivtwitter: ImageButton = findViewById(R.id.twitter_link)

        //Launches the Social Media Activity from the Image
        ivfacebook.setOnClickListener{
            val sAppLink = "fb://page/237564710351658"
            val sPackage = "com.facebook.katana"
            val sWebLink = "https://www.facebook.com/uccjamaica/"
            openLink(sAppLink, sPackage, sWebLink)
        }
        ivinstagram.setOnClickListener{
            val sAppLink = "https://www.instagram.com/androidcoding_"
            val sPackage = "com.instagram.android"
            val sWebLink = "https://www.instagram.com/uccjamaica/?hl=en"
            openLink(sAppLink, sPackage, sWebLink)
        }
        ivtwitter.setOnClickListener{
            val sAppLink = "twitter://user?screen_name=AndroidCoding_"
            val sPackage = "com.twitter.android"
            val sWebLink = "https://twitter.com/UCCjamaica"
            openLink(sAppLink, sPackage, sWebLink)
        }

        //Enable the user to send email to hod address when clicked
        val  hodEmail: FloatingActionButton = findViewById(R.id.Email)
        hodEmail.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",mail,null))
            startActivity(Intent(Intent.createChooser(intent, "Send Email..")))
        }


    }
    private fun openLink(sAppLink: String, sPackage: String, sWebLink: String) {
        try {
            val uri = Uri.parse(sAppLink)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.setPackage(sPackage)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } catch (activityNotFoundException: ActivityNotFoundException) {
            val uri = Uri.parse(sWebLink)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}