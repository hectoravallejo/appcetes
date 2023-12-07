package vallejo.hector.calculadoracetes

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG="CalculadoraViewModel"

class CalculadoraViewModel:ViewModel(){
    init{
        Log.d(TAG,"Se creo el viewmodel")
    }
    override fun onCleared (){
        super.onCleared()
        Log.d(TAG,"Se elimino el viewmodel")
    }
}

/*Añadir propiedades al viewmodel que sea lisiting 4.7 del libro del coordinador
* guardar la cantidad el plazo y el pag 143 a 149 tarea libro*/