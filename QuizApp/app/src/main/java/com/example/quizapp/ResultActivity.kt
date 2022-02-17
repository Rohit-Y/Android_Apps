package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username=intent.getStringExtra(Constants.User_Name)
        val correctanswer=intent.getIntExtra(Constants.Correct_Answer,0)
        val totalquestion=intent.getIntExtra(Constants.Total_Question,0)
        val tv_username=findViewById<TextView>(R.id.tv_username)
        val tv_score=findViewById<TextView>(R.id.tv_score)
        val tv_submit=findViewById<TextView>(R.id.btn_finsih)
        tv_username.text=username
        tv_score.text="Your Score is $correctanswer out of $totalquestion"
        tv_submit.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}