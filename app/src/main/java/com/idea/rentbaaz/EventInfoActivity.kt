package com.idea.rentbaaz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EventInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)
    }


    fun onClick(v: View) {
        finish()
    }

    fun confirmBooking(view: View) {
        val intent = Intent(this, ReceiptActivity::class.java)
        intent.putExtra(RECEIPT_CTA_TEXT, "BOOKED AN EVENT")
        finish()
        startActivity(intent)
    }
}