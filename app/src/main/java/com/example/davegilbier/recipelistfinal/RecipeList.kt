package com.example.davegilbier.recipelistfinal

import android.os.Parcel
import android.os.Parcelable




/**
 * Created by Dave Gilbier on 6/12/17.
 */
data class RecipeList(
        val recipePhoto: Int = 0, val recipeName: String = "", val recipeDesc: String = "", val ingredients: String = "", val method: String = "") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString())
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(recipePhoto)
        parcel.writeString(recipeName)
        parcel.writeString(recipeDesc)
        parcel.writeString(ingredients)
        parcel.writeString(method)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<RecipeList> {
        override fun createFromParcel(parcel: Parcel): RecipeList {
            return RecipeList(parcel)
        }
        override fun newArray(size: Int): Array<RecipeList?> {
            return arrayOfNulls(size)
        }
    }
}