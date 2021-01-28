package com.idea.rentbaaz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.idea.rentbaaz.databinding.ActivityDiscoveryScreenBinding
import java.net.URL

class DiscoveryScreen : AppCompatActivity() {

    private lateinit var binding: ActivityDiscoveryScreenBinding
    private var mGoogleSignInClient : GoogleSignInClient? = null
    lateinit var adapter: DiscoveryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_discovery_screen)
        setUpPubList()

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val acct = GoogleSignIn.getLastSignedInAccount(this)

        if(acct != null) {
            val personName = acct.displayName
            binding.customerName.text = personName
//            val personEmail = acct.email
//            person_email.setText(personEmail)
//            val personId = acct.id
//            person_id.setText(personId)
        }
    }


    private fun setUpPubList() {
        adapter = DiscoveryAdapter(this)
        adapter.setData(
            listOf(
                PubItem("Toit", "Beer", "4KM") {
                    startActivity(
                        Intent(
                            this,
                            PubDetailActivity::class.java
                        )
                    )
                },
                PubItem("Toit", "Beer", "4KM") {
                    startActivity(
                        Intent(
                            this,
                            PubDetailActivity::class.java
                        )
                    )
                },
                PubItem("Toit", "Beer", "4KM") {
                    startActivity(
                        Intent(
                            this,
                            PubDetailActivity::class.java
                        )
                    )
                })
        )
        binding.pubList.layoutManager = LinearLayoutManager(this)
        binding.pubList.adapter = this.adapter
    }

    fun launchCalendarBottomSheet(view: View) {
        CalendarBottomSheet.newInstance("", "", supportFragmentManager)
    }

    fun launchGoogleMaps(view: View) {
        startActivity(Intent(this, MapViewActivity::class.java))

//        val uri = Uri.parse("https://www.google.co.in/maps/dir/" + "kormangala" + "/indiranagar")
//        val intent = Intent(Intent.ACTION_VIEW, uri)
//        intent.setPackage("com.google.android.apps.maps")
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        mapView.loadUrl(uri.toString())
//        startActivity(intent)
    }

    fun signOut(view: View){
        mGoogleSignInClient?.signOut()?.addOnCompleteListener(this
        ) { val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()}


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}