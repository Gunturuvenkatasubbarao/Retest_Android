package com.ltts.registration

import DataBaseHandler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setContentView(R.layout.activity_main)

        val context = this
        val db = DataBaseHandler(context)
        btn_submit.setOnClickListener {
            if (username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && phonenumber.text.toString().isNotEmpty()) {
                val user= User(username.text.toString(), password.text.toString(),email.text.toString(),phonenumber.text.toString().toInt())
                db.insertData(user)

            }
            else {
                Toast.makeText(context, "Enter all the data", Toast.LENGTH_SHORT).show()
            }
        }


}
}