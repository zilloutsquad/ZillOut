package com.idea.rentbaaz

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException


class MainActivity : AppCompatActivity() {
    private val RC_SIGN_IN = 1
    private val LOGIN = 2
    lateinit var btnSignIn : SignInButton
    private var mGoogleSignInClient: GoogleSignInClient? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        btnSignIn = findViewById<View>(R.id.btn_sign_in) as SignInButton
        btnSignIn.setOnClickListener(View.OnClickListener {
            signIn()
        })

        val account = GoogleSignIn.getLastSignedInAccount(this)

        if(account!=null) {
            val intent = Intent(this, DiscoveryScreen::class.java)
            startActivityForResult(intent, LOGIN)
        }
    }



    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account : GoogleSignInAccount? = task.getResult(ApiException::class.java)

                val intent = Intent(this, DiscoveryScreen::class.java)
                finish()
                startActivity(intent)

            } catch (e: ApiException) {
                // The ApiException status code indicates the detailed failure reason.
                // Please refer to the GoogleSignInStatusCodes class reference for more information.
                Log.e("TAG","signInResult:failed code=" + e.statusCode)
            }
        }
        else
            finish()
    }

    fun signIn() {
        val intent = mGoogleSignInClient!!.signInIntent
        startActivityForResult(intent, RC_SIGN_IN)
    }


}
