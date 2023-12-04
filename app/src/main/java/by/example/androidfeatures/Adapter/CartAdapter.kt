package by.example.androidfeatures.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.example.androidfeatures.Models.PopularModel
import by.example.androidfeatures.databinding.CartAddItemBinding

class CartAdapter(
    val context: Context,
    val list: ArrayList<PopularModel>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(binding: CartAddItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val foodImage = binding.homeFoodImage
        val foodName = binding.homeFoodName
        val foodPrice = binding.homeFoodPrice
        val foodCount = binding.foodCount
        val deleteBtn = binding.delteBtn

        val plus = binding.plusBtn
        val minus = binding.minusBtn

        fun bindItem() {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                deleteItem(adapterPosition)
            }
        }

        fun deleteItem(position: Int) {
            if (position in 0..list.size) {
                list.removeAt(position)
                notifyDataSetChanged()
                notifyItemRangeChanged(position, list.size)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

        val binding = CartAddItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val listModel = list[position]
        holder.foodPrice.text = listModel.getFoodPrice().toString()
        holder.foodName.text = listModel.getFoodName()
        listModel.getFoodImage()?.let {
            holder.foodImage.setImageResource(it)
            holder.foodCount.text = listModel.getFoodCount().toString()
        }


        holder.plus.setOnClickListener {
            if (listModel.getFoodCount() < 10) {
                val count = listModel.getFoodCount() + 1
                listModel.setFoodCount(count)
                val priceP = listModel.getFoodPriceConstant() * listModel.getFoodCount()
                listModel.setFoodPrice(priceP)
                holder.foodPrice.text = listModel.getFoodPrice().toString()
                holder.foodCount.text = listModel.getFoodCount().toString()

            }

        }

        holder.minus.setOnClickListener {

            if (listModel.getFoodCount() > 1) {
                val count = listModel.getFoodCount() - 1
                listModel.setFoodCount(count)
                val priceP = listModel.getFoodPrice() * listModel.getFoodCount()
                listModel.setFoodPrice(priceP)
                holder.foodPrice.text = listModel.getFoodPriceConstant().toString()
                holder.foodCount.text = listModel.getFoodCount().toString()
            } else {
                holder.bindItem()
            }

        }
        holder.deleteBtn.setOnClickListener {
            holder.bindItem()
        }
    }

}