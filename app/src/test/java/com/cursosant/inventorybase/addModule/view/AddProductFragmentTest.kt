package com.cursosant.inventorybase.addModule.view

import androidx.fragment.app.testing.launchFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosant.inventorybase.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddProductFragmentTest{
    @Test
    fun createDialog_notNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_InventoryBase)

    }
}