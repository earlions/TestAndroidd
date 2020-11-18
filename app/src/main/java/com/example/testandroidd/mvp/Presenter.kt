package com.example.testandroidd.mvp

import com.example.testandroidd.model.Model
import javax.inject.Inject

class Presenter @Inject constructor(private val view: MVP.view, private val model: Model) : MVP.presenter {
    override fun loadData() {
        view.showData(model.getData())
    }

   override fun loadInfo() {

        view.showInfo(model.getMaxPrice())
    }
}