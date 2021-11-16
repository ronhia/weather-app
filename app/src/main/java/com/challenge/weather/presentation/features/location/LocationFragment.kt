package com.challenge.weather.presentation.features.location

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challenge.weather.R
import com.challenge.weather.databinding.FragmentLocationBinding
import com.challenge.weather.presentation.base.BaseFragment
import com.challenge.weather.presentation.features.location.model.CoordinateModel
import com.challenge.weather.utils.extensions.hasPermissions
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class LocationFragment : BaseFragment<FragmentLocationBinding>(),
    OnMapReadyCallback {

    private var googleMap: GoogleMap? = null
    private val coordinate: CoordinateModel? by lazy {
        arguments?.getParcelable(ARG_COORDINATE)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLocationBinding {
        return FragmentLocationBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (hasPermissions(locationPermission)) {
            setupMap()
        }
    }

    private fun setupMap() {
        val mapFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.location_fl_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map

        coordinate?.apply {
            val latLng = LatLng(latitude, longitude)
            googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f))
        } ?: run {
            setupLastLocation()
        }

        setupGoogleMaps()
    }

    @SuppressLint("MissingPermission")
    private fun setupLastLocation() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            val latLng = LatLng(location.latitude, location.longitude)
            googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f))
        }
    }

    @SuppressLint("MissingPermission")
    private fun setupGoogleMaps() {
        googleMap?.apply {
            isMyLocationEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }
    }

    companion object {

        const val ARG_COORDINATE = "arg.coordinate"
        private val locationPermission = listOf(android.Manifest.permission.ACCESS_FINE_LOCATION)

        @JvmStatic
        fun newInstance() = LocationFragment()
    }
}