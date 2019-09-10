package com.example.llamadajava

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {
    var botonLlamar :Button?=null
    var loadingContainer :View?=null
    var sendBoton :View?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendBoton = findViewById(R.id.sendButton1)
        botonLlamar = findViewById(R.id.botonLlamar)
        botonLlamar!!.setOnClickListener { showLoading(true) }
        loadingContainer = findViewById(R.id.loadingContainer)
        loadingContainer!!.setOnClickListener { showLoading(false) }
    }
    private fun showLoading(show: Boolean) {
        val visibility = if(show) View.VISIBLE else View.GONE
        loadingContainer!!.visibility = visibility
        sendBoton!!.visibility = View.GONE
    }
}