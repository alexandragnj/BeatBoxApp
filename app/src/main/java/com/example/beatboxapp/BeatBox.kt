package com.example.beatboxapp

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException

class BeatBox(private val assets: AssetManager) {

    val sounds: List<Sound> = loadSounds()

    private val soundPool = SoundPool.Builder()
        .setMaxStreams(MAX_SOUNDS)
        .build()

    fun play(sound: Sound){
        sound.soundId?.let{
            soundPool.play(it, 1.0f, 1.0f, 1, 0, 1.0f)
        }
    }

    private fun loadSounds(): List<Sound> {
        assets.list(SOUNDS_FOLDER)?.let {
            return buildSoundsList(it)
        }
        Log.e(TAG, "Could not list assets")
        return emptyList()
    }

    private fun buildSoundsList(strings: Array<String>): List<Sound> {
        val sounds = mutableListOf<Sound>()
        strings.forEach { filename ->
            val assetPath = "$SOUNDS_FOLDER/$filename"
            val sound = Sound(assetPath)
            try {
                load(sound)
                sounds.add(sound)
            } catch (ioe: IOException) {
                Log.e(TAG, "Could not load sound $filename", ioe)
            }
        }
        return sounds
    }

    private fun load(sound: Sound) {
        val afd: AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId
    }

    companion object {
        private const val TAG = "BeatBox"
        private const val SOUNDS_FOLDER = "sample_sounds"
        private const val MAX_SOUNDS = 5
    }
}
