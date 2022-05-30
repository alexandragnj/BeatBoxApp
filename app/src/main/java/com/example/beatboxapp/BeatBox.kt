package com.example.beatboxapp

import android.content.res.AssetManager
import android.util.Log

class BeatBox(private val assets: AssetManager) {

    val sounds: List<Sound> = loadSounds()

    private fun loadSounds(): List<Sound> {
        assets.list(SOUNDS_FOLDER)?.let {
            val sounds = mutableListOf<Sound>()
            buildSoundsList(it, sounds)
            return sounds
        }
        Log.e(TAG, "Could not list assets")
        return emptyList()
    }

    private fun buildSoundsList(strings: Array<String>, sounds: MutableList<Sound>) {
        strings.forEach { filename ->
            val assetPath = "$SOUNDS_FOLDER/$filename"
            val sound = Sound(assetPath)
            sounds.add(sound)
        }
    }

    companion object {
        private const val TAG = "BeatBox"
        private const val SOUNDS_FOLDER = "sample_sounds"
    }
}
