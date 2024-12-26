package com.cursosant.inventorybase.mainModule.viewModel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

//@Config(sdk = [24,25,30])//para indicar con que sdk hacer las pruebas
@Config(maxSdk = 30)//prueba con cada una de las versiones hasta la indicada, 30 en este caso
@RunWith(AndroidJUnit4::class)
class MainViewModelTest{
    //Regla para resolver problemas de despendencias de livedata
    @get:Rule
    var instantExcecutorRule = InstantTaskExecutorRule()

    @Test
    fun check_welcomeTest(){
        val mainViewModel = MainViewModel(ApplicationProvider.getApplicationContext())
        val observer = Observer<Boolean>{}
        try {
            mainViewModel.isWelcome().observeForever(observer)
            val result = mainViewModel.isWelcome().value
            assertThat(result, not(nullValue()))
            assertThat(result, `is`(true))
        }finally {
            mainViewModel.isWelcome().removeObserver(observer)
        }
    }
}