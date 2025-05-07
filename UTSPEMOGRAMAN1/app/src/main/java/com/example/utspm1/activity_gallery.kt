package com.example.utspm1

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {

    // Array gambar alat outdoor
    private val equipmentImages = arrayOf(
        R.drawable.tenda,
        R.drawable.sleeping_bag,
        R.drawable.matras,
        R.drawable.kompor_portable
    )

    // Nama-nama alat outdoor
    private val equipmentTitles = arrayOf(
        "Tenda Camping",
        "Sleeping Bag",
        "Matras Outdoor",
        "Kompor Portable"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery) // Pastikan layout-nya sesuai tema

        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter =OutdoorRentalAdapter(this, equipmentImages, equipmentTitles)
    }
}
