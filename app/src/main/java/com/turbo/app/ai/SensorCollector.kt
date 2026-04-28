package com.turbo.app.ai

import android.content.Context
import android.app.ActivityManager
import java.io.File

class SensorCollector(private val context: Context) {

    fun getFps(): Int {
        // пока безопасная заглушка
        return 60
    }

    fun getTemp(): Float {
        return try {
            val file = "/sys/class/thermal/thermal_zone0/temp"
            File(file).readText().trim().toFloat() / 1000f
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
