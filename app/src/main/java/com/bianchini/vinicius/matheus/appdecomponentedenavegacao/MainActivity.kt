package com.bianchini.vinicius.matheus.appdecomponentedenavegacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.databinding.ActivityMainBinding
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.databinding.FragmentStartBinding
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.ui.profile.ProfileFragment
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.ui.start.StartFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //usando uma toolbar personalizada e nao a tookbar padrão do android, esconde ela no theme.xml
        setSupportActionBar(binding.myToolbar)
    }

}