package com.ranaaditya.rickroll_music.service

import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.IBinder
import android.os.PowerManager
import java.io.IOException

open class RickRollStreamService: Service(), MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener,
    MediaPlayer.OnBufferingUpdateListener {

    private lateinit var mediaPlayer: MediaPlayer
    private val STREAM_URL = "app/res/raw.rickroll.mp3"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer()

        mediaPlayer = MediaPlayer()
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer.setDataSource(STREAM_URL)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        mediaPlayer.setWakeMode(applicationContext, PowerManager.PARTIAL_WAKE_LOCK)
        mediaPlayer.setOnErrorListener(this)
        mediaPlayer.setOnBufferingUpdateListener(this)
        mediaPlayer.setOnInfoListener(this)
        mediaPlayer.setOnPreparedListener(this)
        mediaPlayer.isLooping = true

        mediaPlayer.setWakeMode(applicationContext, PowerManager.PARTIAL_WAKE_LOCK)
        mediaPlayer.prepareAsync()

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onPrepared(mp: MediaPlayer?) {
        TODO("Not yet implemented")
        mediaPlayer.start()
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun onInfo(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return false
    }

    override fun onBufferingUpdate(mp: MediaPlayer?, percent: Int) {
        TODO("Not yet implemented")
    }

}