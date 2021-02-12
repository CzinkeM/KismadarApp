package com.example.kismadrapp

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class WelcomeActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    private lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navView)
        setMenuItemClickListener(navigationView)

        supportActionBar?.hide()
    }

    fun openDrawer() {
        drawerLayout.openDrawer(Gravity.LEFT)
    }
    private fun setMenuItemClickListener(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuItemAbout -> {
                    createDialogWindow(item.itemId)
                    Toast.makeText(this, "about", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.menuItemContact ->{
                    createDialogWindow(item.itemId)
                    Toast.makeText(this, "contact", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.menuItemLanguage ->{
                    createDialogWindow(item.itemId)
                    Toast.makeText(this, "language", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                else -> {
                    Toast.makeText(this, "Else happened", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
            }
        }
    }
    private fun createDialogWindow(itemId: Int){
        val dialogBuilder: AlertDialog.Builder
        val languagePopupView: View
        val saveButton: Button
        val closeButton: Button
        val switchLangHun: SwitchCompat
        val switchLangEng: SwitchCompat
        when(itemId)
        {
            R.id.menuItemLanguage -> {
                dialogBuilder = AlertDialog.Builder(this)
                languagePopupView = layoutInflater.inflate(R.layout.layout_setting_language,null)
                dialogBuilder.setView(languagePopupView)
                saveButton = languagePopupView.findViewById(R.id.settingLanguageSave)
                closeButton = languagePopupView.findViewById(R.id.settingLanguageClose)
                switchLangEng = languagePopupView.findViewById(R.id.switchEng)
                switchLangHun = languagePopupView.findViewById(R.id.switchHun)
                dialog = dialogBuilder.create()
                dialog.show()
                saveButton.setOnClickListener {
                    Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                closeButton.setOnClickListener{
                    Toast.makeText(this,"Close",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
            R.id.menuItemContact -> {
                dialogBuilder = AlertDialog.Builder(this)
                languagePopupView = layoutInflater.inflate(R.layout.layout_setting_contact,null)
                dialogBuilder.setView(languagePopupView)
                closeButton = languagePopupView.findViewById(R.id.settingContactClose)
                dialog = dialogBuilder.create()
                dialog.show()
                closeButton.setOnClickListener{
                    Toast.makeText(this,"Close",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
            R.id.menuItemAbout -> {
                dialogBuilder = AlertDialog.Builder(this)
                languagePopupView = layoutInflater.inflate(R.layout.layout_setting_about,null)
                dialogBuilder.setView(languagePopupView)
                closeButton = languagePopupView.findViewById(R.id.settingAboutClose)
                dialog = dialogBuilder.create()
                dialog.show()
                closeButton.setOnClickListener{
                    Toast.makeText(this,"Close",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        }
    }
}