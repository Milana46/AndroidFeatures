package by.example.androidfeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.example.androidfeatures.Adapter.CartAdapter
import by.example.androidfeatures.Models.PopularModel
import by.example.androidfeatures.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding
    private lateinit var list:ArrayList<PopularModel>
    private lateinit var adapter:CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding=FragmentCartBinding.inflate(inflater,container, false)

        list= ArrayList()
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))

        adapter= CartAdapter(requireContext(),list)
        binding.cartRv.layoutManager=LinearLayoutManager(requireContext())
        binding.cartRv.adapter=adapter

        return binding.root
    }


}