package com.example.kismadrapp.models

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.example.kismadrapp.R

class ContactManager(activity: Activity) {
    private val act = activity

    private fun openFacebook(packageManager: PackageManager, facebookURL: String): Intent {
        var uri = Uri.parse(facebookURL)
        val facebookAppName = "com.facebook.katana"
        try {
            val applicationInfo = packageManager.getApplicationInfo(facebookAppName,0)
            if(applicationInfo.enabled){
                uri = Uri.parse("fb://facewebmodal/f?href=$facebookURL")
            }
        }catch (e: PackageManager.NameNotFoundException){
        }
        return Intent(Intent.ACTION_VIEW,uri)
    }
    fun contactViaFacebook(){
        act.startActivity(openFacebook(act.packageManager,act.resources.getString(R.string.facebookUrl)))
    }
    private fun openWebsite(url: String): Intent{
        return Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }
    fun contactViaWebsite(){
        act.startActivity(openWebsite(act.resources.getString(R.string.websiteUrl)))
    }
    private fun openEmail(address: String,subject: String):Intent{
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.type = "text/plain"
        intent.data = Uri.parse("mailto:$address")
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)
        return intent
    }
    fun contactViaEmail(){
        val emailAddressFrom = act.resources.getString(R.string.emailAddress)
        val emailSubject = act.resources.getString(R.string.emailSubject)
        act.startActivity(openEmail(emailAddressFrom,emailSubject))
    }

}