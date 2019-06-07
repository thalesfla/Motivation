package com.example.motivation.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.util.MotivationConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var mFilter: Int = MotivationConstants.PHRASE_FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Eventos
        setListeners()

        //Inicializa
        handleFilter(R.id.imageAll)

    }

    override fun onClick(view: View) {

        val id = view.id
        val listId = listOf(R.id.imageAll, R.id.imageSun, R.id.imageHappy)
        if (id in listId) {
            handleFilter(id)
        } else {
            refreshPhrase()
        }
    }

    //metodo
    private fun setListeners() {
        imageAll.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        buttonNewPhrase.setOnClickListener(this)
    }

    private fun handleFilter(id: Int) {

        imageAll.setImageResource(R.drawable.ic_all_unselected)
        imageSun.setImageResource(R.drawable.ic_sun_unselected)
        imageHappy.setImageResource(R.drawable.ic_happy_unselected)

        if (id == R.id.imageAll) {
            mFilter = MotivationConstants.PHRASE_FILTER.ALL
            imageAll.setImageResource(R.drawable.ic_all_selected)
        } else if (id == R.id.imageSun) {
            mFilter = MotivationConstants.PHRASE_FILTER.SUN
            imageSun.setImageResource(R.drawable.ic_sun_selected)

        } else {
            mFilter = MotivationConstants.PHRASE_FILTER.HAPPY
            imageHappy.setImageResource(R.drawable.ic_happy_selected)
        }
    }

    private fun refreshPhrase() {

    }
}

