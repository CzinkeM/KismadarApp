package com.example.kismadrapp.welcome

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.kismadrapp.database.CategoryDao
import com.example.kismadrapp.database.TownDao
import com.example.kismadrapp.model.Lists
import com.example.kismadrapp.model.ImageColors
import kotlin.random.Random

class WelcomePageViewModel(context: Context, townDataSource: TownDao, categoryDataSource: CategoryDao):ViewModel(){
    private val data = Lists()
    val getTownList = data.generateTownList(context.resources)
    val getCategoryList = data.generateCategoryList(context.resources)

    fun getRandomImage(townList: List<Drawable?>): Drawable {
        val randomNumber = Random.nextInt(0,townList.size-1)
        return townList[randomNumber]!!

    }
    fun getColorsOfImage(drawable: Drawable?): ImageColors{
        val drawableBitmap = drawable!!.toBitmap()
        val defaultColor = Color.BLACK
        val colorDarkMuted = createPaletteSync(drawableBitmap).getDarkMutedColor(defaultColor)
        val colorDarkVibrant = createPaletteSync(drawableBitmap).getDarkVibrantColor(defaultColor)
        val colorDominant = createPaletteSync(drawableBitmap).getDominantColor(defaultColor)
        val colorLightMuted = createPaletteSync(drawableBitmap).getLightMutedColor(defaultColor)
        val colorLightVibrant = createPaletteSync(drawableBitmap).getLightVibrantColor(defaultColor)
        val colorMuted = createPaletteSync(drawableBitmap).getMutedColor(defaultColor)
        val colorVibrant = createPaletteSync(drawableBitmap).getVibrantColor(defaultColor)
        return  ImageColors(colorDarkMuted,colorDarkVibrant,colorDominant,colorLightMuted,colorLightVibrant,colorMuted,colorVibrant)
    }
    private fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

}