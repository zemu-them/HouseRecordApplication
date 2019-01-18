package work.zemu_them.android.houserecordapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.location.places.Places
import com.google.android.gms.location.places.ui.PlacePicker

import android.content.Intent
import android.util.Log


class MapsActivity : AppCompatActivity() {
    val PLACE_PICKER_REQUEST = 1

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        //Google Maps API places
        // Construct a GeoDataClient.
        val mGeoDataClient = Places.getGeoDataClient(this);

        // Construct a PlaceDetectionClient.
        val mPlaceDetectionClient = Places.getPlaceDetectionClient(this);

        // TODO: Start using the Places API.

        val builder = PlacePicker.IntentBuilder()

        startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val place = PlacePicker.getPlace(this, data)
                val toastMsg = String.format("Place: %s", place.name)
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show()
                //MapActivityに画面遷移
                val mapIntent = Intent(this,MoneyRegistActivity::class.java)
                mapIntent.putExtra("latitude",place.latLng.latitude)
                mapIntent.putExtra("longitude",place.latLng.longitude)
                mapIntent.putExtra("name",place.name)
                Log.d("debug","Intent 店名:${place.name}")
                Log.d("debug","Intent 経度:${place.latLng.latitude}")
                Log.d("debug","Intent 緯度:${place.latLng.longitude}")
                startActivity(mapIntent)
            }
        }
    }
}
