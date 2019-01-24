package work.zemu_them.android.houserecordapplication

import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 位置情報を取得できるクラス
    private lateinit var fusedLocationClient : FusedLocationProviderClient

    private var locationCallback: LocationCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onStart() {
        super.onStart()

        fusedLocationClient = FusedLocationProviderClient(this)

        val locationRequest = LocationRequest().apply{
            interval = 60000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        locationCallback = object : LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult?){
                val location = locationResult?.lastLocation ?: return
                Log.d("debug","経度:${location.latitude},経度:${location.longitude}")
                Toast.makeText(this@MainActivity,
                    "経度:${location.latitude},経度:${location.longitude}", Toast.LENGTH_SHORT).show()
            }
        }

        fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())

        fab_menu_map.setOnClickListener{view ->

            //TODO something when floating action menu first item clicked
            //MapActivityに画面遷移
            val mapIntent = Intent(this,MapsActivity::class.java)
            startActivity(mapIntent)
        }
    }

    override fun onStop() {
        super.onStop()

        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
