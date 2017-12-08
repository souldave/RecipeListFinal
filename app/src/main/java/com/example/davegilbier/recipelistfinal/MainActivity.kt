package com.example.davegilbier.recipelistfinal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout


import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mRecView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findView()
        mRecView!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)




        val food = ArrayList<RecipeList>()
        food.add(RecipeList(
                R.drawable.mangofloat,
                "Mango Float",
                "A dessert that will let you float in Cloud 9 ",
                "1 (10 1/2 ounce) can Nestle cream\n" +
                        "3 large mangoes\n" +
                        "1 (10 ounce) can sweetened condensed milk\n",
                "1. Slice mangoes into thin wedges.\n" +
                        "2. Combine sweetened condensed milk, nestle cream, and mango.\n" +
                        "3. Layer the graham crackers in a square glass pan or other container.\n" +
                        "4. Put on the crackers a layer of the filling of mangoes, cream, and condensed milk.\n" +
                        "5. Repeat by putting layers of graham crackers, and filling until you've used it all. It should be topped with graham crackers after the final layer. \n"+
                        "6. Put it in the refrigerator to thicken and chill overnight. You can also put this desert in the freezer and it tastes great as a frozen treat."
        ))
        food.add(RecipeList(
                R.drawable.strawberryshake,
                "Fresh Strawberry Milkshakes",
                "Health shake and easy to do!",
                "1/2 pound fresh strawberries, hulled and sliced, plus whole strawberries, for garnish\n" +
                        "2 heaping tablespoons sugar\n" +
                        "1 teaspoon vanilla extract\n" +
                        "1/2 cup milk\n" +
                        "1 pint vanilla ice cream",
                "1. In a mixing bowl combine the sliced strawberries, sugar and vanilla extract and stir to combine well. Set aside and allow to macerate for at least 20 minutes and up to 1 hour.\n" +
                        "2. In a large mixer, place the strawberries, ice cream, and milk. Blend until smooth. Pour into ice cream parlor glasses and garnish the rim of each glass with whole strawberries. Serve immediately."))
        food.add(RecipeList(
                R.drawable.mkins,
                "Chocolate Munchkins",
                "An easy to make dessert that you'll surely love.",
                "2 x 200 g chocolate biscuits\n" +
                        "1/2 cup condensed milk\n" +
                        "1/4 cup milk fresh\n" +
                        "1 cup desiccated coconut",
                "1. Process the biscuits in a food processor or crush until crumbly.\n" +
                        "2. Add condensed milk and fresh milk and mix.\n" +
                        "3. Roll mixture into balls and dip in dessicated coconut."))

        val adapter = CustomAdapter(food)

        mRecView!!.adapter = adapter
        mRecView!!.addItemDecoration(DividerItemDecoration(recipeRecycler.context, LinearLayoutManager.VERTICAL))
    }
    private fun findView() {
        mRecView = findViewById<RecyclerView>(R.id.recipeRecycler) as RecyclerView
    }

}

