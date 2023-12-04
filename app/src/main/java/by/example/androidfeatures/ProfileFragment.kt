package by.example.androidfeatures

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.example.androidfeatures.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding:FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentProfileBinding.inflate(inflater,container,false)

        binding.knopka.setOnClickListener {

            val bottomF =MySale() //экземпляр
           // bottomF.show(supportFragmentManager, "Test")
        }

        binding.backHome2.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


}