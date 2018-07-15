package com.example.dimi.domain

import com.example.dimi.data.MainRepository
import javax.inject.Inject

class MainInteractorImpl
@Inject constructor(private val mainRepository: MainRepository) : MainInteractor {
}