package com.example.dimi.common

interface Navigator {
    fun forward(className: String?)
    fun back(className: String?)
}