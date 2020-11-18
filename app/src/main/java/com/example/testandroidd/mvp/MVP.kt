package com.example.testandroidd.mvp

import com.example.testandroidd.data.Post
import com.example.testandroidd.data.PostInfo


interface MVP {
    interface view{
        fun showData(mPosts: MutableList<Post>)
        fun showInfo(maxBenefit: MutableList<PostInfo>)
    }


    interface presenter {
        fun loadData()
        fun loadInfo()
    }
}
