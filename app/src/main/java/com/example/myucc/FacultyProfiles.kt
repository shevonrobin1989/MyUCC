package com.example.myucc

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.net.Uri
import androidx.core.app.ActivityCompat

class FacultyProfiles: AppCompatActivity() {
    private var mail: String = ""
    private var call: String = ""
    val REQUEST_PHONE_CALL = 1

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val index: String? = this.intent.getStringExtra("listIndex")

        val facultyImage: ImageView = findViewById(R.id.ProfileImage)
        val facultyName: TextView = findViewById(R.id.ProfileName)
        val facultyEmail: TextView = findViewById(R.id.ProfileEmail)
        val facultyContact: TextView = findViewById(R.id.ProfileContact)
        val facultyTitle: TextView = findViewById(R.id.title)

        when(index){
            "0" -> {
                facultyName.text = "Ms. Natalie Rose, HOD"
                facultyEmail.text = "ithod@ucc.edu.jm"
                facultyContact.text = "876-906-4046"
                facultyTitle.text = "Head of Department"
                facultyImage.setImageResource(R.drawable.natalierose)
                mail = "ithod@ucc.edu.jm"
                call = "8769064046"
            }
            "1" -> {
                facultyName.text = "Ms. Winsome Bennett"
                facultyEmail.text = "itprogrammecoordinator@ucc.edu.jm"
                facultyContact.text = "876-906-4045"
                facultyTitle.text = "Programme Co-ordinator"
                facultyImage.setImageResource(R.drawable.wisomebennett)
                mail = "itprogrammecoordinator@ucc.edu.jm"
                call = "8769064045"
            }
            "2" -> {
                facultyName.text = "Mr. Elton Austin"
                facultyEmail.text = "itprogrammeofficer@ucc.edu.jm"
                facultyContact.text = "876-906-4044"
                facultyTitle.text = "Programme Officer"
                facultyImage.setImageResource(R.drawable.eltonaustin)
                mail = "itprogrammeofficer@ucc.edu.jm"
                call = "8769064044"
            }
            "3" -> {
                facultyName.text = "Mrs. Naomi Uffer-Collington"
                facultyEmail.text = "itadminassistant@ucc.edu.jm"
                facultyContact.text = "876-906-4043"
                facultyTitle.text = "Administrative Assistant"
                facultyImage.setImageResource(R.drawable.naomiuffer)
                mail = "itadminassistant@ucc.edu.jm"
                call = "8769064043"

            }
            "4" -> {
                facultyName.text = "Mr. Otis Osbourne"
                facultyEmail.text = "itfaculty@ucc.edu.jm"
                facultyContact.text = "876-906-4042"
                facultyTitle.text = "Full-Time Lecturer"
                facultyImage.setImageResource(R.drawable.otisosbourne)
                mail = "itfaculty@ucc.edu.jm"
                call = "8769064042"

            }
            "5" -> {
                facultyName.text = "Ms. Karen Wilson"
                facultyEmail.text = "itlecturer@ucc.edu.jm"
                facultyContact.text = "876-906-4041"
                facultyTitle.text = "Adjunct Lecturer"
                facultyImage.setImageResource(R.drawable.karenwilson)
                mail = "itlecturer@ucc.edu.jm"
                call = "8769064041"
            }
        }

        val sendCall: FloatingActionButton = findViewById(R.id.facultyPhone)
        sendCall.setOnClickListener{
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
            }
            else
            {
                startcall()
            }
        }

        //Sends email to preset address when FAB is clicked
        val sendEmail: FloatingActionButton = findViewById(R.id.facultyEmail)
        sendEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",mail,null))
            startActivity(Intent(Intent.createChooser(intent, "Send Email..")))
        }



    }
    private fun startcall()
    {
        val dialIntent = Intent(Intent.ACTION_CALL)
        dialIntent.data = Uri.parse("tel:" + call)
        startActivity(dialIntent)
    }


}