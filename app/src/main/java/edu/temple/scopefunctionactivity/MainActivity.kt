package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.math.log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
        // eg. private fun getTestDataArray() = ...

        // HINT when constructing elaborate scope functions:
        // Look at the final/return value and build the function "working backwards"

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        // eg. Log.d("function output", getTestDataArray().toString())

        /* 1. Random array of sorted Int */
        val listOfInt = getTestDataArray()
        Log.d("getTestDataArray: ", "$listOfInt")

        /* 2. List of Double: average < median */
        val listOfDoubles: List<Double> = listOf(6.5, 5.4, 4.3, 3.2, 2.1, 1.0)
        Log.d("avgLessThanMedian: ", "Original List = $listOfDoubles")
        Log.d("avgLessThanMedian: ", "${averageLessThanMedian(listOfDoubles)}")

        /* 3. Create a TextView, or recycle an existing one  */
        getView(2, null, listOfInt, this)
        Log.d("getView: ", "${getView(2, null, listOfInt, this)}")
    }


    // Return a list of random, sorted integers
    private fun getTestDataArray() = MutableList(10) { Random.nextInt() }
        .apply { sort() }

    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>) =
        with(listOfNumbers.sorted()) {
            if (size % 2 == 0)
                average() < (this[size/2] + this[(size - 1)/2]) / 2
            else average() < this[size/2]
        }

    // The same exact function with log statements
    private fun averageLessThanMedianLog(listOfNumbers: List<Double>) =
        with(listOfNumbers.sorted()) {
            Log.d("avgLessThanMedian: ", "Sorted List = $this")
            if (size % 2 == 0) {
                Log.d("avgLessThanMedian: ", "Median: ${this[size / 2]}")
                Log.d("avgLessThanMedian: ", "Average = ${average()}")
                average() < (this[size / 2] + this[(size - 1) / 2]) / 2
            }
            else {
                Log.d("avgLessThanMedian: ", "Median = ${this[size / 2]}")
                Log.d("avgLessThanMedian: ", "Average = ${average()}")
                average() < this[size / 2]
            }
        }

    private fun getView(position: Int,
                        recycledView: View?,
                        collection: List<Int>,
                        context: Context) =
        recycledView ?: TextView(context).apply {
                setPadding(5, 10, 10, 0)
                textSize = 22f
                text = collection[position].toString()
            }

    /* Original functions */

    // Return a list of random, sorted integers
//    private fun getTestDataArray() : List<Int> {
//        val testArray = MutableList(10){ Random.nextInt()}
//        testArray.sort()
//        return testArray
//    }

    // Return true if average value in list is greater than median value, false otherwise
//    private fun averageLessThanMedian1(listOfNumbers: List<Double>): Boolean {
//        val avg = listOfNumbers.average()
//        val sortedList = listOfNumbers.sorted()
//        val median = if (sortedList.size % 2 == 0)
//            (sortedList[sortedList.size / 2] + sortedList[(sortedList.size - 1) / 2]) / 2
//        else
//            sortedList[sortedList.size / 2]
//
//        return avg < median
//    }

//    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
//    private fun getView(
//        position: Int,
//        recycledView: View?,
//        collection: List<Int>,
//        context: Context
//    ): View {
//        val textView: TextView
//
//        if (recycledView != null) {
//            textView = recycledView as TextView
//        } else {
//            textView = TextView(context)
//            textView.setPadding(5, 10, 10, 0)
//            textView.textSize = 22f
//        }
//
//        textView.text = collection[position].toString()
//
//        return textView
//    }

}

//// The same exact function with log statements
//private fun averageLessThanMedianLog(listOfNumbers: List<Double>) =
//    with(listOfNumbers) {
//        Log.d("avgLessThanMedian: ", "Sorted List = ${sorted()}")
//        if (size % 2 == 0)
//            Log.d("avgLessThanMedian: ", "Median: ${sorted()[size/2]}")
//                .also { Log.d("avgLessThanMedian: ", "Average = ${average()}") }
//                .also { average() < (sorted()[size/2] + sorted()[(size - 1)/2] / 2) }
//        else Log.d("avgLessThanMedian: ", "Median = ${sorted()[size/2]}")
//            .also { Log.d("avgLessThanMedian: ", "Average = ${average()}") }
//        average() < sorted()[size/2]
//    }
