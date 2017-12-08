package com.example.davegilbier.recipelistfinal

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView


class RecipeAct : AppCompatActivity() {

    companion object {
        val KEY = "811"
    }

    private var recPhoto: ImageView? = null
    private var recName: TextView? = null
    private var recMethod: TextView? = null
    private var recIngredients: TextView? = null

    //find the views
    private fun findViews() {
        recPhoto = findViewById(R.id.recipePhoto)
        recName = findViewById(R.id.recipeName)
        recIngredients = findViewById(R.id.recipeIngredients)
        recMethod = findViewById(R.id.recipeProcedure)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)



        findViews()
        if(intent != null){
            val recipe = intent.getParcelableExtra<RecipeList>(KEY)
            val drawable : Drawable? = resources.getDrawable(recipe.recipePhoto)
            recPhoto!!.setImageDrawable(drawable)
            recName!!.text = recipe.recipeName
            recIngredients!!.text = recipe.ingredients
            recMethod!!.text = recipe.method
        }
        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }








        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

}
