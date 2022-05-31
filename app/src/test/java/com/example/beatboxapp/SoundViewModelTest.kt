package com.example.beatboxapp

import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import javax.security.auth.Subject

class SoundViewModelTest : TestCase() {

    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    public override fun setUp() {
        super.setUp()
        sound = Sound("assetPath")
        subject = SoundViewModel()
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle(){
        assertThat(subject.title, `is`(sound.name))
    }
}