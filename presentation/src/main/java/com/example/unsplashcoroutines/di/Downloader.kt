package com.example.unsplashcoroutines.di

import android.app.DownloadManager
import android.net.Uri
import android.os.Environment

data class Downloader(val downloadManager: DownloadManager) {
    fun Download(URL: String) {
        val uri = Uri.parse(URL)
        var request: DownloadManager.Request = DownloadManager.Request(uri)
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        request.setTitle(URL + ".png")
        request.setDescription("Downloading " + URL + ".png")
        request.setVisibleInDownloadsUi(true)
        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            "/UnsplashCoroutines/" + "/" + URL + ".png"
        )
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
        downloadManager.enqueue(request)
    }
}