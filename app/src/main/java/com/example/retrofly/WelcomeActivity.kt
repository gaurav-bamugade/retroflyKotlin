package com.example.retrofly

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofly.services.DestinationService
import com.example.retrofly.services.MessageService
import com.example.retrofly.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_welcome.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WelcomeActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_welcome)

		// To be replaced by retrofit code
		//message.text = "Black Friday! Get 50% cash back on saving your first spot."
		val messageService=ServiceBuilder.buildService(MessageService::class.java)
		val requestCall=messageService.getMessage("http://127.0.0.1:7000/messages")
		requestCall.enqueue(object:Callback<String>{
			override fun onResponse(call: Call<String>, response: Response<String>) {
 				if(response.isSuccessful)
				{
					 val msg=response.body()
					 msg?.let {
						 message.text=msg
					 }
				 }
				else{
					Toast.makeText(this@WelcomeActivity,"Fail",Toast.LENGTH_SHORT).show()
				}
 			}

			override fun onFailure(call: Call<String>, t: Throwable) {
				Log.d("repo123",t.toString())
				Toast.makeText(this@WelcomeActivity,"Fail",Toast.LENGTH_SHORT).show()

			}

		})

	}

	fun getStarted(view: View) {
		val intent = Intent(this, DestinationListActivity::class.java)
		startActivity(intent)
		finish()
	}
}
