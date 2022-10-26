package com.example.qantas.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qantas.R
import com.example.qantas.databinding.AirportDetailViewBinding
import com.example.qantas.model.AirportData
import com.example.qantas.utils.AIRPORT_DETAILS
import com.example.qantas.viewmodel.AirportDetailsViewModel

class AirportDetailsActivity : AppCompatActivity() {
    private lateinit var binding: AirportDetailViewBinding
    private lateinit var viewModel: AirportDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AirportDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = AirportDetailsViewModel()
        updateUI()
    }

    //This function is used to update UI
    private fun updateUI() {
        val airportDetails = intent.getParcelableExtra<AirportData>(AIRPORT_DETAILS)
        binding.airportNameTv.text = getString(R.string.airport,airportDetails?.airportName)
        binding.countryNameTv.text = getString(R.string.country,airportDetails?.country?.countryName)
        binding.locationTv.text = getString(R.string.lat_long,airportDetails?.location?.latitude.toString() , airportDetails?.location?.longitude.toString())
        binding.timeZoneTv.text = getString(R.string.timezone,airportDetails?.city?.timeZoneName)
        binding.backBtn.setOnClickListener {
            onBackButtonClick()
        }
    }

    //This function is used for back button click
    private fun onBackButtonClick() {
        finish()
    }
}