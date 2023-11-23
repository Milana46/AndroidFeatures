package by.example.androidfeatures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.example.androidfeatures.databinding.ActivityDetails2Binding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetails2Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityDetails2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backStack.setOnClickListener {
            onBackPressed()
        }

        binding.placeMyOrder.setOnClickListener {

            val bottomFragment = SuccessPayment() //экземпляр
            bottomFragment.show(supportFragmentManager, "Test")
        }

    }


}