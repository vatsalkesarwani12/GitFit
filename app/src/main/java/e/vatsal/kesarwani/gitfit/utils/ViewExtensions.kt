package e.vatsal.kesarwani.gitfit.utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ScrollView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

/**
 * This function enable the visibility of View
 */
fun View.visible(): View {
    this.visibility = View.VISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

/**
 * This function hide the visibility of View
 */
fun View.inVisible(): View {
    this.visibility = View.INVISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

/**
 * This function remove the visibility of View
 */
fun View.gone(): View {
    this.visibility = View.GONE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

/**
 * This showToast fun can be called from fragment
 */
fun Fragment.showToast(message: String?) {
    Toast.makeText(this.activity, message, Toast.LENGTH_SHORT).show()
}

/**
 * This showToast fun can be called from Activity
 */
fun AppCompatActivity.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * This showToast fun can be called from context object
 */
fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * This showSnackBar fun can be called from fragment
 */
fun Fragment.showSnackBar(message: String) {
    val mParentView = this.activity!!.window.decorView.rootView
    if (mParentView != null) {
        Snackbar.make(mParentView, message, Snackbar.LENGTH_LONG).show()
    }
}

/**
 * This showSnackBar fun can be called from Activity
 */
fun AppCompatActivity.showSnackBar(message: String) {
    val mParentView = this.window.decorView.rootView
    if (mParentView != null) {
        Snackbar.make(mParentView, message, Snackbar.LENGTH_LONG).show()
    }
}

/**
 * This showSnackBar fun can be called from any view
 */
fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun AppCompatActivity.disableScreenCapture(buildType: String) {
    if (buildType == "release") {
        this.window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
        )
    }
}

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(
            this.context,
            DividerItemDecoration.VERTICAL
    )
    val drawable = ContextCompat.getDrawable(
            this.context,
            drawableRes
    )
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}

fun ScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollBy(0, delta)
}

fun NestedScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollBy(0, delta)
}

// send alpha under from 0.0f to 1.0f.
fun Context.getAlphaColor(@ColorRes color: Int, alpha: Float): Int {
    return ColorUtils.setAlphaComponent(
            ContextCompat.getColor(this, color),
            255.times(alpha).roundToInt()
    )
}

fun EditText.showSoftKeyboard() {
    postDelayed({
        if (this.requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }, 200)
}

fun AppCompatActivity.pxToDp(px: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .toInt()
}

fun Fragment.pxToDp(px: Float): Int {
    return if (activity != null && isAdded && context != null)
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
                .toInt()
    else
        px.toInt()
}

fun AppCompatButton.disableAlpha() {
    this.isEnabled = false
    this.isClickable = false
    this.alpha = 0.5f
}

fun AppCompatButton.enableWithDefaultAlpha() {
    this.isEnabled = true
    this.isClickable = true
    this.alpha = 1f
}