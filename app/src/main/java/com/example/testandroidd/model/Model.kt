package com.example.testandroidd.model

import com.example.testandroidd.data.Post
import com.example.testandroidd.data.PostInfo
import javax.inject.Inject

class Model @Inject constructor() {
    private val mPosts: MutableList<Post> = ArrayList()

    init {
        mPosts.add(Post("01/02/2020",4))
        mPosts.add(Post("02/02/2020",3))
        mPosts.add(Post("03/02/2020",4))
        mPosts.add(Post("04/02/2020",4))
        mPosts.add(Post("05/02/2020",3))
        mPosts.add(Post("06/02/2020",5))
        mPosts.add(Post("07/02/2020",6))
        mPosts.add(Post("08/02/2020",4))
        mPosts.add(Post("09/02/2020",3))
        mPosts.add(Post("10/02/2020",4))
        mPosts.add(Post("11/02/2020",4))
        mPosts.add(Post("12/02/2020",6))
        mPosts.add(Post("13/02/2020",7))
        mPosts.add(Post("14/02/2020",7))
    }
    fun getData(): MutableList<Post>{

        return mPosts
    }

    fun getMin(): MutableList<Post>{
        val minMax:MutableList<Int> = ArrayList()
        val minList: MutableList<Post> = ArrayList()
        for(post in mPosts){
            minMax.add(post.price)
        }
        val min = minMax.minOrNull()!!
        for (post in mPosts){
            if (post.price==min){
                minList.add(post)
            }
        }
        return minList
    }
    fun getMax(): MutableList<Post>{
        val minMax:MutableList<Int> = ArrayList()
        val maxList: MutableList<Post> = ArrayList()
        for(post in mPosts){
            minMax.add(post.price)
        }
        val max = minMax.maxOrNull()!!
        for (post in mPosts){
            if (post.price==max){
                maxList.add(post)
            }
        }
        return maxList
    }
    fun getMaxPrice():MutableList<PostInfo>{
        var maxPrice= 0
        var minBuy = mPosts[0].price
        var dataSale =""
        var dataBuy =""
        var buyBT=false
        val buy: MutableList<Post> = ArrayList()
        val price: MutableList<Post> = ArrayList()
        for(post in mPosts){
            if (!buyBT)
            if (post.price>minBuy){
                buy.add(Post(dataBuy,minBuy))
                buyBT=true
            }else{
                minBuy=post.price
                dataBuy=post.data
                dataSale = post.data
                maxPrice=post.price

            }
            if (buyBT)
                if (post.price>maxPrice){
                    dataSale = post.data
                    maxPrice=post.price
                }
                else {
                    price.add(Post(dataSale,maxPrice))
                    buyBT=false
                    minBuy=post.price
                    dataBuy=post.data
                }
        }

        val maxBenefit: MutableList<PostInfo> = ArrayList()
        for (i in 0 until buy.size){
            maxBenefit.add(PostInfo(buy[i].data,buy[i].price,price[i].data,price[i].price))
        }

    return maxBenefit}
}
