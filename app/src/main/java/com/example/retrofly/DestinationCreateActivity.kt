package com.example.retrofly

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofly.helpers.SampleData
import com.example.retrofly.models.Destination
import com.example.retrofly.services.DestinationService
import com.example.retrofly.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_destiny_create.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class DestinationCreateActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_destiny_create)

		setSupportActionBar(toolbar)
		val context = this

		// Show the Up button in the action bar.
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		btn_add.setOnClickListener {
			val newDestination = Destination()
			newDestination.city = et_city.text.toString()
			newDestination.description = et_description.text.toString()
			newDestination.country = et_country.text.toString()

			// To be replaced by retrofit code
			/*SampleData.addDestination(newDestination)
            finish()*/ // Move back to DestinationListActivity

			val destinationService=ServiceBuilder.buildService(DestinationService::class.java)
			val requestCall=destinationService.addDestination(newDestination)
			requestCall.enqueue(object :retrofit2.Callback<Destination>{
				override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
					if(response.isSuccessful)
					{
						finish()
					}
					else
					{
						Toast.makeText(this@DestinationCreateActivity,"Failed",Toast.LENGTH_SHORT).show()
					}
				}

				override fun onFailure(call: Call<Destination>, t: Throwable) {
					Toast.makeText(this@DestinationCreateActivity,"Failed",Toast.LENGTH_SHORT).show()
				}
			})


		}
	}
}
