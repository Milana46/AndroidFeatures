package by.example.androidfeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.example.androidfeatures.Adapter.PopularAdapter
import by.example.androidfeatures.Models.PopularModel
import by.example.androidfeatures.Models.SharedModel
import by.example.androidfeatures.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

   private lateinit var binding:FragmentSearchBinding
   private lateinit var adapter: PopularAdapter
   private lateinit var list:ArrayList<PopularModel>

   private lateinit var sharedModel: SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentSearchBinding.inflate(inflater,container,false)

        sharedModel=ViewModelProvider(requireActivity()).get(SharedModel::class.java)

        list = ArrayList()
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))

        adapter = PopularAdapter(requireContext(), list) //экземпляр класса PopularAdapter;
        adapter.setSharedModel(sharedModel)

        binding.searchMenuRv.adapter=adapter
        binding.searchMenuRv.layoutManager = LinearLayoutManager(requireContext())

        searchMenuFood()
        return binding.root;

    }

    private fun searchMenuFood(){

        binding.serachMainItem.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                filterList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

  private fun filterList(input:String?){

      //input в поисковике
      val filteredList= if(input.isNullOrEmpty()){
          list
      }else{
          list.filter{item->
              item.getFoodName().contains(input,ignoreCase = true)
          }
      }
      adapter.updateList(filteredList as ArrayList<PopularModel>)
  }
}
