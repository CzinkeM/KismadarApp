@file:Suppress("DEPRECATION")

package com.example.kismadrapp.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
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
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject
import java.net.URL


class WelcomeActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: WelcomeActivityViewModel
    private lateinit var drawerNavigationView: NavigationView
    private lateinit var bottomNavigationView: BottomNavigationView

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading:LiveData<Boolean>
    get() = _isLoading

    private var _weather = MutableLiveData<Weather>()
    val weather: LiveData<Weather>
        get() = _weather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_KismadárApp)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        viewModel = ViewModelProvider(this).get(WelcomeActivityViewModel::class.java)
        drawerLayout = findViewById(R.id.drawerLayout)
        drawerNavigationView = findViewById(R.id.navView)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        WeatherTask(this).execute()
        val bottomNavigationOpenDrawerButton = findViewById<BottomNavigationItemView>(R.id.bottomNavSettings)
        val navController = findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)
        drawerNavigationView.setupWithNavController(navController)
        drawerNavigationView.setNavigationItemSelectedListener(setMenuItemClickListener())

        bottomNavigationOpenDrawerButton.setOnClickListener {
            this.openDrawer()
        }
    }

    @SuppressLint("RtlHardcoded")
    fun openDrawer() {
        drawerLayout.openDrawer(Gravity.LEFT)
    }
    private fun setMenuItemClickListener(): NavigationView.OnNavigationItemSelectedListener {
        return NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuItemAbout -> {
                    viewModel.createDialogWindow(item.itemId, layoutInflater,this)
                    true
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
                    startActivity(openWebsite(getString(R.string.websiteUrl)),null)
                    true
                }
                else -> true
            }
        }
    }
    companion object {
        private class WeatherTask(private val welcomeActivity: WelcomeActivity) : AsyncTask<String, Void, String>(){
            override fun onPreExecute() {
                welcomeActivity._isLoading.value = true
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
                    val jsonObject = JSONObject(result!!)
                    val main = jsonObject.getJSONObject("main")
                    val status = jsonObject.getJSONArray("weather").getJSONObject(0)
                    Log.i("weather", "Act temp: ${main.getString("temp")}")
                    val weather = Weather(main.getString("temp")+"°C", status.getString("main"))
                    welcomeActivity._weather.value = weather
                    welcomeActivity._isLoading.value = false
                } catch (e: Exception) {
    
                }
            }
        }
    }
}