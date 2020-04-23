package com.app.studentsproject.di

import com.app.studentsproject.data.ItemsRepository
import com.app.studentsproject.domain.ItemsInteractor
import com.app.studentsproject.presentation.MainViewModel
import org.koin.dsl.module

fun createAppModule() = module {
    single { ItemsRepository() }
    single { ItemsInteractor(get(), get()) }
    single { MainViewModel(get()) }
}