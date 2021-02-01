package com.example.kismadrapp.welcome

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.kismadrapp.R
import com.example.kismadrapp.model.Category
import com.example.kismadrapp.model.Town
import kotlin.random.Random

class WelcomePageViewModel:ViewModel(){

    fun getCategoryList(res: Resources):List<Category>{
        val catFoodDrink = Category(ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_restaurant,null),res.getString(R.string.category_food_drink))
        val catServices = Category(ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_gear,null),res.getString(R.string.category_services))
        val catShop = Category( ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_shop,null),res.getString(R.string.category_shops))
        val catSight = Category(ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_building,null),res.getString(R.string.category_sights))
        val catNature = Category(ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_tree,null),res.getString(R.string.category_nature))
        val catSurroundings = Category(ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_map,null),res.getString(R.string.category_surroundings))
        return  mutableListOf(catFoodDrink,catServices,catShop,catSight,catNature,catSurroundings)
    }
    fun getTownList(res: Resources): List<Town>{
        val townBogacs = Town(res.getString(R.string.town_bogacs),ResourcesCompat.getDrawable(res,R.mipmap.noszvaj_panorama_cut,null))
        val townSzomolya = Town(res.getString(R.string.town_szomolya),ResourcesCompat.getDrawable(res,R.mipmap.noszvaj_panorama_cut,null))
        val townEger = Town(res.getString(R.string.town_eger),ResourcesCompat.getDrawable(res,R.mipmap.noszvaj_panorama_cut,null))
        val townMezokovesd = Town(res.getString(R.string.town_mezokovesd),ResourcesCompat.getDrawable(res,R.mipmap.noszvaj_panorama_cut,null))
        val townFelsotarkany =Town(res.getString(R.string.town_felsotarkany),ResourcesCompat.getDrawable(res,R.mipmap.noszvaj_panorama_cut,null))
        val townBukkszerc = Town(res.getString(R.string.town_bukkzserc),ResourcesCompat.getDrawable(res,R.mipmap.noszvaj_panorama_cut,null))
        val townCserepfalu = Town(res.getString(R.string.town_cserepfalu),ResourcesCompat.getDrawable(res,R.mipmap.noszvaj_panorama_cut,null))
        return mutableListOf(townBogacs,townBukkszerc,townCserepfalu,townEger,townFelsotarkany,townMezokovesd,townSzomolya)
    }
    fun getRandomTownImage(townList: List<Town>): Drawable {
        val randomNumber = Random.nextInt(0,townList.size-1)
        val img = townList[randomNumber].img!!
        return img
    }
    fun getDominantColorOfImage(drawable: Drawable?): Int{
        val drawableBitmap = drawable!!.toBitmap()
        val colorDarkMutedColor = createPaletteSync(drawableBitmap).getDarkMutedColor(Color.RED)
        val colorDarkVibrantColor = createPaletteSync(drawableBitmap).getDarkVibrantColor(Color.RED)
        val colorDominantColor = createPaletteSync(drawableBitmap).getDominantColor(Color.RED)
        val colorLightMutedColor = createPaletteSync(drawableBitmap).getLightMutedColor(Color.RED)
        val colorLightVibrantColor = createPaletteSync(drawableBitmap).getLightVibrantColor(Color.RED)
        val colorMutedColor = createPaletteSync(drawableBitmap).getMutedColor(Color.RED)
        val colorVibrantColor = createPaletteSync(drawableBitmap).getVibrantColor(Color.RED)

        val hexDarkMutedColor = Integer.toHexString(colorDarkMutedColor)
        val hexDarkVibrantColor = Integer.toHexString(colorDarkVibrantColor)
        val hexDominantColor = Integer.toHexString(colorDominantColor)
        val hexLightMutedColor = Integer.toHexString(colorLightMutedColor)
        val hexLightVibrantColor = Integer.toHexString(colorLightVibrantColor)
        val hexMutedColor = Integer.toHexString(colorMutedColor)
        val hexVibrantColor = Integer.toHexString(colorVibrantColor)

        val colorList = listOf<Int>(colorDarkMutedColor,colorDarkVibrantColor,colorDominantColor,colorLightMutedColor,colorLightVibrantColor,colorMutedColor,colorVibrantColor)
        val colorHexList = listOf<String>(hexDarkMutedColor,hexDarkVibrantColor,hexDominantColor,hexLightMutedColor,hexLightVibrantColor,hexMutedColor,hexVibrantColor)
        Log.i("genColor","int: $colorList")
        Log.i("genColor","hex: $colorHexList")
        Log.i("genColor", "#${hexDominantColor.substring(2)}")
        val colorHex = hexDominantColor.substring(2)
        return colorMutedColor
    }
    private fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

}