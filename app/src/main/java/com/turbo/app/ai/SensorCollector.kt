package com.turbo.app.ai

import android.content.Context
import android.app.ActivityManager

class SensorCollector(private val context: Context) {

    fun getFps(): Int {
        return OverlayState.fps // из твоего FPS overlay
    }

    fun getTemp(): Float {
        return try {
            val file = "/sys/class/thermal/thermal_zone0/temp"
            File(file).readText().toFloat() / 1000f
        } catch (e: Exception) {
            35f
        }
    }

    fun getLoad(): Float {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val mem = ActivityManager.MemoryInfo()
        am.getMemoryInfo(mem)

        return (mem.totalMem - mem.availMem).toFloat() / mem.totalMem
    }
}
