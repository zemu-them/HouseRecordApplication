package work.zemu_them.android.houserecordapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.logging.LogManager

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    // lateIntのインスタンス作成
    private lateinit var locationManager: LogManager


    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
        val mapLaditude = intent.getDoubleExtra("latitude",0.0)
        val mapLongitude = intent.getDoubleExtra("longitude",0.0)

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(mapLaditude, mapLongitude)
        mMap.addMarker(MarkerOptions().position(sydney).title("Now Place").draggable(true))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap.setOnMarkerDragListener(object :GoogleMap.OnMarkerDragListener{
            override fun onMarkerDragStart(marker: Marker?) {
            }

            override fun onMarkerDrag(marker: Marker?) {
            }

            override fun onMarkerDragEnd(marker: Marker) {
                Toast.makeText(this@MapsActivity,"marker point 経度: ${marker.position.latitude}\nmarker point 緯度: ${marker.position.longitude}",Toast.LENGTH_SHORT).show()
            }
        })





    }
}
