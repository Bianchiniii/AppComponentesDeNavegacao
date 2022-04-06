package com.bianchini.vinicius.matheus.appdecomponentedenavegacao.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.R
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.databinding.FragmentProfileBinding
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.ui.login.LoginViewModel

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        serLoginViewModelBehaviour()
    }

    private fun serLoginViewModelBehaviour() {
        loginViewModel.authenticationStageEvent.observe(
            viewLifecycleOwner
        ) { authenticationState ->
            when (authenticationState) {
                is LoginViewModel.AuthenticationState.Authenticated -> {

                }

                is LoginViewModel.AuthenticationState.Unauthenticated -> {
                    findNavController().navigate(R.id.loginFragment)
                }
                else -> {}
            }
        }

    }
}