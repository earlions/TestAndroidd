package com.example.testandroidd.dagger2

import com.example.testandroidd.model.Model
import com.example.testandroidd.mvp.MVP
import dagger.Module
import dagger.Provides

@Module
class Module(private val view: MVP.view) {
    @Provides
    fun view(): MVP.view {
        return view
    }
}