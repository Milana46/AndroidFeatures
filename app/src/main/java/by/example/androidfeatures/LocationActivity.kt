package by.example.androidfeatures

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import by.example.androidfeatures.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLocationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val countryList =
            arrayOf("Russia", "Belarus", "Uzbekistan", "Armenia", "Georgia", "England")
        val adapter =
            ArrayAdapter(this@LocationActivity, android.R.layout.simple_list_item_1, countryList)


        binding.locationList.setAdapter(adapter)

        binding.locationList.setOnItemClickListener { parent, view, position, l ->
            val selectedLocation = countryList[position]
            showDialogAtPosition(selectedLocation)
        }

    }

    private fun showDialogAtPosition(location: String) {

        val dialogView = layoutInflater.inflate(R.layout.aler_dialog, null)

        val dialogBuilder = AlertDialog.Builder(this@LocationActivity)
       .setView(dialogView)


        val dialog = dialogBuilder.create()
        dialog.show()


        dialogView.findViewById<AppCompatButton>(R.id.btn_yes).setOnClickListener {
            startActivityWithlocation(location)
            dialog.dismiss()
        }

        dialog.findViewById<AppCompatButton>(R.id.btn_cansel)?.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun startActivityWithlocation(location: String) {
        val intent = Intent(this@LocationActivity, MainActivity::class.java)
        intent.putExtra("location", location)
        startActivity(intent)
        //finish()

    }
}