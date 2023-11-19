package by.example.androidfeatures.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import by.example.androidfeatures.R


class imageSladeAdapter(
    private val context: Context,
    private val imageList: ArrayList<Int>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<imageSladeAdapter.ImageHolder>() {

    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image_in_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_container, parent, false)
        return ImageHolder(view)

    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {

        holder.image.setImageResource(imageList[position])

        if (position == imageList.size - 1) {
            viewPager2.post(runnable)

        }

    }

    private val runnable = Runnable {
        imageList.addAll(imageList)
    }

}