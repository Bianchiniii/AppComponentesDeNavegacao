package com.bianchini.vinicius.matheus.appdecomponentedenavegacao.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.R
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.databinding.FragmentStartBinding
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.extensions.navigateWithAnimations

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            findNavController().navigateWithAnimations(R.id.action_startFragment2_to_loginFragment)
        }
    }
}