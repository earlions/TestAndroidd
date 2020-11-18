package com.example.testandroidd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.testandroidd.dagger2.DaggerComponent
import com.example.testandroidd.dagger2.Module
import com.example.testandroidd.data.Post
import com.example.testandroidd.data.PostInfo
import com.example.testandroidd.fragment.HomeFragment
import com.example.testandroidd.fragment.InfoFragment
import com.example.testandroidd.mvp.MVP
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MVP.view {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = DaggerComponent.builder().module(Module(this)).build().getPresenter()
        presenter.loadData()
        var but = true
        button.setOnClickListener{
            if (but){
                but=false
                presenter.loadInfo()}
            else{
                but=true
                presenter.loadData()}
        }
    }

    override fun showData(mPosts: MutableList<Post>) {
        val fTrans = supportFragmentManager.beginTransaction()
        val frag:Fragment = HomeFragment(mPosts)
        fTrans.replace(R.id.fragmentView, frag).commit()

    }

    override fun showInfo(maxBenefit: MutableList<PostInfo>) {
        val fTrans = supportFragmentManager.beginTransaction()
        val frag:Fragment = InfoFragment(maxBenefit)
        fTrans.replace(R.id.fragmentView, frag).commit()
    }

}