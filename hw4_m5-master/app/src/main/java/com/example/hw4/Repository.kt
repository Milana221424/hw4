package com.example.hw4

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw4.data.room.LoveDao
import com.example.hw4.remote.LoveApi
import com.example.hw4.remote.LoveModel
import com.example.hw4.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi, private val dao: LoveDao) {

    fun getDao(): LiveData<LoveModel>{
        return dao.getAll()
    }

    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val love = MutableLiveData<LoveModel>()

        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        love.postValue(it)
                        dao.insert(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure:${t.message}")
            }

        })
        return love
    }
}
