package com.example.retrofly

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofly.helpers.DestinationAdapter
import com.example.retrofly.helpers.SampleData
import com.example.retrofly.models.Destination
import com.example.retrofly.services.DestinationService
import com.example.retrofly.services.ServiceBuilder


import kotlinx.android.synthetic.main.activity_destiny_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class DestinationListActivity : AppCompatActivity() {
	private var rc: RecyclerView? =null

	private lateinit var catada:DestinationAdapter
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_destiny_list)

		setSupportActionBar(dest_toolbar)
		dest_toolbar.title = title

		fab.setOnClickListener {
			val intent = Intent(this@DestinationListActivity, DestinationCreateActivity::class.java)
			startActivity(intent)
		}
		// To be replaced by retrofit code





	}

	override fun onResume() {
		super.onResume()

		loadDestinations()
	}
	private fun loadDestinations() {
            val destinationService:DestinationService=ServiceBuilder.buildService(DestinationService::class.java)
            val filter=HashMap<String,String>()
		filter.put("country","India")
/*            filter.put("country","India")
            filter.put("count","1")*/

            val requestCall:Call<List<Destination>> = destinationService.getDestinationList(filter)
            requestCall.enqueue(object: Callback<List<Destination>>{
                override fun onResponse(
                    call: Call<List<Destination>>,
                    response: Response<List<Destination>>
                ) {
                    if(response.isSuccessful)
                    {
                        //val destinationList:List<Destination> = response.body()!!
                        //d_recycler_view.adapter= DestinationAdapter(SampleData.DESTINATIONS)
                        val destinationList:List<Destination> = response.body()!!
                        Log.d("response",response.toString())
                        catada= DestinationAdapter(destinationList)
                        d_recycler_view.adapter=catada
                        d_recycler_view.layoutManager=LinearLayoutManager(this@DestinationListActivity)

                    }

                }

                override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                    Log.d("response",t.toString())
                }

            })

        }
	/*private fun loadDestinations() {
		val destinationService:DestinationService=ServiceBuilder.buildService(DestinationService::class.java)
		val filter=HashMap<String,String>()
		filter.put("country","India")
		filter.put("count","1")

		val requestCall:Call<List<Destination>> = destinationService.getDestinationList(filter)
		requestCall.enqueue(object: Callback<List<Destination>>{
			override fun onResponse(
				call: Call<List<Destination>>,
				response: Response<List<Destination>>
			) {
				if(response.isSuccessful)
				{
					//val destinationList:List<Destination> = response.body()!!
					//d_recycler_view.adapter= DestinationAdapter(SampleData.DESTINATIONS)
					val destinationList:List<Destination> = response.body()!!
					Log.d("response",response.toString())
					catada= DestinationAdapter(destinationList)
					d_recycler_view.adapter=catada
					d_recycler_view.layoutManager=LinearLayoutManager(this@DestinationListActivity)

				}

			}

			override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
				Log.d("response",t.toString())
			}

		})

	}*/
	private fun items(): ArrayList<Destination>  {
		var arrayList: ArrayList<Destination> = ArrayList()

		arrayList.add(Destination(1, "Pizza","Pizza","Pizza"))
		arrayList.add(Destination(2, "Pizza","Pizza","Pizza"))
		arrayList.add(Destination(3, "Pizza","Pizza","Pizza"))
		arrayList.add(Destination(4, "Pizza","Pizza","Pizza"))
		arrayList.add(Destination(5, "Pizza","Pizza","Pizza"))
		arrayList.add(Destination(6, "Pizza","Pizza","Pizza"))
		arrayList.add(Destination(7, "Pizza","Pizza","Pizza"))
		return arrayList
	}
}
