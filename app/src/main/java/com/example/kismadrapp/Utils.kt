package com.example.kismadrapp

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.provider.Settings.Global.getString
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.list.Sight
import com.example.kismadrapp.model.Category
import com.example.kismadrapp.model.Town
import kotlin.random.Random


fun getListOfTowns(res: Resources): List<Town>{
    val bogacsName = res.getString(R.string.town_name_bogacs)
    val szomolyaName = res.getString(R.string.town_name_szomolya)
    val egerName = res.getString(R.string.town_name_eger)
    val mezokovesdName = res.getString(R.string.town_name_mezokovesd)
    val felsotarkanyName = res.getString(R.string.town_name_felsotarkany)
    val bukkzsercName = res.getString(R.string.town_name_bukkzserc)
     val cserepfaluName = res.getString(R.string.town_name_cserepfalu)

    val townBogacs = Town(bogacsName,res.getString(R.string.test_town_des),getDistance(), listOfSight(res), getTownDrawables(res,bogacsName))
    val townSzomolya = Town(szomolyaName,res.getString(R.string.test_town_des),getDistance(), listOfSight(res), getTownDrawables(res,szomolyaName))
    val townEger = Town(egerName,res.getString(R.string.test_town_des),getDistance(), listOfSight(res), getTownDrawables(res,egerName))
    val townMezokovesd = Town(mezokovesdName,res.getString(R.string.test_town_des),getDistance(), listOfSight(res), getTownDrawables(res,mezokovesdName))
    val townFelsotarkany = Town(felsotarkanyName,res.getString(R.string.test_town_des),getDistance(), listOfSight(res), getTownDrawables(res,felsotarkanyName))
    val townBukkszerc = Town(bukkzsercName,res.getString(R.string.test_town_des),getDistance(), listOfSight(res), getTownDrawables(res,bukkzsercName))
    val townCserepfalu = Town(cserepfaluName,res.getString(R.string.test_town_des),getDistance(), listOfSight(res), getTownDrawables(res,cserepfaluName))

    return listOf(townBogacs,townBukkszerc,townCserepfalu,townEger,townFelsotarkany,townMezokovesd,townSzomolya)
}
fun generateCategoryList(res: Resources):List<Category>{
    val catFoodDrink = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_restaurant,null),res.getString(R.string.category_food_drink))
    val catServices = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_gear,null),res.getString(R.string.category_services))
    val catShop = Category( ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_shop,null),res.getString(R.string.category_shops))
    val catSight = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_building,null),res.getString(R.string.category_sights))
    val catNature = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_tree,null),res.getString(R.string.category_nature))
    val catSurroundings = Category(ResourcesCompat.getDrawable(res, R.drawable.ic_iconmonstr_map,null),res.getString(R.string.category_surroundings))
    return  mutableListOf(catFoodDrink,catServices,catShop,catSight,catNature,catSurroundings)
}
private fun getDistance():Double
{
    return Random.nextDouble(1.0,100.0)
}
private fun listOfSight(res: Resources): List<Sight>
{// TODO: 2021. 02. 02. when elágazás
    val sight = Sight("Test Sight","test sight description", true,
        ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_tree,null)!!,null)
    return listOf(sight)
}
private fun getTownDrawables(res: Resources, townName: String): List<Drawable>
{
    return when(townName) {
        res.getString(R.string.town_name_bogacs) -> listOf(ResourcesCompat.getDrawable(res,R.drawable.bogacs, null)!!)
        res.getString(R.string.town_name_bukkzserc) -> listOf(ResourcesCompat.getDrawable(res,R.drawable.bukkzserc, null)!!)
        res.getString(R.string.town_name_cserepfalu) -> listOf(ResourcesCompat.getDrawable(res,R.drawable.cserepfalu, null)!!)
        res.getString(R.string.town_name_eger) -> listOf(ResourcesCompat.getDrawable(res,R.drawable.eger, null)!!)
        res.getString(R.string.town_name_felsotarkany) -> listOf(ResourcesCompat.getDrawable(res,R.drawable.felsotarkany, null)!!)
        res.getString(R.string.town_name_mezokovesd) -> listOf(ResourcesCompat.getDrawable(res,R.drawable.mezokovesd, null)!!)
        res.getString(R.string.town_name_szomolya) -> listOf(ResourcesCompat.getDrawable(res,R.drawable.szomolya, null)!!)
        else -> listOf(ResourcesCompat.getDrawable(res,R.drawable.noszvaj_panorama, null)!!)
    }
}
fun listOfEvents(res: Resources):List<Drawable>{
    val eventList: List<Drawable>
    val img = ResourcesCompat.getDrawable(res,R.drawable.art_vector_festivities,null)!!
    return listOf(img,img,img)
}