package e.vatsal.kesarwani.gitfit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import e.vatsal.kesarwani.gitfit.R
import e.vatsal.kesarwani.gitfit.ui.user.UserActivity

class SplashActivity : AppCompatActivity() {

    companion object{
        private const val TIME_DELAY = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out )
                UserActivity.start(this)
                finish()
            },
            TIME_DELAY
        )
    }

    override fun onDestroy() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onDestroy()
    }
}