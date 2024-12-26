package com.cursosant.inventorybase.addModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosant.inventorybase.entities.Product
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*La prioridad es crear todos los test posibles dentro de test unitarios (no androidTest) ya que no
requiere el sdk de Android y reduce recursos. Tamien pueden ir en test las pruebas instrumentadas. */
@RunWith(AndroidJUnit4::class)
class AddViewModelTest{
    //Regla para resolver problemas de despendencias de livedata
    @get:Rule
    var instantExcecutorRule = InstantTaskExecutorRule()

    @Test
    fun addProductTest(){
        /*En esta prueba queremos probar que al ejecutar el método addProduct, la variable result
        cambie de valor, y se modifique el liveData.
         */
        val addViewModel = AddViewModel()
        val product = Product(117, "Xbox", 2, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFJymqVnDKjNpKb96VPTWFUs50uJMtru-LBg&s", 4.8, 56)
        val observer = Observer<Boolean>{}
        try {
            addViewModel.getResult().observeForever(observer)
            addViewModel.addProduct(product)
            val result = addViewModel.getResult().value
            assertThat(result, `is`(true))
            //assertThat(result, not(nullValue()))esto se podria usar para solo evaluar que cambie el livedata
        }finally {
            addViewModel.getResult().removeObserver(observer)
        }
    }

}