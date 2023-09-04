package com.example.mytest

sealed class Screen(val itineraire : String) {
    object Inscription : Screen("inscription")
}
