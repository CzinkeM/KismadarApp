package com.example.kismadrapp.utils

import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R
import com.example.kismadrapp.models.*
import java.lang.Exception
import javax.security.auth.Subject
import kotlin.random.Random

enum class NatureType { LAKE, VIEWPOINT, SPRING, OTHER }

fun getNatureSights(res: Resources): ArrayList<Nature>{
    val testNatureSight = Nature("Példa Forrás",
        NatureType.SPRING,res.getString(R.string.loremipsum),ResourcesCompat.getDrawable(res,
            R.drawable.vector_hiking,null)!!,null)
    return arrayListOf(testNatureSight)
}

fun openFacebook(packageManager: PackageManager,url: String): Intent{
    var uri = Uri.parse(url)
    val facebookAppName = "com.facebook.katana"
    try {
        val applicationInfo = packageManager.getApplicationInfo(facebookAppName,0)
        if(applicationInfo.enabled){
            uri = Uri.parse("fb://facewebmodal/f?href=$url")
        }
    }catch (e: PackageManager.NameNotFoundException){}
    return Intent(Intent.ACTION_VIEW,uri)
}
fun openWebsite(url: String): Intent{
    return Intent(Intent.ACTION_VIEW, Uri.parse(url))
}
fun openEmail(address: String,subject: String):Intent{
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.type = "text/plain"
    intent.data = Uri.parse("mailto:$address")
    intent.putExtra(Intent.EXTRA_SUBJECT,subject)
    return intent
}