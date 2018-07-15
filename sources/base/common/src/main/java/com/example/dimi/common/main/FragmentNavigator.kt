package com.example.dimi.common.main

interface FragmentNavigator {
    fun forward(data: Any, className: String?)
    fun back(className: String?)
}