package e.vatsal.kesarwani.gitfit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import e.vatsal.kesarwani.gitfit.R
import e.vatsal.kesarwani.gitfit.ui.user.UserActivity

class SplashActivity : AppCompatActivity() {

    //todo splash with motion layout

    companion object{
        private const val TIME_DELAY = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                UserActivity.start(this)
                finish()
            },
            TIME_DELAY
        )
    }
}