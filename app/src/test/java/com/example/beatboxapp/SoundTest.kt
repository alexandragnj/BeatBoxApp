package com.example.beatboxapp

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SoundTest {

    private val sound: Sound = Sound("assetPath.wav")

    @Test
    fun verifySoundName() {
        assertThat(sound.name, CoreMatchers.`is`("assetPath"))
    }
}


