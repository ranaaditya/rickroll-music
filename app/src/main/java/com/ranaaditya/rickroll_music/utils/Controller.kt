package com.ranaaditya.rickroll_music.utils

import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.media.AudioManager
import android.media.MediaPlayer
import com.ranaaditya.rickroll_music.R

object Controller {

    fun controlDeviceVolumeSystem(context: Context) {
        val am = context.getSystemService(AUDIO_SERVICE) as AudioManager
        val cv = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0)
    }

    fun startRickRoll(context: Context) {
        val mp = MediaPlayer.create(context, R.raw.rickroll)
        mp.start()
    }
}