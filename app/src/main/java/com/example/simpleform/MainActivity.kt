package com.example.simpleform

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleform.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtonClickListener()
    }


//    private fun setupButtonClickListener() {
//
//        binding.buttonclick.setOnClickListener {
//            val email = binding.editTextEmail.text.toString().trim()
//            val mobileNumber = binding.editTextMobileNumber.text.toString().trim()
//            val firstName = binding.editTextName.text.toString().trim()
//            val middleName = binding.editTextMiddleName.text.toString().trim()
//            val lastName = binding.editTextLastName.text.toString().trim()
//
//            when {
//                firstName.isEmpty() -> showToast(R.string.error_empty_firstname)
//                email.isEmpty() -> showToast(R.string.error_empty_email)
//                else -> {
//                    val intent = Intent(this, DisplayActivity::class.java).apply {
//                        putExtra("FIRST_NAME", firstName)
//                        putExtra("MIDDLE_NAME", middleName)
//                        putExtra("LAST_NAME", lastName)
//                        putExtra("MOBILE_NUMBER", mobileNumber)
//                        putExtra("EMAIL", email)
//                    }
//                    startActivity(intent)
//                }
//            }
//            val selectedGenderId = binding.radioGroupGender.checkedRadioButtonId
//            val gender = when (selectedGenderId) {
//                R.id.radio_button_male -> "Male"
//                R.id.radio_button_female -> "Female"
//                R.id.radio_button_other -> "Other"
//                else -> ""
//            }
//        }
//
//    }
private fun setupButtonClickListener() {
    binding.buttonclick.setOnClickListener {
        val email = binding.editTextEmail.text.toString().trim()
        val mobileNumber = binding.editTextMobileNumber.text.toString().trim()
        val firstName = binding.editTextName.text.toString().trim()
        val middleName = binding.editTextMiddleName.text.toString().trim()
        val lastName = binding.editTextLastName.text.toString().trim()

        when {
            firstName.isEmpty() -> showToast(R.string.error_empty_firstname)
            email.isEmpty() -> showToast(R.string.error_empty_email)
            else -> {
                val selectedGenderId = binding.radioGroupGender.checkedRadioButtonId
                val gender = when (selectedGenderId) {
                    R.id.radio_button_male -> "Male"
                    R.id.radio_button_female -> "Female"
                    R.id.radio_button_other -> "Other"
                    else -> ""
                }
                val selectedSkills = mutableListOf<String>()
                if (binding.checkboxAndroid.isChecked) selectedSkills.add("Android")
                if (binding.checkboxKotlin.isChecked) selectedSkills.add("Kotlin")
                if (binding.checkboxFlutter.isChecked) selectedSkills.add("Flutter")
                if (binding.checkboxJava.isChecked) selectedSkills.add("Java")


                val skillsString = selectedSkills.joinToString(", ")



                val intent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra("FIRST_NAME", firstName)
                    putExtra("MIDDLE_NAME", middleName)
                    putExtra("LAST_NAME", lastName)
                    putExtra("MOBILE_NUMBER", mobileNumber)
                    putExtra("EMAIL", email)
                    putExtra("GENDER", gender)
                    putExtra("SKILLS", skillsString)
                }
                startActivity(intent)
            }
        }
    }
}
    private fun showToast(messageResId: Int) {
        Toast.makeText(this, getString(messageResId), Toast.LENGTH_SHORT).show()
    }

    private fun showSnackbar(messageResId: Int) {
        Snackbar.make(binding.root, getString(messageResId), Snackbar.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_edit -> {

                true
            }
            R.id.action_settings -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
