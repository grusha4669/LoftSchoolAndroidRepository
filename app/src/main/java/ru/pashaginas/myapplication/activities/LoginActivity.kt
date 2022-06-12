package ru.pashaginas.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import ru.pashaginas.myapplication.R


class LoginActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 17
    }

    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    fun onClick(view: View) {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            account.idToken
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } catch (e: ApiException) {
            if (
                e.statusCode == 401
            ){
                Toast.makeText(this, "Not authorized", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, "signInResult:failed code=" + e.localizedMessage, Toast.LENGTH_SHORT)
                .show()
        }
    }
}
