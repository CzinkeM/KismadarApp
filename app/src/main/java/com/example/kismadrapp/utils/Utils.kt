package com.example.kismadrapp.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.example.kismadrapp.models.*

enum class NatureType { LAKE, VIEWPOINT, SPRING, OTHER }

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