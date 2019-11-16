package com.darax.futblen.utils

import android.view.View

//Sirve para ocultar la barra de carga llamada en la funcion principal
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}