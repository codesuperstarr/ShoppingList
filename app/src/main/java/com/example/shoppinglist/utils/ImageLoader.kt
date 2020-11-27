package com.example.shoppinglist.utils

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.app.ActivityCompat



const val REQUEST_IMAGE_GET = 1
class ImageLoader {

    fun selectImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        if (intent.resolveActivity(PackageManager) != null) {
            ActivityCompat.startActivityForResult(intent, REQUEST_IMAGE_GET)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {
            val thumbnail: Bitmap = data.getParcelableExtra("data")
            val fullPhotoUri: Uri = data.data
            // Do work with photo saved at fullPhotoUri
            ...
        }
    }
}