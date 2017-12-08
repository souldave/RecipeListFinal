package com.example.davegilbier.recipelistfinal

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.davegilbier.recipelistfinal.RecipeAct.Companion.KEY

/**
 * Created by Dave Gilbier on 6/12/17.
 */
class CustomAdapter(private val recipeList: ArrayList<RecipeList>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val rec: RecipeList = recipeList[position]
        holder?.recipeName?.text = rec.recipeName
        holder?.recipeDesc?.text = rec.recipeDesc
        holder?.linearLayout?.setOnClickListener { v ->
            val intent = Intent(v.context, RecipeAct::class.java)
            intent.putExtra(KEY, rec)
            v.context.startActivity(intent)
        }}
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val vHold = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(vHold)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName = itemView.findViewById<TextView>(R.id.recipeName) as TextView
        val recipeDesc = itemView.findViewById<TextView>(R.id.recipeDescription) as TextView
        val linearLayout = itemView.findViewById<LinearLayout>(R.id.item) as LinearLayout
    }
    override fun getItemCount(): Int {
        return recipeList.size
    }
}
