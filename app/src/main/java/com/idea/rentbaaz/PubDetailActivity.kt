package com.idea.rentbaaz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.idea.rentbaaz.databinding.ActivityPubDetailBinding
import com.idea.rentbaaz.pubdetailFront.PubDetailFrontAdapter
import com.idea.rentbaaz.pubdetailitem.PubDetailItemAdapter

class PubDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityPubDetailBinding
    lateinit var adapter: PubDetailFrontAdapter
    var imageList = intArrayOf(R.drawable.receipt, R.drawable.r2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pub_detail)
        for (image in imageList) {
            val imageView = ImageView(this)
            val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutParams.setMargins(0, 0, 0, 0)

            imageView.layoutParams = layoutParams
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            imageView.setImageResource(image)
            binding.viewFlipper.addView(imageView)

        }
        binding.viewFlipper.isAutoStart = true
        adapter = PubDetailFrontAdapter(this)
        adapter.setData(getPubFrontItem())
        binding.pubList.adapter = adapter
        binding.pubList.layoutManager = LinearLayoutManager(this)
    }

    fun previousView(v: View) {
        binding.viewFlipper.showPrevious()
    }


    fun nextView(v: View) {
        binding.viewFlipper.showNext()
    }

    fun onBackPress(v: View) {
        finish()
    }

    fun getPubFrontItem(): List<PubItems> {
        return listOf(
            PubHeader("Church Street", "Kormangala"),
            PubDetailFrontItem(
                getListPubDetailItem1(), PubDetailItemAdapter(this).apply {
                    setData(getListPubDetailItem1())
                }, "EVENTS", "Vertical"
            ),
            PubDetailFrontItem(getListPubDetailItem(), PubDetailItemAdapter(this).apply {
                setData(getListPubDetailItem())
            }, "OFFERS", "Vertical"),
            PubDetailFrontItem(
                getListPubDetailItem2(), PubDetailItemAdapter(this).apply {
                    setData(getListPubDetailItem2())
                }, "SPECIALITY", "Grid"
            )

        )
    }


    fun getListPubDetailItem(): List<PubDetailItem> {
        return listOf(
            OfferItem("offer1", "d1") {startActivity(Intent(this, OfferInfoActivity::class.java))},
            OfferItem("offer1", "d1"){startActivity(Intent(this, OfferInfoActivity::class.java))},
            OfferItem("offer1", "d1"){startActivity(Intent(this, OfferInfoActivity::class.java))}
        )
    }

    fun getListPubDetailItem1(): List<PubDetailItem> {
        return listOf(
            EventItem("event1", 20.0, "SUN", "1", "2", "21" ) { startActivity(Intent(this, EventInfoActivity::class.java))},
            EventItem("event1", 20.0, "SUN", "1", "2", "21") { startActivity(Intent(this, EventInfoActivity::class.java))},
            EventItem("event1", 20.0, "SUN", "1", "2", "21") { startActivity(Intent(this, EventInfoActivity::class.java))}
        )
    }

    fun getListPubDetailItem2(): List<PubDetailItem> {
        return listOf(
            SpecialityItem("speciality1", "des", "img", "tag"),
            SpecialityItem("speciality1", "des", "img", "tag"),
            SpecialityItem("speciality1", "des", "img", "tag"),
            SpecialityItem("speciality1", "des", "img", "tag")
        )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    fun confirmBooking(view: View) {
        val intent = Intent(this, ReceiptActivity::class.java)
        intent.putExtra(RECEIPT_CTA_TEXT, "BOOKED A TABLE")
        finish()
        startActivity(intent)
    }

}