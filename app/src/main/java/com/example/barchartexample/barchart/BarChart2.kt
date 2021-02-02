package com.example.barchartexample.barchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.barchartexample.databinding.ActivityBarChart2Binding
import com.example.barchartexample.multiple.MultiChartActivity
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class BarChart2 : AppCompatActivity() {

    private lateinit var binding: ActivityBarChart2Binding
    val dataValues: ArrayList<BarEntry> = arrayListOf()
    val dataValues2: ArrayList<BarEntry> = arrayListOf()
    val days =
        listOf("Pzts", "Salı", "Carş", "Perş", "Cuma", "Cmrt", "Pazar", "Pzts", "Salı", "Çarş")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarChart2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setChart()
    }

    private fun dataValue(): ArrayList<BarEntry> {
        dataValues.add(BarEntry(0f, 4000f))
        dataValues.add(BarEntry(1f, 5000f))
        dataValues.add(BarEntry(2f, 1000f))
        dataValues.add(BarEntry(3f, 2000f))
        dataValues.add(BarEntry(4f, 3000f))
        dataValues.add(BarEntry(5f, 6000f))
        dataValues.add(BarEntry(6f, 7000f))
        dataValues.add(BarEntry(7f, 2000f))
        dataValues.add(BarEntry(8f, 6000f))
        dataValues.add(BarEntry(9f, 4000f))
        return dataValues
    }

    private fun dataValue2(): ArrayList<BarEntry> {
        dataValues2.add(BarEntry(0f, 3000f))
        dataValues2.add(BarEntry(1f, 4000f))
        dataValues2.add(BarEntry(2f, 5000f))
        dataValues2.add(BarEntry(3f, 6000f))
        dataValues2.add(BarEntry(4f, 2000f))
        dataValues2.add(BarEntry(5f, 1000f))
        dataValues2.add(BarEntry(6f, 5000f))
        dataValues2.add(BarEntry(7f, 4000f))
        dataValues2.add(BarEntry(8f, 7000f))
        dataValues2.add(BarEntry(9f, 1000f))
        return dataValues2
    }

    private fun setChart() {
        val barDataSet1 = BarDataSet(dataValue(), "Tablet Satışı")
        barDataSet1.color = Color.RED
        val barDataSet2 = BarDataSet(dataValue2(), "Telefon Satışı")
        barDataSet2.color = Color.GREEN

        val data = BarData(barDataSet1, barDataSet2)
        binding.barChart.data = data

        val xAxis = binding.barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(days)
        xAxis.setCenterAxisLabels(true)
        xAxis.labelCount = 5
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true

        binding.barChart.isDragEnabled = true
        binding.barChart.setVisibleXRangeMaximum(6f)

        val barSpace = 0.08f
        val groupSpace = 0.25f
        data.barWidth = 0.3f

        binding.barChart.xAxis.axisMaximum = 0f
        binding.barChart.xAxis.mAxisMaximum =
            0 + binding.barChart.barData.getGroupWidth(groupSpace, barSpace) * 10 // Todo * dan sonrasi tabloda kaç gün göstermek istediğin.. Dolayısıyla barwidthleri de ayarlamak zorundasın.

        binding.barChart.groupBars(0f, groupSpace, barSpace)

        val description = Description()
        description.text = ""
        binding.barChart.description = description
        binding.barChart.animateXY(2000, 2000)
        binding.barChart.invalidate()
    }
}