package com.android.planotest.base

import android.content.DialogInterface
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.android.planotest.T

open class BaseActivity : AppCompatActivity(),DialogInterface.OnShowListener{
    private val mLoadingDialog by lazy {
        val dialog = LoadingDialog(this)
        dialog.setOnShowListener(this)
        dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AccountApplication.addActivity(this)
        super.onCreate(savedInstanceState)
    }

    fun showLoading() {
        if (!mLoadingDialog.isShowing) {
            mLoadingDialog.show()
        }
    }

    fun hideLoading() {
        mLoadingDialog.dismiss()
    }

    fun showToast(toast: String) {
        T.showToast(toast)
    }

    override fun onDestroy() {
        AccountApplication.removeActivity(this)
        super.onDestroy()
    }

    private fun hideInput() {
        val im = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val v = window.peekDecorView()
        if (null != v) {
            im.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }

    override fun onShow(dialog: DialogInterface?) {
        hideInput()
    }

}
