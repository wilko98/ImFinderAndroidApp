package com.example.unsplashcoroutines.BigImale

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.data.db.DAO
import com.example.unsplashcoroutines.R
import com.example.unsplashcoroutines.di.Downloader
import com.r0adkll.slidr.Slidr
import kotlinx.android.synthetic.main.ac_big_image.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.io.ByteArrayOutputStream


//TODO добавить вию модель *

class BigImageActivity : AppCompatActivity() {

    val downloader: Downloader by inject()
    val DAO: DAO by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.unsplashcoroutines.R.layout.ac_big_image)
        Slidr.attach(this)
        title = intent.getStringExtra("author")
        Glide.with(this)
            .load(intent.getStringExtra("url"))
//            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .skipMemoryCache(true)
            .into(image)
        image.setOnClickListener { onImageClick() }
        btn_download.setOnClickListener(View.OnClickListener { onDownloadClick() })
        btn_add.setOnClickListener { onAddClick() }
    }

    fun onImageClick() {
        if (btn_add.isVisible) {
            btn_add.isVisible = false
            btn_like.isVisible = false
            btn_download.isVisible = false
        } else {
            btn_add.isVisible = true
            btn_like.isVisible = true
            btn_download.isVisible = true
        }
    }

    fun onDownloadClick() {

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is not granted. Should we show an explanation?
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("To use this functionality you should allow app to write external storage")
                .setPositiveButton("i understand") { dialog, which ->
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        1
                    )
                }
                .setNegativeButton("no", { dialog, which -> })
            dialogBuilder.create().show()
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            ) {
                Toast.makeText(
                    this,
                    getString(R.string.download_permission_explanation),
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )

            }
        } else {
            Toast.makeText(this, "downloading", Toast.LENGTH_LONG).show()
            downloader.Download(intent.getStringExtra("urlFull"))
        }
    }

    fun onAddClick() {
        val stream: ByteArrayOutputStream = ByteArrayOutputStream()
        image.drawable.toBitmap().compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val bytes = stream.toByteArray()
        GlobalScope.launch(Dispatchers.Default) {
            DAO.insertPhoto(com.example.data.dbPhoto(intent.getStringExtra("url"), bytes))
        }
        Toast.makeText(this, "PhotoResult added to app gallery", Toast.LENGTH_SHORT).show()
    }


}
