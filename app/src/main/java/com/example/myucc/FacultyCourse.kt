package com.example.myucc

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FacultyCourse: AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private var courseCode: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        val index: String? = this.intent.getStringExtra("courseIndex")

        when(index){
            "0"->{
                courseCode= "ITT201"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "1"->{
                courseCode= "ITT403"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "2"->{
                courseCode= "ITT313"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "3"->{
                courseCode= "ITT301"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "4"->{
                courseCode= "GIS300"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "5"->{
                courseCode= "ITT303"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "6"->{
                courseCode= "ITT312"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "7"->{
                courseCode= "ITT410"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "8"->{
                courseCode= "ITT309"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
            "9"->{
                courseCode= "ITT422"
                if (courseCode.isNotEmpty())
                {
                    readdata(courseCode)
                }
                else
                {
                    Toast.makeText(this,"No course code info provided.",Toast.LENGTH_SHORT).show()
                }
            }
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

    private fun readdata(courseCode: String) {

        database = FirebaseDatabase.getInstance().getReference("Courses")
        database.child(courseCode).get().addOnSuccessListener {
            if(it.exists()){

                val code = it.child("courseCode").value
                val name = it.child("courseName").value
                val credit = it.child("courseCredit").value
                val cRequiste = it.child("preRequiste").value
                val cDescription = it.child("description").value

                val cName: TextView = findViewById(R.id.CourseName)
                val cCode: TextView = findViewById(R.id.CourseCode)
                val cCredit: TextView = findViewById(R.id.CourseCredit)
                val cPrerequite: TextView = findViewById(R.id.CoursePrerequiste)
                val cDescript: TextView = findViewById(R.id.CourseDescription)
                cName.text = name.toString()
                cCode.text = code.toString()
                cCredit.text = credit.toString()
                cPrerequite.text = cRequiste.toString()
                cDescript.text = cDescription.toString()

            }
            else
            {
               Toast.makeText(this,"This course is no longer offered our has been rename.",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this,"Failed to retrieve data from database",Toast.LENGTH_SHORT).show()
        }
    }
}