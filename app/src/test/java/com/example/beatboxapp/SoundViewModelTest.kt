package com.example.beatboxapp

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SoundViewModelTest {

    @Mock
    private lateinit var beatBox: BeatBox

    @Mock
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        `when`(sound.name).thenReturn("soundName")
        assertThat(subject.title, CoreMatchers.`is`("soundName"))
    }


    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()

        Mockito.verify(beatBox).play(sound)
    }

}