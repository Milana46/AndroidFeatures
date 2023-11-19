package by.example.androidfeatures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.example.androidfeatures.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodImage = intent.getIntExtra("foodImage", 0) //не забывать про тип данных
        val foodName = intent.getStringExtra("foodName")

        binding.menuDFoodImage.setImageResource(foodImage)
        binding.menuDFoodName.text = foodName

        binding.backHome.setOnClickListener{
            finish()
        }
    }
}
