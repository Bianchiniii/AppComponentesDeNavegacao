package com.bianchini.vinicius.matheus.appdecomponentedenavegacao.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.databinding.LoginFragmentBinding
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.extensions.dismisError
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    private lateinit var binding: LoginFragmentBinding

    //cria o viewmodel automatico e coloca no scopo da activity principal, podendo chamar o viewmodel
    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mutableLiveDataObserver()
        setBtnEntrar()
        setInputLayoutLoginUsernameBehaviour()
        setInputLayoutLoginPasswordBehaviour()
    }

    private fun setBtnEntrar() {
        binding.buttonLoginSignIn.setOnClickListener {
            val username = binding.inputLoginUsername.text.toString()
            val password = binding.inputLoginPassword.text.toString()
            viewModel.authentication(username, password)
        }
    }

    private fun mutableLiveDataObserver() {
        viewModel.authenticationStageEvent.observe(viewLifecycleOwner, { authenticationState ->
            when (authenticationState) {
                is LoginViewModel.AuthenticationState.InvalidAuthenticationState -> {
                    val validationFields: Map<String, TextInputLayout> = initValidationFields()
                    authenticationState.fiends.forEach { fieldError ->
                        validationFields[fieldError.first]?.error = getString(fieldError.second)
                    }
                }
            }
        })
    }

    private fun initValidationFields() = mapOf(
        //first para usar o 1 valor do chave valor
        LoginViewModel.INPUT_USERNAME.first to binding.inputLayoutLoginUsername,
        LoginViewModel.INPUT_PASSWORD.first to binding.inputLayoutLoginPassword
    )

    private fun setInputLayoutLoginUsernameBehaviour() {
        binding.inputLayoutLoginUsername.addOnEditTextAttachedListener { it.dismisError() }
    }

    private fun setInputLayoutLoginPasswordBehaviour() {
        binding.inputLayoutLoginPassword.addOnEditTextAttachedListener { it.dismisError() }
    }
}