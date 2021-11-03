package com.bianchini.vinicius.matheus.appdecomponentedenavegacao.extensions

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.R

private val navOptions = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setExitAnim(R.anim.slide_out_left)
    .setPopEnterAnim(R.anim.slide_in_left)
    .setPopExitAnim(R.anim.slide_out_right)
    .build()

//criando extensions
fun NavController.navigateWithAnimations(destinationId: Int) {
    this.navigate(destinationId, null, navOptions)
}