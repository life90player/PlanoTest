package com.android.planotest.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.android.planotest.R

class LoadingDialog public constructor(context: Context) : AlertDialog(context, R.style.dialog) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }
}
