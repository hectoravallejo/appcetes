package vallejo.hector.calculadoracetes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import vallejo.hector.calculadoracetes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declaración de la variable para el binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val cantidadStr = binding.etCantidad.text.toString()
            val plazo = binding.sbPlazo.progress
            if (cantidadStr.isBlank() || plazo == 0) {
                Toast.makeText(this, "Valores inválidos, por favor ingrese valores válidos.", Toast.LENGTH_SHORT).show()
            } else {
                val cantidad = cantidadStr.toDouble()
                val rendimiento = calcularRendimiento(plazo, cantidad)
                val resultado = ((rendimiento * 100).toInt() / 100.0).toString()
                binding.tvResultado.text = "$$resultado"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("calculadora", "Estoy en onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("calculadora", "Estoy en onResume")
    }

    // Calcula el rendimiento basado en el plazo y la cantidad
    private fun calcularRendimiento(plazo: Int, cantidad: Double): Double {
        val interesPorMes = (11.0 / 12.0) / 100
        return cantidad + (interesPorMes * cantidad * plazo)
    }
}
