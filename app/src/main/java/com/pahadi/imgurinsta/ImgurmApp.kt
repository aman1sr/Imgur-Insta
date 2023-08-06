package com.pahadi.imgurinsta

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ComponentRegistry
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

class ImgurmApp : Application(), ImageLoaderFactory {

    override fun newImageLoader()  = ImageLoader.Builder(this@ImgurmApp)
        .components {
            if (SDK_INT >= 38) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()




    override fun onCreate() {
        super.onCreate()
        Coil.setImageLoader(this)
    }
}