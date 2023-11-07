package com.ifal.storeranaufal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var progress: ProgressBar
    lateinit var swipe:SwipeRefreshLayout
    lateinit var fab:FloatingActionButton
    lateinit var recBarang:RecyclerView
    lateinit var barangList: ArrayList<Barang>
    lateinit var barangAdapter: BarangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getDataBarang()
        initView()
        barangList = ArrayList()
        recBarang.layoutManager = LinearLayoutManager(this)
        barangAdapter = BarangAdapter(barangList)
        recBarang.adapter = barangAdapter

        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, AddDataBarangActivity::class.java)
            startActivity(intent)
        }

        swipe.setOnRefreshListener {
            getDataBarang()
            swipe.isRefreshing = false
        }
    }

    private fun initView() {
        progress = findViewById(R.id.progressBar)
        swipe = findViewById(R.id.swipeLayout)
        fab = findViewById(R.id.fab)
        recBarang = findViewById(R.id.recBarang)
    }

    private fun getDataBarang(){
        var url= "https://ranaufalmuha.000webhostapp.com/getBarang.php"
        val queue = Volley.newRequestQueue(this@MainActivity)
        val request = JsonArrayRequest(Request.Method.GET, url,null, {
            response -> progress.visibility = View.GONE
            try {
                for (i in 0 until response.length()){
                    val responseObj = response.getJSONObject(i)
                    val barangNama = responseObj.getString("nama")
                    val barangKeterangan = responseObj.getString("keterangan")
                    val barangHarga = responseObj.getString("harga")
                    val barangGambar = responseObj.getString("gambar")
                    val barangPromo = responseObj.getString("promo")

                    barangList.add(Barang(barangNama,barangKeterangan,barangHarga,barangGambar,barangPromo))
                    barangAdapter.notifyDataSetChanged()
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        },{
            Toast.makeText(this@MainActivity, "GAGAL MENDAPATKAN DATA BARANG" , Toast.LENGTH_LONG).show()
        })
        queue.add(request)

    }
}