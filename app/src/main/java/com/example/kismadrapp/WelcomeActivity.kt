package com.example.kismadrapp

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.google.android.material.navigation.NavigationView
import com.google.android.material.switchmaterial.SwitchMaterial

class WelcomeActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: WelcomeActivityViewModel
    lateinit var navigationView: NavigationView
    private lateinit var dialog: Dialog
    private lateinit var texr: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(WelcomeActivityViewModel::class.java)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navView)
        viewModel.readFromDataStore.observe(this) { myName ->
            Log.i("datastore",myName)
        }
        Log.i("DataStore","${viewModel.readFromDataStore.value} value")
        setMenuItemClickListener(navigationView)

        supportActionBar?.hide()
    }

    fun openDrawer() {
        drawerLayout.openDrawer(Gravity.LEFT)
    }
    private fun createDialogWindow(itemId: Int, viewModel: WelcomeActivityViewModel){
        val dialogBuilder: AlertDialog.Builder
        val languagePopupView: View
        val closeButton: Button

        val switchLangHun: SwitchMaterial
        val switchLangEng: SwitchMaterial
        when(itemId)
        {
            R.id.menuItemLanguage -> {
                dialogBuilder = AlertDialog.Builder(this)
                languagePopupView = layoutInflater.inflate(R.layout.layout_setting_language,null)
                dialogBuilder.setView(languagePopupView)
                closeButton = languagePopupView.findViewById(R.id.settingLanguageClose)
                switchLangEng = languagePopupView.findViewById(R.id.switchEng)
                switchLangHun = languagePopupView.findViewById(R.id.switchHun)
                viewModel.checkAndSetSwitchState(switchLangHun,switchLangEng)
                dialog = dialogBuilder.create()
                dialog.show()
                closeButton.setOnClickListener{
                    Toast.makeText(this,"Close",Toast.LENGTH_SHORT).show()
                    viewModel.saveToDataStore(resources.getString(R.string.key_language_en))
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
    fun setMenuItemClickListener(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuItemAbout -> {
                    createDialogWindow(item.itemId,viewModel)
                    Toast.makeText(this, "about", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.menuItemContact ->{
                    createDialogWindow(item.itemId,viewModel)
                    Toast.makeText(this, "contact", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.menuItemLanguage ->{
                    createDialogWindow(item.itemId,viewModel)
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


}