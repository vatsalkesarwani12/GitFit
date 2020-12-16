package e.vatsal.kesarwani.gitfit.utils.timber

import timber.log.Timber

class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
    }

    override fun e(t: Throwable?) {
        super.e(t)
    }
}