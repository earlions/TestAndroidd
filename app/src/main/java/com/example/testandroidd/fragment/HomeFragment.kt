package com.example.testandroidd.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testandroidd.R
import com.example.testandroidd.data.Post
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment(private val mPosts: MutableList<Post>) : Fragment() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val graph =  view.findViewById(R.id.graph) as GraphView
        val series: LineGraphSeries<DataPoint> = LineGraphSeries()
        for (post in mPosts){
            val x:Date = SimpleDateFormat("dd/MM/yyyy").parse(post.data)!!
            series.appendData(DataPoint(x, post.price.toDouble()), true, 15)
        }
        graph.addSeries(series)
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.isXAxisBoundsManual = true
        graph.gridLabelRenderer.numHorizontalLabels = 4
        graph.gridLabelRenderer.setHumanRounding(false)
        graph.gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(activity)

        return view
    }
}

