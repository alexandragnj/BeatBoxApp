package com.example.beatboxapp

class Sound(assetPath: String) {

    val name = assetPath.split("/").last().removeSuffix(WAV)

    companion object {
        private const val WAV = ".wav"
    }
}