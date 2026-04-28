package com.turbo.app.ai

data class Metrics(
    val fps: Int,
    val temp: Float,
    val load: Float
)

class AdaptiveAI {

    fun predict(m: Metrics): String {

        val stressScore =
            (60 - m.fps) * 0.4 +
            (m.temp - 40) * 1.2 +
            m.load * 20

        return when {
            stressScore > 30 -> "BEAST_MODE"
            stressScore > 15 -> "TURBO_MODE"
            stressScore > 5 -> "BALANCED"
            else -> "QUALITY"
        }
    }
}
