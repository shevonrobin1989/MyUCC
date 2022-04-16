package com.example.myucc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class Admission: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)
        InfoPage()
        Hyperlink()
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