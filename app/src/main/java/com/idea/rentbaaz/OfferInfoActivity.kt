package com.idea.rentbaaz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OfferInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_offer_detail)
    }

    fun onBack(v: View) {
        finish()
    }

    fun confirmBooking(view: View) {
        val intent = Intent(this, ReceiptActivity::class.java)
        intent.putExtra(RECEIPT_CTA_TEXT, "OFFER REDEEMED")
        finish()
        startActivity(intent)
    }
}