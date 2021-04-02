package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R
import com.example.kismadrapp.utils.adapters.CategoryClickListener

class Town(): Location("",null) {

    lateinit var townName: String
    lateinit var townDescription: String
    lateinit var townImage: Drawable

    private constructor(name: String,description: String, image: Drawable): this(){
        this.locationName = name
        this.locationImage = image

        this.townName = name
        this.townDescription = description
        this.townImage = image
    }
    private class Builder(
        private var townName:String? = null,
        private var townDescription: String? = null,
        private var townImage: Drawable? = null
    ){
        fun name(townName: String) = apply { this.townName = townName }
        fun description(description: String) = apply { this.townDescription = description }
        fun image(townImage: Drawable) = apply { this.townImage = townImage }
        fun build() = Town(townName!!,townDescription!!,townImage!!)
    }
    fun getAll(context: Context): ArrayList<Town>{
        val eger = Builder()
            .name(context.getString(R.string.town_name_eger))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_eger,null)!!)
            .build()
        val szomolya = Builder()
            .name(context.getString(R.string.town_name_szomolya))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_szomolya,null)!!)
            .build()
        val cserepfalu = Builder()
            .name(context.getString(R.string.town_name_cserepfalu))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_cserepfalu,null)!!)
            .build()
        val bukkzserc = Builder()
            .name(context.getString(R.string.town_name_bukkzserc))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_bukkzserc,null)!!)
            .build()
        val felsotarkany = Builder()
            .name(context.getString(R.string.town_name_felsotarkany))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_felsotarkany,null)!!)
            .build()
        val mezokovesd = Builder()
            .name(context.getString(R.string.town_name_mezokovesd))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_mezokovesd,null)!!)
            .build()
        val bogacs = Builder()
            .name(context.getString(R.string.town_name_bogacs))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_bogacs,null)!!)
            .build()
        return arrayListOf(bogacs,bukkzserc,cserepfalu,eger,felsotarkany,mezokovesd,szomolya)
    }

    override fun getCategory(context: Context): String {
        return context.getString(R.string.category_surroundings)
    }
}