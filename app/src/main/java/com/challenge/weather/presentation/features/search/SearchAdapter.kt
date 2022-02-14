package com.challenge.weather.presentation.features.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.weather.databinding.ItemSearchCityBinding
import com.challenge.weather.presentation.features.search.model.CityModel

class SearchAdapter(
    private val listener: SearchOnListener
) : RecyclerView.Adapter<SearchAdapter.SearchCityViewHolder>() {

    var items: List<CityModel> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCityViewHolder {
        return SearchCityViewHolder(
            ItemSearchCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchCityViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class SearchCityViewHolder(
        private val binding: ItemSearchCityBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(city: CityModel) = with(binding) {
            tvCityName.text = city.name
            tvCountryName.text = city.country

            root.setOnClickListener { listener.onClickCity(city) }
        }
    }

    interface SearchOnListener {
        fun onClickCity(city: CityModel)
    }

}