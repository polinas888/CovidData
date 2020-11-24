package com.example.coviddata.ui.countrydata.history

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import com.example.coviddata.databinding.HistoryCountryDataItemBinding
import com.example.coviddata.model.CountryData
import kotlinx.android.synthetic.main.history_world_data_item.view.date_history

class ListAdapter(private val list: List<CountryData>)
    : RecyclerView.Adapter<ListAdapter.HistoryCountryDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryCountryDataViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = HistoryCountryDataItemBinding.inflate(inflator, parent, false)
        val holder = HistoryCountryDataViewHolder(binding)
        return holder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HistoryCountryDataViewHolder, position: Int) {
        val historyCases = list[position]
        holder.bind(historyCases)
    }

    class HistoryCountryDataViewHolder(val binding: HistoryCountryDataItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var historyCases: CountryData? = null

        fun bind(item: CountryData) {
            this.historyCases = item
            binding.countryData = item
        }
    }
}