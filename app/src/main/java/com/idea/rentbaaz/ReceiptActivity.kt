package com.idea.rentbaaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.idea.rentbaaz.databinding.ActivityReceiptBinding

const val RECEIPT_CTA_TEXT = "RECEIPT_CTA_TEXT"

class ReceiptActivity : AppCompatActivity() {
    lateinit var binding: ActivityReceiptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_receipt)
        val cta = intent.extras?.getString(RECEIPT_CTA_TEXT) ?: "BOOKED A TABLE"
        binding.receipt.ctaText.text = cta

    }

    fun close(view: View) {
        finish()
    }
}