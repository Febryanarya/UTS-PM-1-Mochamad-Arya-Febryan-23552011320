package com.example.utspm1

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*

class OutdoorRentalAdapter(
    private val context: Context,
    private val equipmentImages: Array<Int>,
    private val equipmentTitles: Array<String>
) : BaseAdapter() {

    override fun getCount() = equipmentImages.size
    override fun getItem(position: Int) = equipmentImages[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Buat layout vertikal berisi gambar dan teks
        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            layoutParams = AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT, 500
            )
            setPadding(16, 16, 16, 16)
        }

        // Gambar alat outdoor
        val imageView = ImageView(context).apply {
            setImageResource(equipmentImages[position])
            layoutParams = ViewGroup.LayoutParams(300, 300)
            scaleType = ImageView.ScaleType.CENTER_CROP
        }

        // Nama alat outdoor
        val textView = TextView(context).apply {
            text = equipmentTitles[position]
            gravity = Gravity.CENTER
            textSize = 14f
            setPadding(0, 8, 0, 0)
        }

        // Tambahkan gambar dan teks ke layout
        layout.addView(imageView)
        layout.addView(textView)

        return layout
    }
}
