package com.example.barchartexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barchartexample.databinding.ActivityMainBinding
import com.example.barchartexample.barchart.BarChart1
import com.example.barchartexample.barchart.BarChart2
import com.example.barchartexample.multiple.MultiChartActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.multiChart.setOnClickListener {
            startActivity(Intent(this,MultiChartActivity::class.java))
        }
        binding.barChart1.setOnClickListener {
            startActivity(Intent(this,
                BarChart1::class.java))
        }
        binding.barChart2.setOnClickListener {
            startActivity(Intent(this, BarChart2::class.java))
        }
    }




}
/**   private fun loadBarChartData(response: GetDuelDetailResponse) {

val entriesLoginUserStepValue = ArrayList<BarEntry>()
val entriesOtherUserStepValue = ArrayList<BarEntry>()
val xAxisValues = arrayListOf<String>()  //Günler

for (i in response.loginUserData.indices) {
entriesLoginUserStepValue.add(
BarEntry(
i.toFloat(),
response.loginUserData[i].stepValue.toFloat()
)
)
xAxisValues.add(ConvertDateTime().convertDateMonthlyDotDay(response.loginUserData[i].dateTime))
}
for (i in response.otherUserData.indices) {
entriesOtherUserStepValue.add(
BarEntry(
i.toFloat(),
response.otherUserData[i].stepValue.toFloat()
)
)
}

val barDataSetLogin = BarDataSet(entriesLoginUserStepValue, "")
barDataSetLogin.color = ContextCompat.getColor(
requireContext(),
R.color.colorOrangeImageBackground
)
val barDataSetOther = BarDataSet(entriesOtherUserStepValue, "")
barDataSetOther.color = ContextCompat.getColor(
requireContext(),
R.color.colorBlueImageBackground
)

val data = BarData(barDataSetLogin, barDataSetOther)
barChart.data = data
barChart.data.setValueTextSize(0f)


//Gelen Adım dataları boş mu?
for (i in response.loginUserData.indices) {
if (response.loginUserData[i].stepValue > 0 || response.otherUserData[i].stepValue > 0) {
isEmpty = false
}
}

//Eğer boş ise default değerleri ata
if (isEmpty) {
barChart.axisLeft.axisMaximum = 5f
barChart.axisLeft.labelCount = 5
} else {
barChart.axisLeft.setLabelCount(6, true)
}


if (xAxisValues.count() == 6) {
barChart.barData.barWidth = 0.11f
barChart.xAxis.axisMaximum = 0f + barChart.barData.getGroupWidth(0.6f, 0.1f) * 6
barChart.xAxis.axisMinimum = 0f
barChart.xAxis.axisMaximum = 6f
barChart.groupBars(0f, 0.6f, 0.1f)
barChart.data.isHighlightEnabled = false
barChart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)
} else {
barChart.barData.barWidth = 0.11f
barChart.xAxis.axisMaximum = 0f + barChart.barData.getGroupWidth(0.65f, 0.07f) * 7
barChart.xAxis.axisMinimum = 0f
barChart.xAxis.axisMaximum = 7f
barChart.groupBars(0f, 0.65f, 0.07f)
barChart.data.isHighlightEnabled = false
barChart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)
}


barChart.invalidate()

private fun loadBarChart() {
barChart.description.isEnabled = false
barChart.setDrawGridBackground(false)
barChart.setPinchZoom(false)
barChart.setScaleEnabled(false)
barChart.setDrawBarShadow(false)
barChart.setExtraOffsets(34f, 0f, 34f, 13f)
barChart.legend.isEnabled = false
barChart.axisRight.isEnabled = false
barChart.axisRight.setDrawAxisLine(false)
barChart.axisRight.setDrawGridLines(false)
barChart.axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
barChart.axisLeft.axisMinimum = 0f
barChart.axisLeft.setDrawAxisLine(false)

barChart.axisLeft.textColor =
ContextCompat.getColor(requireContext(), R.color.profileInactiveColor)
barChart.axisLeft.textSize = 12f
barChart.axisLeft.typeface = Typeface.DEFAULT_BOLD
barChart.axisLeft.enableGridDashedLine(20f, 20f, 0f)
barChart.xAxis.textColor =
ContextCompat.getColor(requireContext(), R.color.profileInactiveColor)
barChart.xAxis.textSize = 12f
barChart.xAxis.typeface = Typeface.DEFAULT_BOLD
barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
barChart.xAxis.setCenterAxisLabels(true)
barChart.xAxis.setDrawAxisLine(true)
barChart.xAxis.granularity = 1f
barChart.xAxis.setDrawGridLines(false)
barChart.animateXY(1400, 1400)
barChart.invalidate()
} **/