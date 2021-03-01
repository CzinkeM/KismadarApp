package com.example.kismadrapp.activities

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.models.Weather
import com.example.kismadrapp.utils.openEmail
import com.example.kismadrapp.utils.openFacebook
import com.example.kismadrapp.utils.openWebsite
import com.example.kismadrapp.viewmodels.WelcomeActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject
import java.net.URL


class WelcomeActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: WelcomeActivityViewModel
    lateinit var navigationView: NavigationView
    private lateinit var dialog: Dialog

    private var _weather = MutableLiveData<Weather>()
    val weather: LiveData<Weather>
        get() = _weather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_KismadárApp)
        setContentView(R.layout.activity_main)
        WeatherTask().execute()
        viewModel = ViewModelProvider(this).get(WelcomeActivityViewModel::class.java)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navView)
        navigationView.setupWithNavController(findNavController(R.id.fragment))
        viewModel.readFromDataStore.observe(this) { myName ->
            Log.i("datastore", myName)
        }
        Log.i("DataStore", "${viewModel.readFromDataStore.value} value")
        setMenuItemClickListener(navigationView)

        supportActionBar?.hide()
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        bottomNavigation.setupWithNavController(navController)
        navigationView.setupWithNavController(navController)
        val bottomNavigationQRCodeButton = findViewById<BottomNavigationItemView>(R.id.bottomNavQr)
        val bottomNavigationOpenDrawerButton = findViewById<BottomNavigationItemView>(R.id.bottomNavSettings)
        bottomNavigationQRCodeButton.setOnClickListener {
            val scanner = IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }
        bottomNavigationOpenDrawerButton.setOnClickListener {
            bottomNavigation[0].isActivated
            this.openDrawer()
        }
    }

    fun openDrawer() {
        drawerLayout.openDrawer(Gravity.LEFT)
    }

    private fun createDialogWindow(itemId: Int, viewModel: WelcomeActivityViewModel) {
        val dialogBuilder: AlertDialog.Builder
        val languagePopupView: View
        val closeButton: Button

        val switchLangHun: SwitchMaterial
        val switchLangEng: SwitchMaterial
        when (itemId) {
            R.id.menuItemLanguage -> {
                dialogBuilder = AlertDialog.Builder(this)
                languagePopupView = layoutInflater.inflate(R.layout.layout_setting_language, null)
                dialogBuilder.setView(languagePopupView)
                closeButton = languagePopupView.findViewById(R.id.settingLanguageClose)
                switchLangEng = languagePopupView.findViewById(R.id.switchEng)
                switchLangHun = languagePopupView.findViewById(R.id.switchHun)
                viewModel.checkAndSetSwitchState(switchLangHun, switchLangEng)
                dialog = dialogBuilder.create()
                dialog.show()
                closeButton.setOnClickListener {
                    Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                    viewModel.saveToDataStore(resources.getString(R.string.key_language_en))
                    dialog.dismiss()
                }
            }
            R.id.menuItemAbout -> {
                dialogBuilder = AlertDialog.Builder(this)
                languagePopupView = layoutInflater.inflate(R.layout.layout_setting_about, null)
                dialogBuilder.setView(languagePopupView)
                closeButton = languagePopupView.findViewById(R.id.settingAboutClose)
                dialog = dialogBuilder.create()
                dialog.show()
                closeButton.setOnClickListener {
                    Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        }
    }

    private fun setMenuItemClickListener(navigationView: NavigationView) {
        // TODO: 2021. 02. 24. Cserélni a recyclerViewra a navigationt
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuItemAbout -> {
                    createDialogWindow(item.itemId, viewModel)
                    Toast.makeText(this, "about", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.menuItemLanguage -> {
                    createDialogWindow(item.itemId, viewModel)
                    Toast.makeText(this, "language", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.menuContactEmail -> {
                    startActivity(openEmail(getString(R.string.emailAddress), "Applikáció"))
                    true
                }
                R.id.menuContactFacebook -> {
                    startActivity(openFacebook(packageManager, getString(R.string.facebookUrl)))
                    true
                }
                R.id.menuContactWebsite -> {
                    startActivity(openWebsite(getString(R.string.websiteUrl)))
                    true
                }

                else -> {
                    Toast.makeText(this, "Else happened", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
            }
        }
    }

    inner class WeatherTask: AsyncTask<String, Void, String>(){
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=noszvaj&appid=dd3227b3492522fd76affb3c83e672f6&units=metric&lang=hu")
                    .readText(Charsets.UTF_8)
                Log.i("weather", "Api call success")
                Log.i("weather", response)

            }catch (e: Exception){
                response = null
                Log.i("weather", "Api call failed: ${e.message}")
            }
            return  response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObject = JSONObject(result)
                val main = jsonObject.getJSONObject("main")
                val status = jsonObject.getJSONArray("weather").getJSONObject(0)
                Log.i("weather", "Act temp: ${main.getString("temp")}")
                val weather = Weather(main.getString("temp"), status.getString("main"))
                _weather.value = weather
                //weatherStatus = weather.getString("main")

            } catch (e: Exception) {

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    // TODO: 2021. 03. 01. Custom function to navigate to Model Detail Pages
                    Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}