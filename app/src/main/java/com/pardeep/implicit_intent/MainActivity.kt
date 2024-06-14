package com.pardeep.implicit_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // declaration variable here
    var call_button : Button? = null
    var email_button : Button? = null
    var sms_button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // initiliazation the var
        call_button = findViewById(R.id.Callme)
        email_button = findViewById(R.id.emailme)
        sms_button = findViewById(R.id.sms)

        call_button?.setOnClickListener(){

          val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:+918968531504"))

            startActivities(arrayOf(intent))
        }

        email_button?.setOnClickListener(){

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL , arrayOf("maheyp666@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT,"Error issue")
            intent.putExtra(Intent.EXTRA_TEXT,"crash when click on 'email me' button")
            
            startActivities(arrayOf(intent))

        }

        sms_button?.setOnClickListener()
        {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("smsto:8968531504"))
            intent.putExtra("sms_body","hello")

            startActivities(arrayOf(intent))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}