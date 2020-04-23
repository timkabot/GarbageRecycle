package com.app.studentsproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.studentsproject.R
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.android.synthetic.main.activity_question.*
import java.io.File
import java.io.InputStream

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        val pdfFile = File("res/raw/question.pdf")
        val ins: InputStream = resources.openRawResource(
            resources.getIdentifier(
                "question",
                "raw", packageName
            )
        )
        pdfView.fromStream(ins).scrollHandle(DefaultScrollHandle(this))
            .swipeHorizontal(false)
            .enableSwipe(true)
            .defaultPage(0)
            .load()
    }
}