package by.example.androidfeatures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.example.androidfeatures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //super.onCreate(savedInstanceState)
        setContentView(binding.root)

            //val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        //val navigationView = findNavController(R.id.fragment_container)



        //bottomNavView.setupWithNavController(navigationView)

    }

}

