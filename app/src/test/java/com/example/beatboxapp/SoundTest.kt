package com.example.beatboxapp

import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SoundTest {

    @Mock
    private lateinit var sound: Sound

    @Before
    fun setUp() {
    }

    @Test
    fun verifySoundName() {
        sound = Sound("assetPath.wav")
        assertFalse(sound.name.contains(".wav"))
    }
}


