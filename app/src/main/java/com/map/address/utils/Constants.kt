package com.map.address.utils

import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition

class Constants {
    companion object {
        const val BASE_URL =
            "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"

        val tashkentCameraPosition = CameraPosition(Point(41.232322, 69.24342323), 12f, 1.0f, 0.0f)
    }
}