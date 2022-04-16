package com.example.myucc

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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