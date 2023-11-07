package com.ifal.storeranaufal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest

class AddDataBarangActivity : AppCompatActivity() {
    var url_add = "https://ranaufalmuha.000webhostapp.com/add_barang.php"

    lateinit var namaBrg:EditText
    lateinit var deskBrg:EditText
    lateinit var hargaBrg:EditText
    lateinit var gambarBrg:EditText
    lateinit var promoBrg:EditText
    lateinit var btnAdd:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data_barang)

        initViewAdd()
        addDataBarang()
    }

    private fun addDataBarang() {

    }

    private fun initViewAdd() {
        namaBrg = findViewById(R.id.edtNama)
        deskBrg = findViewById(R.id.edtDeskripsi)
        hargaBrg = findViewById(R.id.edtHarga)
        gambarBrg = findViewById(R.id.edtLinkGambar)
        promoBrg = findViewById(R.id.edtPromo)
        btnAdd = findViewById(R.id.btnSimpan)
    }
}