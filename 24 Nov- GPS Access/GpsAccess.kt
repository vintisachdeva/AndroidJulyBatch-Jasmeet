package com.bmpl.map

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Service
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log


class GpsAccess : Service {

    private val mContext : Context

    internal var isGPSEnabled = false

    internal var isNetworkEnabled = false

    internal var canGetLocation = false

    internal var location: Location? = null // Location
    internal var latitude: Double = 0.toDouble() // Latitude
    internal var longitude: Double = 0.toDouble() // Longitude

    // Declaring a Location Manager
    protected var locationManager: LocationManager? = null

    internal lateinit var activity: Activity


    private val mLocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {

            if (location != null) {
                latitude = location!!.getLatitude()
                longitude = location!!.getLongitude()
            }
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

        }

        override fun onProviderEnabled(provider: String) {

        }

        override fun onProviderDisabled(provider: String) {

        }
    }

    constructor(mContext: Context) {
        this.mContext = mContext
    }

    constructor(context: Context, activity: Activity) {
        this.mContext = context
        this.activity = activity
        getLocation()
    }

    @SuppressLint("MissingPermission")
    fun getLocation(): Location? {
        try {


            locationManager = mContext.getSystemService(LOCATION_SERVICE) as LocationManager?

            isGPSEnabled = locationManager!!
                    .isProviderEnabled(LocationManager.GPS_PROVIDER)

            isNetworkEnabled = locationManager!!
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (!isGPSEnabled && !isNetworkEnabled) {
            } else {
                this.canGetLocation = true
                if (isNetworkEnabled) {
                    val requestPermissionsCode = 50

                    //predefined method
                    locationManager!!.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), mLocationListener)
                    Log.d("Network", "Network")
                    if (locationManager != null) {
                        location = locationManager!!
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                        if (location != null) {
                            latitude = location!!.getLatitude()
                            longitude = location!!.getLongitude()
                        }
                    }
                }
            }
            if (isGPSEnabled) {
                if (location == null) {
                    if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 50)

                    } else {
                        locationManager!!.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), mLocationListener)
                        Log.d("GPS Enabled", "GPS Enabled")
                        if (locationManager != null) {

                            location = locationManager!!
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                            if (location != null) {
                                latitude = location!!.getLatitude()
                                longitude = location!!.getLongitude()
                            }
                        }
                    }
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return location
    }

    fun stopUsingGPS() {

    }

    fun getLatitude(): Double {
        if (location != null) {
            latitude = location!!.getLatitude()
        }

        return latitude
    }


    fun getLongitude(): Double {
        if (location != null) {
            longitude = location!!.getLongitude()
        }

        return longitude
    }

    fun canGetLocation(): Boolean {
        return this.canGetLocation
    }

    fun showSettingsAlert() {
        val alertDialog = AlertDialog.Builder(mContext)

        alertDialog.setTitle("GPS settings")

        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?")

        alertDialog.setPositiveButton("Settings", DialogInterface.OnClickListener { dialog, which ->
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            mContext.startActivity(intent)
        })

        alertDialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
        alertDialog.show()
    }

    override fun onBind(arg0: Intent): IBinder? {
        return null
    }

    companion object {

        private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 1000 // 10 meters

        // The minimum time between updates in milliseconds
        private val MIN_TIME_BW_UPDATES = (1000 * 60 * 1).toLong() // 1 minute
    }
}
