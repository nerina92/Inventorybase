package com.cursosant.inventorybase.addModule.view

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosant.inventorybase.R
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.hamcrest.Matchers.nullValue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddProductFragmentTest{
    //verificamos que al crear el fragment, el dialog no sea null
    @Test
    fun createDialog_notNullTest(){
        //Si no pasamos el Tema como parametro no va a funcionar el test
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_InventoryBase)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment { fragment ->
            assertThat(fragment.dialog, `is`(notNullValue()))
        }
    }

    //Esta prueba verifica que al presionar el boton negativo se cierre el dialogo
    //Verifica que al crearse y el usuario toque cancelar, el dialog desaparezca y se vuelva null
    @Test
    fun cancelDialog_isNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_InventoryBase)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment{ fragment ->
            (fragment.dialog as? AlertDialog)?.let {
                it.getButton(DialogInterface.BUTTON_NEGATIVE).performClick()
                assertThat(fragment.dialog, `is`(nullValue()))
            }
        }
    }


}