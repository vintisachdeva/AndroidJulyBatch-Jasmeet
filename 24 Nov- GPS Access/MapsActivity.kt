package com.bmpl.map

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    //private var mMap: GoogleMap? = null

    lateinit var mContext: Context
    lateinit var gps: GpsAccess
    private var latitude: Double = 0.toDouble()
    private var longitude: Double = 0.toDouble()
    private val DEFAULT_ZOOM = 15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        mContext = this

        if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MapsActivity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)

        } else {
            Toast.makeText(mContext, "You need have granted permission", Toast.LENGTH_SHORT).show()
            gps = GpsAccess(mContext, this@MapsActivity)

            if (gps.canGetLocation()) {

                latitude = gps.getLatitude()
                longitude = gps.getLongitude()

                Toast.makeText(applicationContext, "Your Location is - \nLat: $latitude\nLong: $longitude", Toast.LENGTH_LONG).show()
            } else {
                gps.showSettingsAlert()
            }
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1 -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    gps = GpsAccess(mContext, this@MapsActivity)

                    if (gps.canGetLocation()) {

                        latitude = gps.getLatitude()
                        longitude = gps.getLongitude()

                        Toast.makeText(applicationContext, "Your Location is - \nLat: $latitude\nLong: $longitude", Toast.LENGTH_LONG).show()
                    } else {
                        gps.showSettingsAlert()
                    }

                } else {

                    Toast.makeText(mContext, "You need to grant permission", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val location = LatLng(latitude, longitude)
        mMap!!.addMarker(MarkerOptions().position(location).title("Marker in Current Location"))

        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), DEFAULT_ZOOM.toFloat()))

    }

}
