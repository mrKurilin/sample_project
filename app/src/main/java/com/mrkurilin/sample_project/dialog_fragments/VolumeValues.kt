package com.mrkurilin.sample_project.dialog_fragments

class VolumeValues {

    companion object {
        val volumes = (0..100 step 10).toList().toIntArray()
        var currentVolume = 0
    }
}