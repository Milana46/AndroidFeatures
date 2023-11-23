package by.example.androidfeatures

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import by.example.androidfeatures.Adapter.PopularAdapter
import by.example.androidfeatures.Adapter.imageSladeAdapter
import by.example.androidfeatures.Models.PopularModel
import by.example.androidfeatures.Models.SharedModel
import kotlin.math.abs


class HomeFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var imageSladeAdapter: imageSladeAdapter  //ссылка
    private lateinit var imageList: ArrayList<Int>
    private lateinit var handler: Handler //держатель

    private lateinit var popularAdapter: PopularAdapter
    private lateinit var listPopular: ArrayList<PopularModel>
    private var homeRv: RecyclerView? = null

    private lateinit var goMenuText:TextView

    private lateinit var sharedModel: SharedModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager2 = view.findViewById(R.id.imageSlider)
        sharedModel= ViewModelProvider(requireActivity()).get(SharedModel::class.java)

        homeRv = view.findViewById(R.id.home_RV) as RecyclerView
        goMenuText=view.findViewById(R.id.go_menu)

        goMenuText.setOnClickListener{

            val bottomSheetMenu=MenuBottomSheetFragment()  //экземпляр фрагмента!!!

            bottomSheetMenu.show(parentFragmentManager,"test")

        }


        listPopular = ArrayList()
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "7$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "5$",1))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Burger", "6$",1))

        popularAdapter = PopularAdapter(requireContext(), listPopular) //экземпляр класса PopularAdapter;
        popularAdapter.setSharedModel(sharedModel)

        homeRv?.adapter=popularAdapter
        homeRv?.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.run {
                    removeCallbacks(runnable)
                    postDelayed(runnable, 2000)
                }
            }
        })
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setTransformer() {
        val transformer = CompositePageTransformer()//для держания нескольких image
        transformer.addTransformer(MarginPageTransformer(10))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.8f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private fun init() {

        imageList = ArrayList()
        imageSladeAdapter = imageSladeAdapter(requireContext(), imageList, viewPager2)
        handler = Handler(Looper.myLooper()!!)

        imageList.add(R.drawable.banner_1)
        imageList.add(R.drawable.banner_2)
        imageList.add(R.drawable.banner_3)
        imageList.add(R.drawable.banner_4)
        imageList.add(R.drawable.banner_5)
        imageList.add(R.drawable.banner_6)
        imageList.add(R.drawable.banner_7)
        imageList.add(R.drawable.banner_8)
        imageList.add(R.drawable.banner_9)
        imageList.add(R.drawable.banner_10)
        imageList.add(R.drawable.banner_11)
        imageList.add(R.drawable.banner_12)

        viewPager2.adapter = imageSladeAdapter
        viewPager2.offscreenPageLimit = 3  //кол-во image на activity

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
}