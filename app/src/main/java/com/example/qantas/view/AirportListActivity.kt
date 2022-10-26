package com.example.qantas.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qantas.adapter.AirportListAdapter
import com.example.qantas.databinding.AirportListActivityBinding
import com.example.qantas.listener.OnItemClickListener
import com.example.qantas.model.AirportData
import com.example.qantas.services.MyViewModelFactory
import com.example.qantas.services.RetrofitService
import com.example.qantas.utils.AIRPORT_DETAILS
import com.example.qantas.viewmodel.AirportListViewModel
import com.example.qantas.viewmodel.MainRepository

class AirportListActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: AirportListActivityBinding
    private lateinit var viewModel: AirportListViewModel
    private lateinit var airportListAdapter: AirportListAdapter

    // Initializing an empty ArrayList
    private var list: ArrayList<AirportData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AirportListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this@AirportListActivity,
            MyViewModelFactory(MainRepository(RetrofitService.getInstance()))
        ).get(AirportListViewModel::class.java)

        viewModel.fetchData()

        airportListAdapter = AirportListAdapter(list, this@AirportListActivity, this)
        binding.airportListRV.layoutManager = LinearLayoutManager(applicationContext)
        binding.airportListRV.itemAnimator = DefaultItemAnimator()
        binding.airportListRV.adapter = airportListAdapter

        observeResponse()
    }

    private fun observeResponse() {
        viewModel.responseList.observe(this) {
            airportListAdapter.items = it
            airportListAdapter.notifyDataSetChanged()
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressView.visibility = View.VISIBLE
            } else {
                binding.progressView.visibility = View.GONE
            }
        })
    }

    override fun onListItemClick(item: AirportData?) {
        val intent = Intent(this, AirportDetailsActivity::class.java)
        intent.putExtra(AIRPORT_DETAILS, item)
        startActivity(intent)
    }
}