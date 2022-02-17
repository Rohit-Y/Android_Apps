package com.example.mycalculator

import android.icu.util.Output
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var tv_Output:TextView?=null
    var lastNumeric:Boolean=false
    var lastDot:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      tv_Output =findViewById<TextView>(R.id.Output)
    }
    fun Click(view: View){
        tv_Output?.append((view as Button).text)
        lastNumeric=true
        lastDot=false
    }
    fun onClear(view: View)
    {
        tv_Output?.text = ""
    }
    fun lastdecimal(view: View)
    {
        if(lastNumeric && !lastDot)
        {
            tv_Output?.append(".")
            lastNumeric=false
            lastDot=true
        }
    }
    fun onOperator(view: View)
    {
        if(lastNumeric && !isOperatoradded(tv_Output?.text.toString()))
        {
            tv_Output?.append((view as Button).text)
            lastNumeric=false
            lastDot=false
        }
    }
    private fun isOperatoradded(value:String):Boolean{
        return if(value.startsWith("-"))
        {
            false
        }
        else{
            value.contains("/") || value.contains("*")
                    || value.contains("+")||value.contains("-")
        }
    }
    private fun removezeroafterdot(result:String):String{
        var value=result
        if(result[result.length-1]=='0' && result[result.length-2]=='.')
        {
            value=result.substring(0,result.length-2)
        }
        return value
    }
    fun onEqual(view: View)
    {
        if(lastNumeric)
        {
            var prefix=""
            var tvValue=tv_Output?.text.toString()
            try{
                if(tvValue.startsWith("-"))
                {
                    prefix="-"
                   tvValue= tvValue.substring(1)
                }
                if(tvValue.contains("-")){
                    var splitvalue = tvValue.split("-")
                    var one = splitvalue[0]
                    var two = splitvalue[1]
                    if(!prefix.isEmpty())
                    {
                        one=prefix+one
                    }
                    tv_Output?.text =removezeroafterdot((one.toDouble() - two.toDouble()).toString())
                }
                else if(tvValue.contains("+")){
                    var splitvalue = tvValue.split("+")
                    var one = splitvalue[0]
                    var two = splitvalue[1]
                    if(!prefix.isEmpty())
                    {
                        one=prefix+one
                    }
                    tv_Output?.text = removezeroafterdot((one.toDouble() + two.toDouble()).toString())
                }
                else if(tvValue.contains("/")){
                    var splitvalue = tvValue.split("/")
                    var one = splitvalue[0]
                    var two = splitvalue[1]
                    if(!prefix.isEmpty())
                    {
                        one=prefix+one
                    }
                    if(two.toInt()==0)
                    {  tv_Output?.text="DBZ"}
                    else
                        tv_Output?.text = removezeroafterdot((one.toDouble() / two.toDouble()).toString())

                }
                else if(tvValue.contains("*")){
                    var splitvalue = tvValue.split("*")
                    var one = splitvalue[0]
                    var two = splitvalue[1]
                    if(!prefix.isEmpty())
                    {
                        one=prefix+one
                    }
                    tv_Output?.text = removezeroafterdot((one.toDouble() * two.toDouble()).toString())
                }
            }catch (e:ArithmeticException)
            {
               e.printStackTrace()
            }
        }
    }
}