package e.vatsal.kesarwani.gitfit.app

import android.app.Application
import com.facebook.stetho.BuildConfig
import com.facebook.stetho.Stetho
import e.vatsal.kesarwani.gitfit.utils.timber.DebugTree
import e.vatsal.kesarwani.gitfit.utils.timber.ReleaseTree
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setDebugTools()
    }

    private fun setDebugTools() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
            Stetho.initializeWithDefaults(this)
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}