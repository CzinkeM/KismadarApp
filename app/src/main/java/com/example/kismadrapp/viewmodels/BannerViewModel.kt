package com.example.kismadrapp.viewmodels

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.kismadrapp.getTowns
import com.example.kismadrapp.listOfEvents
import com.example.kismadrapp.models.Event
import com.example.kismadrapp.models.ImageColors
import kotlin.random.Random

class BannerViewModel(resources: Resources) : ViewModel() {
    private val viewModelResources = resources

    fun getRandomTownImage(): Drawable {
        val random = Random.nextInt(0, getTowns(viewModelResources).size)
        val town = getTowns(viewModelResources)[random]
        return getRandomImage(town.images)
    }

    fun getRandomEvent(): Drawable {
        val list = listOfEvents(viewModelResources)
        val random = Random.nextInt(0, list.size)
        return list[random]
    }

    private fun getRandomImage(imageList: List<Drawable>): Drawable {
        val random = Random.nextInt(0, imageList.size)
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
        return ImageColors(
            colorDarkMuted,
            colorDarkVibrant,
            colorDominant,
            colorLightMuted,
            colorLightVibrant,
            colorMuted,
            colorVibrant
        )
    }

    private fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()
    fun getRecentEvent(): Event {
        return Event("Valentin nap", "2020.02.07")
    }

}