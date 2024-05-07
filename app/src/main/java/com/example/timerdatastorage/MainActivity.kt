package com.example.timerdatastorage

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timerdatastorage.databinding.ActivityMainBinding

private const val PREFERENCE_NAME = "preference_name"

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        repository = Repository(prefs)

        binding.textView.text = repository.getText()

        binding.buttonSave.setOnClickListener {
            repository.saveText(binding.editText.text.toString())
            binding.textView.text = repository.getText()
        }

        binding.buttonClear.setOnClickListener {
            repository.clearText()
            binding.textView.text = repository.getText()
        }
    }
}