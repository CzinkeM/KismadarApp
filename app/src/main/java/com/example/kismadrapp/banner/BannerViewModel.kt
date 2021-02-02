package com.example.kismadrapp.banner

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.kismadrapp.model.ImageColors
import com.example.kismadrapp.model.EmbeddedValues
import com.example.kismadrapp.model.Event
import kotlin.random.Random

class BannerViewModel(resources: Resources):ViewModel() {
    private val data = EmbeddedValues(resources)


    fun getRandomTownImage(): Drawable{
        val random = Random.nextInt(0,data.listOfTowns.size)
        val town = data.listOfTowns[random]
        return getRandomImage(town.img)
    }

    private fun getRandomImage(imageList: List<Drawable>): Drawable {
        val random = Random.nextInt(0,imageList.size)
        return imageList[random]
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
    fun getRecentEvent(): Event{
        return Event("Valentin nap","2020.02.07")
    }
}