package com.example.dimi.common

import com.example.dimi.common.di.MainProvider

interface Main {
    fun getMainScreenComponent(): MainProvider
}