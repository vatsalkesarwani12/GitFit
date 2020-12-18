package e.vatsal.kesarwani.gitfit.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.facebook.stetho.Stetho
import e.vatsal.kesarwani.gitfit.BuildConfig
import e.vatsal.kesarwani.gitfit.R
import e.vatsal.kesarwani.gitfit.utils.SharedPref
import e.vatsal.kesarwani.gitfit.utils.timber.DebugTree
import e.vatsal.kesarwani.gitfit.utils.timber.ReleaseTree
import timber.log.Timber

class MyApplication : Application() {

    //todo add animation on screen change

    //todo theme switch in the appbar

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate() {
        super.onCreate()

        sharedPreferences = getSharedPreferences(SharedPref.SHARED_PREF.name, Context.MODE_PRIVATE)

        setTheme()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private fun setTheme() {
        if (sharedPreferences.getBoolean(SharedPref.IS_DARK_MODE.name, true))
            setTheme(R.style.Theme_GitFit_Dark)
        else
            setTheme(R.style.Theme_GitFit_Light)
    }

}