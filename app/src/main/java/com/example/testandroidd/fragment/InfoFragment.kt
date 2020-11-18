package com.example.testandroidd.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidd.R
import com.example.testandroidd.data.Post
import com.example.testandroidd.data.PostInfo
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.list_item_home.view.*

class InfoFragment(private val maxBenefit: MutableList<PostInfo>) : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        val textProfit = view.findViewById(R.id.textProfit) as TextView
        var sum=0
        for (post in maxBenefit)
            sum+=post.benefit
        textProfit.text= "Максимальная выхода составляет: "+ (sum).toString()

        val recyclerViewMin = view.findViewById(R.id.recyclerViewMin) as RecyclerView
        recyclerViewMin.layoutManager = LinearLayoutManager(activity)
        recyclerViewMin.isNestedScrollingEnabled = false
        recyclerViewMin.adapter = RecyclerInfoAdapter(maxBenefit)

        return view
    }
    class RecyclerInfoAdapter internal constructor(private var mPosts: MutableList<PostInfo>): RecyclerView.Adapter<RecyclerInfoAdapter.TestHolder>() {

        class TestHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bindCrime(post: PostInfo) {
                itemView.textViewData.text = post.dataBuy
                itemView.textViewPrice.text = post.priceBuy.toString()
                itemView.textViewDataSale.text = post.dataSale
                itemView.textViewPriceSale.text = post.priceSale.toString()
                itemView.textViewFinal.text = post.benefit.toString()
            }


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.list_item_home,parent,false)
            return TestHolder(view)
        }

        override fun onBindViewHolder(holder: TestHolder, position: Int) {
            val post = mPosts[position]
            holder.bindCrime(post)
        }

        override fun getItemCount(): Int {
            return mPosts.size
        }
    }


}