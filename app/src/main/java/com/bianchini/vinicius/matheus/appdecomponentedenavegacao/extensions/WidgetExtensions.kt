package com.bianchini.vinicius.matheus.appdecomponentedenavegacao.extensions

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.dismisError() {
    this.error = null
    isErrorEnabled = false
}