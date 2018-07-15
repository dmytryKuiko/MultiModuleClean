package com.example.dimi.common.main

import com.example.dimi.common.di.MainProvider

interface Main {
    fun getMainScreenComponent(): MainProvider
}