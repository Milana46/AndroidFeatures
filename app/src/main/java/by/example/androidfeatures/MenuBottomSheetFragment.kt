package by.example.androidfeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.example.androidfeatures.Adapter.PopularAdapter
import by.example.androidfeatures.Models.PopularModel
import by.example.androidfeatures.Models.SharedModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var adapter: PopularAdapter
    private lateinit var menuList: ArrayList<PopularModel>
    private lateinit var menuRv: RecyclerView

    private lateinit var sharedModel: SharedModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu_bottom_sheet, container, false)
        sharedModel= ViewModelProvider(requireActivity()).get(SharedModel::class.java)


        menuRv = view.findViewById(R.id.menu_Rv)

        menuList = ArrayList()
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))

        adapter = PopularAdapter(requireContext(), menuList) //экземпляр класса PopularAdapter;
        adapter.setSharedModel(sharedModel)

        menuRv.layoutManager = LinearLayoutManager(requireContext())
        menuRv.adapter = adapter

        return view
    }


}