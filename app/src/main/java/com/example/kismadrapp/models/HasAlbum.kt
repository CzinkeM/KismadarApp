package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

abstract class HasAlbum() {
    abstract val album: Collection<Drawable>
}