package com.example.barchartexample.multiple

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.barchartexample.R
import com.example.barchartexample.databinding.ActivityMultilineGraphBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ViewPortHandler

class MultiChartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultilineGraphBinding
    val dataValues: ArrayList<Entry> = arrayListOf()
    val dataValues2: ArrayList<Entry> = arrayListOf()
    val dataSets: ArrayList<ILineDataSet> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultilineGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)
        propertyChart()
        setChart()

    }

    private fun dataValue(): ArrayList<Entry> {
        dataValues.add(Entry(0f, 10f))
        dataValues.add(Entry(1f, 25f))
        dataValues.add(Entry(2f, 30f))
        dataValues.add(Entry(3f, 60f))
        dataValues.add(Entry(4f, 50f))
        dataValues.add(Entry(5f, 20f))
        dataValues.add(Entry(6f, 70f))
        return dataValues
    }

    private fun dataValue2(): ArrayList<Entry> {
        dataValues2.add(Entry(0f, 30f))
        dataValues2.add(Entry(1f, 40f))
        dataValues2.add(Entry(2f, 50f))
        dataValues2.add(Entry(3f, 10f))
        dataValues2.add(Entry(4f, 60f))
        dataValues2.add(Entry(5f, 40f))
        dataValues2.add(Entry(6f, 10f))
        return dataValues2
    }

    private fun setChart() {
        val lineDataset1 = LineDataSet(dataValue(), "Tablet Satışı")
        val lineDataset2 = LineDataSet(dataValue2(), "Telefon Satışı")
        dataSets.add(lineDataset1)
        dataSets.add(lineDataset2)

        lineDataset1.lineWidth = 3f
        lineDataset1.color = Color.RED //Todo rota rengini degistirir
        lineDataset1.setCircleColors(R.color.colorFarenheit) //Todo rota circle rengini degistirir'
        lineDataset1.circleRadius = 5f //Todo yuvarlagin boyu
        lineDataset1.circleHoleRadius = 5f //Todo yuvarlagin icini boyarr
        lineDataset1.lineWidth = 3f
        lineDataset1.valueTextSize = 14f
        //lineDataset1.enableDashedLine(5f,5f,10f) //Todo nokta nokta hale getirir cizgileri
        //lineDataset1.setColor(colorArray,MultiChartActivity.this) //Todo verdigin color degerlerini her bir kesite sigdirir

        lineDataset1.valueFormatter =
            myValueFormatter() //Todo fonksiyon yardimi ile dolar eklendi basina

        val xAxis = binding.lineChart.xAxis
        val xAxisLeft = binding.lineChart.axisLeft
        val yAxisRight = binding.lineChart.axisRight

        xAxis.valueFormatter = myAxisValueFormat()


        val data = LineData(dataSets)
        binding.lineChart.data = data
        binding.lineChart.animateXY(2000,2000)
        binding.lineChart.invalidate()
    }

    private fun propertyChart() {
        //binding.lineChart.setBackgroundResource(R.color.color1) //Todo komple backgroundu
        //binding.lineChart.setNoDataText("Şuan data bulunmuyor") //Todo Chart gizlenir ve bu mesaj verilir
        //binding.lineChart.setDrawBorders(true) //Todo chart etrafını borderlar
        //binding.lineChart.setDrawBorderColor(Color.RED) //Todo Border rengini belirler
        //binding.lineChart.setDrawBorderWidth(Color.RED) //Todo Border width belirler

        /*val description = Description() //Todo sol alta tablo ismi gibi yazi koymani saglar
        description.text = "Description"
        description.textColor = Color.BLUE
        description.textSize = 20f
        binding.lineChart.description = description*/

/*        val legend = binding.lineChart.legend //Todo datasetteki textin rengini degistirir
        legend.isEnabled = true
        legend.textColor = Color.RED
        legend.form = Legend.LegendForm.CIRCLE //Todo iconu degistirmeni saglar
        legend.formSize = 10f*/

    }

    private class myValueFormatter() : IValueFormatter {
        override fun getFormattedValue(
            value: Float,
            entry: Entry?,
            dataSetIndex: Int,
            viewPortHandler: ViewPortHandler?
        ): String {
            return "$value$"
        }

    }

    private class myAxisValueFormat() : IAxisValueFormatter {
        override fun getFormattedValue(value: Float, axis: AxisBase?): String {
            //axis?.labelCount = 3 //Todo kac satir gorunsun
            return "${value.toInt()}.Hafta"
        }

    }


}

/**
 * val firstChartEntity = ChartEntity(Color.WHITE, graph1)
val secondChartEntity = ChartEntity(Color.YELLOW, graph2)

val list = ArrayList<ChartEntity>().apply {
add(firstChartEntity)
add(secondChartEntity)
}
binding.lineChart.setLegend(legendArr)
binding.lineChart.setList(list)
}

private val graph1 = floatArrayOf(
113000f,
183000f,
188000f,
695000f,
324000f,
230000f,
188000f,
15000f,
126000f,
5000f,
33000f
)
private val graph2 =
floatArrayOf(0f, 245000f, 1011000f, 1000f, 0f, 0f, 47000f, 20000f, 12000f, 124400f, 160000f)
private val legendArr = arrayListOf(
"05/21",
"05/22",
"05/23",
"05/24",
"05/25",
"05/26",
"05/27",
"05/28",
"05/29",
"05/30",
"05/31"
)
 *
 * **/
