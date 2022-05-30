package com.example.beatboxapp

import android.content.res.AssetManager
import android.util.Log

class BeatBox(private val assets: AssetManager) {

    val sounds: List<Sound> = loadSounds()

    private fun loadSounds(): List<Sound> {
        assets.list(SOUNDS_FOLDER)?.let {
            return buildSoundsList(it)
        }
        Log.e(TAG, "Could not list assets")
        return emptyList()
    }

    private fun buildSoundsList(strings: Array<String>): List<Sound> {
        return strings.map { filename ->
            val assetPath = "$SOUNDS_FOLDER/$filename"
            Sound(assetPath)
        }
    }

    companion object {
        private const val TAG = "BeatBox"
        private const val SOUNDS_FOLDER = "sample_sounds"
    }
}
