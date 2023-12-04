package by.example.androidfeatures.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.example.androidfeatures.DetailsActivity
import by.example.androidfeatures.Models.PopularModel
import by.example.androidfeatures.Models.SharedModel
import by.example.androidfeatures.databinding.HomeFoodItemBinding

class PopularAdapter(
    val context: Context,
    var list: ArrayList<PopularModel>
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    private lateinit var shareModel: SharedModel

    fun setSharedModel(viewModel: SharedModel) {
        shareModel = viewModel
    }

    class PopularViewHolder(binding: HomeFoodItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val foodImage = binding.homeFoodImage
        val foodName = binding.homeFoodName
        val foodPrice = binding.homeFoodPrice

        val addBtn = binding.homeFoodBtn
        val item = binding.root
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularViewHolder {
        val binding = HomeFoodItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val listModel = list[position]

        holder.foodName.text = listModel.getFoodName()
        holder.foodPrice.text = listModel.getFoodPrice().toString()
        listModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }

        holder.item.setOnClickListener {

            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("foodImage", listModel.getFoodImage())
            intent.putExtra("foodName", listModel.getFoodName())
            context.startActivity(intent)
        }

        holder.addBtn.setOnClickListener {

            if (shareModel.inList(listModel)) {

                shareModel.deleteFromCart(listModel)
                holder.addBtn.text = "Add to Cart"
            } else {
                shareModel.addToCart(listModel)
                holder.addBtn.text = "Delete Choice"


            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: ArrayList<PopularModel>) {
        list = newList
        notifyDataSetChanged()
    }
}