package ru.pashaginas.myapplication

import androidx.fragment.app.Fragment

interface BaseRouter {
    fun routeTo(fragment: Fragment)
}