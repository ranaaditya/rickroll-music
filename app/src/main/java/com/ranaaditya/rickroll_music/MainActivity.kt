package com.ranaaditya.rickroll_music

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.ranaaditya.rickroll_music.utils.Controller

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Controller.controlDeviceVolumeSystem(context = this.applicationContext)
        Controller.startRickRoll(context = this.applicationContext)

    }

    override fun onResume() {
        super.onResume()
        Controller.controlDeviceVolumeSystem(context = this.applicationContext)
        Controller.startRickRoll(context = this.applicationContext)
    }

    override fun onPause() {
        super.onPause()
        Controller.controlDeviceVolumeSystem(context = this.applicationContext)
    }

    override fun onDestroy() {
        super.onDestroy()
        Controller.controlDeviceVolumeSystem(context = this.applicationContext)
    }

    override fun onRestart() {
        super.onRestart()
        Controller.controlDeviceVolumeSystem(context = this.applicationContext)
        Controller.startRickRoll(context = this.applicationContext)
    }

}