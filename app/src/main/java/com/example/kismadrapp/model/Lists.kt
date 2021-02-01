package com.example.kismadrapp.model

import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R
import com.example.kismadrapp.database.Category
import com.example.kismadrapp.database.Town

class Lists {
    fun generateCategoryList(res: Resources):List<Category>{
        val catFoodDrink = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_restaurant,null),res.getString(R.string.category_food_drink))
        val catServices = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_gear,null),res.getString(R.string.category_services))
        val catShop = Category( ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_shop,null),res.getString(R.string.category_shops))
        val catSight = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_building,null),res.getString(R.string.category_sights))
        val catNature = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_tree,null),res.getString(R.string.category_nature))
        val catSurroundings = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_map,null),res.getString(R.string.category_surroundings))
        return  mutableListOf(catFoodDrink,catServices,catShop,catSight,catNature,catSurroundings)
    }
    fun generateTownList(res: Resources): List<Town>{
        val townBogacs = Town(res.getString(R.string.town_bogacs), ResourcesCompat.getDrawable(res, R.mipmap.noszvaj_panorama_cut,null))
        val townSzomolya = Town(res.getString(R.string.town_szomolya), ResourcesCompat.getDrawable(res, R.mipmap.noszvaj_panorama_cut,null))
        val townEger = Town(res.getString(R.string.town_eger), ResourcesCompat.getDrawable(res, R.mipmap.noszvaj_panorama_cut,null))
        val townMezokovesd = Town(res.getString(R.string.town_mezokovesd), ResourcesCompat.getDrawable(res, R.mipmap.noszvaj_panorama_cut,null))
        val townFelsotarkany = Town(res.getString(R.string.town_felsotarkany), ResourcesCompat.getDrawable(res, R.mipmap.noszvaj_panorama_cut,null))
        val townBukkszerc = Town(res.getString(R.string.town_bukkzserc), ResourcesCompat.getDrawable(res, R.mipmap.noszvaj_panorama_cut,null))
        val townCserepfalu = Town(res.getString(R.string.town_cserepfalu), ResourcesCompat.getDrawable(res, R.mipmap.noszvaj_panorama_cut,null))
        return mutableListOf(townBogacs,townBukkszerc,townCserepfalu,townEger,townFelsotarkany,townMezokovesd,townSzomolya)
    }
}