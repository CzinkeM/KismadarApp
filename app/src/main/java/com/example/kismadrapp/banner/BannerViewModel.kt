package com.example.kismadrapp.banner

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.kismadrapp.model.ImageColors
import com.example.kismadrapp.model.Lists
import kotlin.random.Random

class BannerViewModel:ViewModel() {
    private val data = Lists()
    fun getImage(res: Resources): Drawable{
       return getRandomImage(data.generateTownList(res).map { town -> town.img }.toList())
    }

    private fun getRandomImage(townList: List<Drawable?>): Drawable {
        val randomNumber = Random.nextInt(0,townList.size-1)
        return townList[randomNumber]!!

    }
    fun getColorsOfImage(drawable: Drawable?): ImageColors {
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