package com.example.testandroidd.dagger2

import com.example.testandroidd.mvp.Presenter
import dagger.Component

@Component(modules = [Module::class])
interface Component {
    fun getPresenter(): Presenter
}