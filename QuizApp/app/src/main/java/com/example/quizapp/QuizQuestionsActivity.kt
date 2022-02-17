package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() ,View.OnClickListener{
    private var mCurrentPosition=1
    private var mQuestionsList:ArrayList<Questions>?=null
    private var mSelectedOption=0
    private var mCorrectAnswer:Int=0
    private var mUserName:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        mUserName=intent.getStringExtra(Constants.User_Name)
         mQuestionsList=Constants.getconstans()
        setQuestion()
        var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        var btn_submit=findViewById<Button>(R.id.btn_submit)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        val question=mQuestionsList!![mCurrentPosition-1]
        defaultOptionView()
        var btn_submit=findViewById<Button>(R.id.btn_submit)
        if(mCurrentPosition==mQuestionsList!!.size)
        {
            btn_submit.text="FINISH"
        }else
        {
            btn_submit.text="SUBMIT"
        }
        var progressbar=findViewById<ProgressBar>(R.id.progressbar)
        progressbar.progress=mCurrentPosition
        var tv_progress=findViewById<TextView>(R.id.tv_progress)
        tv_progress.text="$mCurrentPosition"+"/"+ progressbar.max
        var tv_question=findViewById<TextView>(R.id.scrollbar)
        tv_question.text=question!!.question
        var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        tv_option_one.text=question!!.optionone
        tv_option_two.text=question!!.optiontwo
        tv_option_three.text=question!!.optionthree
        tv_option_four.text=question!!.optionfour

    }
     private fun defaultOptionView(){
        var options=ArrayList<TextView>()
         var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
         var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
         var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
         var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        options.add(0,tv_option_one)
         options.add(1,tv_option_two)
         options.add(2,tv_option_three)
         options.add(3,tv_option_four)
         for(option in options){
             option.setTextColor(Color.parseColor("#7A8089"))
             option.typeface= Typeface.DEFAULT
             option.background =ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
         }

    }

    override fun onClick(v: View?) {
        var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
       when(v?.id){
           R.id.tv_option_one->{
               selectedOptionView(tv_option_one,1)
           }
           R.id.tv_option_two->{
               selectedOptionView(tv_option_two,2)
           }
           R.id.tv_option_three->{
               selectedOptionView(tv_option_three,3)
           }
           R.id.tv_option_four->{
               selectedOptionView(tv_option_four,4)
           }
           R.id.btn_submit->{
               if(mSelectedOption==0){
                   mSelectedOption++
                   when {
                       mCurrentPosition+1 <= mQuestionsList!!.size -> {
                           mCurrentPosition=mCurrentPosition+1
                           setQuestion()

                       }

                       else -> {
                          val intent=Intent(this,ResultActivity::class.java)
                           intent.putExtra(Constants.User_Name,mUserName)
                           intent.putExtra(Constants.Correct_Answer,mCorrectAnswer)
                           intent.putExtra(Constants.Total_Question,mQuestionsList!!.size)
                           startActivity(intent)
                           finish()
                       }
                   }
               }
               else{
                   //val question=mQuestionsList?.get(mCurrentPosition-1)
                   if(mQuestionsList!![mCurrentPosition-1].correctAnswer!=mSelectedOption){
                       Answerview(mSelectedOption,R.drawable.wrong_option_border_bg)
                   }
                   else{
                       mCorrectAnswer++
                   }
                   Answerview(mQuestionsList!![mCurrentPosition-1].correctAnswer,R.drawable.correct_option_border_bg)
                   if(mCurrentPosition==mQuestionsList!!.size){
                       var btn_submit=findViewById<Button>(R.id.btn_submit)
                       btn_submit.text="FINISH"
                   }
                   else
                   {
                       var btn_submit=findViewById<Button>(R.id.btn_submit)
                       btn_submit.text="Go To Next Question"
                   }
                   mSelectedOption=0
               }
           }
       }

    }
    private fun selectedOptionView(tv:TextView,seletedoptionnum:Int){
     defaultOptionView()
            val selectedoptionnum=seletedoptionnum
        mSelectedOption=selectedoptionnum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background =ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
    private fun Answerview(answer:Int,drawableview:Int)
    {
        var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        when(answer){
            1->{
                tv_option_one.background=ContextCompat.getDrawable(this,drawableview)
            }
            2->{
                tv_option_two.background=ContextCompat.getDrawable(this,drawableview)
            }
            3->{
                tv_option_three.background=ContextCompat.getDrawable(this,drawableview)
            }
            4->{
                tv_option_four.background=ContextCompat.getDrawable(this,drawableview)
            }
        }
    }
}