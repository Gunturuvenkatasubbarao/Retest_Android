package com.ltts.registration

import DatabaseHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_Login = findViewById(R.id.btn_Login) as Button

        btn_Login.setOnClickListener {
            Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_LONG).show()
            val context =this
           val UserDetails= DatabaseHelper()
            val data=UserDetails.readData()
            var username = username.text.toString()
            var password = password.text.toString()
            if (editTextTextPersonName.text.toString().isEmpty() &&
                editTextTextPersonName2.text.toString().isEmpty()
            )
            {
                Toast.makeText(this, "enter all the details", Toast.LENGTH_SHORT).show()
            }
            for (i in 0 until data.size)
            {
                if (username == data[i].username && password == data[i].password)
                {
                    var intent = Intent(this, UserDetails::class.java)
                    startActivity(intent)
                    break;
                }

                else {
                    Toast.makeText(this, "Either password or username is incorrect", Toast.LENGTH_SHORT).show()
                }
            }

        }
            val btn_Login1 = findViewById(R.id.btn_Login1) as TextView

            btn_Login1.setOnClickListener {

                Toast.makeText(this@MainActivity, "Register here", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
        }
    }

