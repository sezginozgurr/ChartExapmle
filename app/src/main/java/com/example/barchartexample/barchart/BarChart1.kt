package com.example.barchartexample.barchart

import android.R
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.barchartexample.databinding.ActivityBarChart1Binding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.LargeValueFormatter

class BarChart1 : AppCompatActivity() {

    private lateinit var binding: ActivityBarChart1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarChart1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        populateGraphData()
    }

    private fun loadBarChart() {
        binding.barChartView.description.isEnabled = false
        binding.barChartView.setDrawGridBackground(false)
        binding.barChartView.setPinchZoom(false)
        binding.barChartView.setScaleEnabled(false)
        binding.barChartView.setDrawBarShadow(false)
        binding.barChartView.setExtraOffsets(34f, 0f, 34f, 13f)
        binding.barChartView.legend.isEnabled = false
        binding.barChartView.axisRight.isEnabled = false
        binding.barChartView.axisRight.setDrawAxisLine(false)
        binding.barChartView.axisRight.setDrawGridLines(false)
        binding.barChartView.axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        binding.barChartView.axisLeft.axisMinimum = 10f
        binding.barChartView.axisLeft.minWidth = 15f
        binding.barChartView.axisLeft.setDrawAxisLine(false)

        binding.barChartView.axisLeft.textColor =
            ContextCompat.getColor(this, R.color.background_dark)
        binding.barChartView.axisLeft.textSize = 12f
        binding.barChartView.axisLeft.typeface = Typeface.DEFAULT_BOLD
        binding.barChartView.axisLeft.enableGridDashedLine(20f, 20f, 0f)
        binding.barChartView.xAxis.textColor =
            ContextCompat.getColor(this, R.color.background_dark)
        binding.barChartView.xAxis.textSize = 12f
        binding.barChartView.xAxis.typeface = Typeface.DEFAULT_BOLD
        binding.barChartView.xAxis.position = XAxis.XAxisPosition.BOTTOM
        binding.barChartView.xAxis.setCenterAxisLabels(true)
        binding.barChartView.xAxis.setDrawAxisLine(true)
        binding.barChartView.xAxis.granularity = 0f
        binding.barChartView.xAxis.setDrawGridLines(false)
        binding.barChartView.animateXY(1400, 1400)
        binding.barChartView.invalidate()
    }

    fun populateGraphData() {
        var barWidth = 2f
        val barSpace = 0.6f
        val groupSpace = 0.5f // her 2 item arasi uzaklik

        val xAxisValues = ArrayList<String>()
        xAxisValues.add("Şubat")
        xAxisValues.add("Mart")
        xAxisValues.add("Nisan")
        xAxisValues.add("Mayıs")
        xAxisValues.add("Haziran")
        xAxisValues.add("Temmuz")

        val yValueGroup1 = ArrayList<BarEntry>()
        val yValueGroup2 = ArrayList<BarEntry>()

        // draw the graph
        val barDataSet1: BarDataSet
        val barDataSet2: BarDataSet


        yValueGroup1.add(BarEntry(1f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(1f, floatArrayOf(2.toFloat(), 7.toFloat())))

        yValueGroup1.add(BarEntry(2f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(2f, floatArrayOf(4.toFloat(), 15.toFloat())))

        yValueGroup1.add(BarEntry(3f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(3f, floatArrayOf(4.toFloat(), 15.toFloat())))

        yValueGroup1.add(BarEntry(4f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(4f, floatArrayOf(4.toFloat(), 15.toFloat())))

        yValueGroup1.add(BarEntry(5f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(5f, floatArrayOf(10.toFloat(), 6.toFloat())))

        yValueGroup1.add(BarEntry(6f, floatArrayOf(11.toFloat(), 1.toFloat())))
        yValueGroup2.add(BarEntry(6f, floatArrayOf(12.toFloat(), 2.toFloat())))


        barDataSet1 = BarDataSet(yValueGroup1, "")
        barDataSet1.color = Color.BLUE
        barDataSet1.label = "2016"
        barDataSet1.setDrawIcons(false)
        barDataSet1.setDrawValues(false)


        barDataSet2 = BarDataSet(yValueGroup2, "")
        barDataSet2.label = "2017"
        barDataSet2.color = Color.GREEN
        barDataSet2.setDrawIcons(false)
        barDataSet2.setDrawValues(false)

        val barData = BarData(barDataSet1, barDataSet2)

        binding.barChartView.description.isEnabled = false
        binding.barChartView.description.textSize = 0f
        barData.setValueFormatter(LargeValueFormatter())
        binding.barChartView.data = barData
        binding.barChartView.barData.barWidth = barWidth
        binding.barChartView.xAxis.axisMinimum = 0f
        binding.barChartView.xAxis.axisMaximum = 12f
        binding.barChartView.groupBars(0f, groupSpace, barSpace)
        binding.barChartView.setFitBars(true)
        binding.barChartView.data.isHighlightEnabled = false
        binding.barChartView.invalidate()

        // set bar label
        val legend = binding.barChartView.legend
        legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.setDrawInside(false)

        val legenedEntries = arrayListOf<LegendEntry>()

        legenedEntries.add(LegendEntry("Hedeflenen", Legend.LegendForm.SQUARE, 8f, 8f, null, Color.BLUE))
        legenedEntries.add(
            LegendEntry("Gerçekleşen", Legend.LegendForm.SQUARE, 8f, 8f, null, Color.GREEN)
        )

        legend.setCustom(legenedEntries)

        legend.yOffset = 2f
        legend.xOffset = 2f
        legend.yEntrySpace = 0f
        legend.textSize = 10f

        val xAxis = binding.barChartView.xAxis
        xAxis.setLabelCount(6, true)
        xAxis.isGranularityEnabled = true
        xAxis.setCenterAxisLabels(true)
        xAxis.yOffset = 2f
        xAxis.xOffset = 2f
        xAxis.textSize = 5f
        xAxis.setDrawGridLines(false)
        xAxis.textSize = 12f

        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)

        xAxis.labelCount = 12
        xAxis.xOffset = 1f
        xAxis.yOffset = 10f
        xAxis.mAxisMaximum = 12f
        xAxis.mLabelWidth = 15
        xAxis.setCenterAxisLabels(true)
        xAxis.setAvoidFirstLastClipping(true)
        xAxis.spaceMin = 4f
        xAxis.spaceMax = 4f

        binding.barChartView.setVisibleXRangeMaximum(12f)
        binding.barChartView.setVisibleXRangeMinimum(12f)
        binding.barChartView.isDragEnabled = true

        //Y-axis
        binding.barChartView.axisRight.isEnabled = false
        binding.barChartView.setScaleEnabled(true)

        val leftAxis = binding.barChartView.axisLeft
        leftAxis.valueFormatter = LargeValueFormatter()
        leftAxis.setDrawGridLines(false) // ekrani kare / dikdortgen seklinde ayirior grid olarak hersey daha net
        leftAxis.spaceTop = 1f
        leftAxis.axisMinimum = 0f


        binding.barChartView.data = barData
        binding.barChartView.setVisibleXRange(1f, 12f)

        if (xAxisValues.count() == 6) {
            binding.barChartView.barData.barWidth = 0.2f
            binding.barChartView.xAxis.axisMaximum = 0f + binding.barChartView.barData.getGroupWidth(0.1f, 0.1f) * 6
            binding.barChartView.xAxis.axisMinimum = 0f
            binding.barChartView.xAxis.axisMaximum = 6f
            binding.barChartView.groupBars(0f, 0.4f, 0.1f) // 2'li barlar arasindaki uzaklik
            binding.barChartView.data.isHighlightEnabled = false
            binding.barChartView.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)
        } else {
            binding.barChartView.barData.barWidth = 0.11f
            binding.barChartView.xAxis.axisMaximum = 0f + binding.barChartView.barData.getGroupWidth(0.3f, 0.03f) * 7
            binding.barChartView.xAxis.axisMinimum = 0f
            binding.barChartView.xAxis.axisMaximum = 7f
            binding.barChartView.groupBars(0f, 0.65f, 0.07f)
            binding.barChartView.data.isHighlightEnabled = false
            binding.barChartView.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)
        }
        binding.barChartView.invalidate()
    }
}