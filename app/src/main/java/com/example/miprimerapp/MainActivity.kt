package com.example.miprimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    data class operaciondelacalculadora(
        //
        var operandouno:BigInteger,
        var operandodos:BigInteger,
        var resultado: BigInteger,
        var operacion:String
        )
        var listadeoperaciones: ArrayList<operaciondelacalculadora> = arrayListOf<operaciondelacalculadora>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lateinit var mRecyclerView : RecyclerView
        val mAdapter : adaptador = adaptador()


        var pantallita = findViewById<TextView>(R.id.pantallita)
        var btn_1 = findViewById<Button>(R.id.btn_1)
        var btn_2 = findViewById<Button>(R.id.btn_2)
        var btn_3 = findViewById<Button>(R.id.btn_3)
        var btn_4 = findViewById<Button>(R.id.btn_4)
        var btn_5 = findViewById<Button>(R.id.btn_5)
        var btn_6 = findViewById<Button>(R.id.btn_6)
        var btn_7 = findViewById<Button>(R.id.btn_7)
        var btn_8 = findViewById<Button>(R.id.btn_8)
        var btn_9 = findViewById<Button>(R.id.btn_9)
        btn_1.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+" "+btn_1.text)
        }
        btn_2.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_2.text)
        }
        btn_3.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_3.text)
        }
        btn_4.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_4.text)
        }
        btn_5.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_5.text)
        }
        btn_6.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_6.text)
        }
        btn_7.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_7.text)
        }
        btn_8.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_8.text)
        }
        btn_9.setOnClickListener{
            pantallita.setText(pantallita.text.toString()+btn_9.text)
        }

        var operando1 = 0
        var operando2 = 0
        var resultado = 0
        var operacion = ""

        val suma = findViewById<Button>(R.id.suma)
        suma.setOnClickListener {
            operando1 = pantallita.text.toString().toInt()
            operacion = "Suma"
            pantallita.setText("")
        }
        val restar = findViewById<Button>(R.id.resta)
        restar.setOnClickListener{
            operando1 = pantallita.text.toString().toInt()
            operacion = "Resta"
            pantallita.setText("")
        }
        val multiplica = findViewById<Button>(R.id.multiplica)
        multiplica.setOnClickListener{
            operando1 = pantallita.text.toString().toInt()
            operacion = "Multiplica"
            pantallita.setText("")
        }
        val divide = findViewById<Button>(R.id.divide)
        divide.setOnClickListener{
            operando1 = pantallita.text.toString().toInt()
            operacion = "Divide"
            pantallita.setText("")
        }
        val cs = findViewById<Button>(R.id.cs)
        cs.setOnClickListener{
            pantallita.setText("")
        }

        fun setUpRecycleView(){
            mRecyclerView = findViewById(R.id.recycle) as RecyclerView
            mRecyclerView.setHasFixedSize(true)
            mRecyclerView.layoutManager = LinearLayoutManager(this)
            mAdapter.adaptador(listadeoperaciones, this)
            mRecyclerView.adapter = mAdapter
        }

        val botoniguaL = findViewById<Button>(R.id.igual)
        botoniguaL.setOnClickListener {
            operando2 = pantallita.text.toString().toInt()
            when (operacion) {
                "Suma" -> resultado = operando1 + operando2
                "Resta" -> resultado = operando1 - operando2
                "Multiplica" -> resultado = operando1 * operando2
                "Divide" -> resultado = operando1 / operando2

            }
            pantallita.setText(resultado.toString())
            listadeoperaciones.add(operaciondelacalculadora(operando1.toBigInteger(),
                operando2.toBigInteger(),resultado.toBigInteger(),operacion));
            setUpRecycleView()
        }
    }
}