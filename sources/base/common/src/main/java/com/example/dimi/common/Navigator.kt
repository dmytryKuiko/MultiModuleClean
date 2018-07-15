package com.example.dimi.common

interface Navigator {
    fun forward(id: Int, className: String?)
    fun back(className: String?)
}