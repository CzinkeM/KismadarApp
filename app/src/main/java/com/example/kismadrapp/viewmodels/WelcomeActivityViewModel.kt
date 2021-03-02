package com.example.kismadrapp.viewmodels

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.AndroidViewModel
import com.example.kismadrapp.R
import com.google.zxing.integration.android.IntentIntegrator

class WelcomeActivityViewModel(application: Application) : AndroidViewModel(application) {

    fun createDialogWindow(itemId: Int, layoutInflater: LayoutInflater, context: Context) {
        when (itemId) {
            R.id.menuItemAbout -> {
                val dialogBuilder = AlertDialog.Builder(context)
                val languagePopupView = layoutInflater.inflate(R.layout.layout_setting_about, null)
                dialogBuilder.setView(languagePopupView)
                val closeButton = languagePopupView.findViewById<Button>(R.id.settingAboutClose)
                val dialog = dialogBuilder.create()
                dialog.show()
                closeButton.setOnClickListener {
                    Toast.makeText(context, "Close", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        }
    }
    fun openQrCodeReader(activity: Activity){
        val scanner = IntentIntegrator(activity)
        scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
        scanner.setBeepEnabled(false)
        scanner.initiateScan()
    }
}