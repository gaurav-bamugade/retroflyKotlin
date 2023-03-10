package com.example.retrofly.services


 import com.example.retrofly.models.Destination
 import retrofit2.Call
 import retrofit2.http.*

interface DestinationService {
/*
    @GET("destination")
    fun getDestinationList(): Call<List<Destination>>*/

     @GET("destination")
    fun getDestinationList(@QueryMap filter:HashMap<String,String>, ): Call<List<Destination>>

/*    @GET("destination")
    fun getDestinationList(@Query("country") country:String, @Query("count")count:String): Call<List<Destination>>
  */
    //path parameter
    @GET("destination/{id}")
    fun getDestination(@Path("id")id:Int):Call<Destination>
/*
    @GET
    fun getMessage(@Url anotherurl:String): Call<String>*/

    @POST("destination")
    fun addDestination(@Body newDestination:Destination):Call<Destination>

    @FormUrlEncoded
    @PUT("destination/{id}")
    fun updateDestination(
        @Path("id")id:Int,
        @Field("city")city:String,
        @Field("description") desc:String,
        @Field("country") country:String
    ):Call<Destination>

    @DELETE("destination/{id}")
    fun deleteDestination(@Path("id")id:Int ):Call<Unit>

}