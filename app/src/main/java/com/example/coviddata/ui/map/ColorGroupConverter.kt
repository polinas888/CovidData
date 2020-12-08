package com.example.coviddata.ui.map

import androidx.lifecycle.LiveData
import com.example.coviddata.R
import com.example.coviddata.model.CountryData

class ColorGroupConverter(val listCountries: List<CountryData>, val sortParamLiveData: LiveData<SortParamMap>) {
    data class MarkerInfo(
        val markerId: Int,
        val markerTitle: Int,
        val markerNumber: Long
    )

    fun getMarkerInfo(country: CountryData): MarkerInfo {
        return when (listCountries.indexOf(country).toDouble()) {
            in listCountries.size * 0.0 .. listCountries.size * 0.1 ->
                MarkerInfo(R.drawable.group1mapmarker, getTitle(sortParamLiveData.value!!),
                    getNumber(country, sortParamLiveData.value!!))
            in listCountries.size * 0.1 .. listCountries.size * 0.3 ->
                MarkerInfo(R.drawable.group2mapmarker, getTitle(sortParamLiveData.value!!),
                    getNumber(country, sortParamLiveData.value!!))
            in listCountries.size * 0.3 .. listCountries.size * 0.6 ->
                MarkerInfo(R.drawable.group3mapmarker, getTitle(sortParamLiveData.value!!),
                    getNumber(country, sortParamLiveData.value!!))
            in listCountries.size * 0.6 .. listCountries.size * 0.8 ->
                MarkerInfo(R.drawable.group4mapmarker, getTitle(sortParamLiveData.value!!),
                    getNumber(country, sortParamLiveData.value!!))
            else ->
                MarkerInfo(R.drawable.group5mapmarker, getTitle(sortParamLiveData.value!!),
                    getNumber(country, sortParamLiveData.value!!))
        }
    }

    fun getTitle(sortParamMap: SortParamMap): Int {
        return when (sortParamMap.ordinal) {
            SortParamMap.CASES.ordinal -> R.string.cases_title
            SortParamMap.DEATHS.ordinal -> R.string.deaths_title
            SortParamMap.RECOVERED.ordinal -> R.string.recovered_title
            SortParamMap.CASESPERMILLION.ordinal -> R.string.cases_per_one_million_title
            SortParamMap.DEATHSPERMILLION.ordinal -> R.string.deaths_per_one_million_title
            else -> R.string.tests_per_one_million_title
        }
    }

    fun getNumber(country: CountryData, sortParamMap: SortParamMap): Long {
        return when (sortParamMap.ordinal) {
            SortParamMap.CASES.ordinal -> country.cases.toLong()
            SortParamMap.DEATHS.ordinal -> country.deaths.toLong()
            SortParamMap.RECOVERED.ordinal -> country.recovered.toLong()
            SortParamMap.CASESPERMILLION.ordinal -> Math.round(country.casesPerOneMillion)
            SortParamMap.DEATHSPERMILLION.ordinal -> Math.round(country.deathsPerOneMillion)
            else -> Math.round(country.testsPerOneMillion)
        }
    }
}