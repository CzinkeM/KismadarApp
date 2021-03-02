package com.example.kismadrapp.utils

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R
import com.example.kismadrapp.models.*

fun getTowns(res: Resources): List<Town> {
    val bogacsName = res.getString(R.string.town_name_bogacs)
    val szomolyaName = res.getString(R.string.town_name_szomolya)
    val egerName = res.getString(R.string.town_name_eger)
    val mezokovesdName = res.getString(R.string.town_name_mezokovesd)
    val felsotarkanyName = res.getString(R.string.town_name_felsotarkany)
    val bukkzsercName = res.getString(R.string.town_name_bukkzserc)
    val cserepfaluName = res.getString(R.string.town_name_cserepfalu)

    val townBogacs = Town(
        bogacsName,
        res.getString(R.string.test_town_des),
        listOfSight(res),
        getTownDrawables(res,bogacsName)
    )
    val townSzomolya = Town(
        szomolyaName,
        res.getString(R.string.test_town_des),
        listOfSight(res),
        getTownDrawables(res,szomolyaName)
    )
    val townEger = Town(
        egerName,
        res.getString(R.string.test_town_des),
        listOfSight(res),
        getTownDrawables(res,egerName)
    )
    val townMezokovesd = Town(
        mezokovesdName,
        res.getString(R.string.test_town_des),
        listOfSight(res),
        getTownDrawables(res,mezokovesdName)
    )
    val townFelsotarkany = Town(
        felsotarkanyName,
        res.getString(R.string.test_town_des),
        listOfSight(res),
        getTownDrawables(res,felsotarkanyName)
    )
    val townBukkszerc = Town(
        bukkzsercName,
        res.getString(R.string.test_town_des),
        listOfSight(res),
        getTownDrawables(res,bukkzsercName)
    )
    val townCserepfalu = Town(
        cserepfaluName,
        res.getString(R.string.test_town_des),
        listOfSight(res),
        getTownDrawables(res,cserepfaluName)
    )

    return listOf(
        townBogacs,
        townBukkszerc,
        townCserepfalu,
        townEger,
        townFelsotarkany,
        townMezokovesd,
        townSzomolya
    )
}

private fun listOfSight(res: Resources): List<Sight> {// TODO: 2021. 02. 02. when elágazás
    val sight = Sight(
        "Test Sight", "test sight description", true,
        ResourcesCompat.getDrawable(res, R.drawable.ic_tree, null)!!)
    return listOf(sight)
}

private fun getTownDrawables(res: Resources, townName: String): Drawable {
    return when (townName) {
        res.getString(R.string.town_name_bogacs) -> ResourcesCompat.getDrawable(res, R.drawable.img_bogacs, null)!!
        res.getString(R.string.town_name_bukkzserc) -> ResourcesCompat.getDrawable(res, R.drawable.img_bukkzserc, null)!!
        res.getString(R.string.town_name_cserepfalu) -> ResourcesCompat.getDrawable(res, R.drawable.img_cserepfalu, null)!!
        res.getString(R.string.town_name_eger) -> ResourcesCompat.getDrawable(res, R.drawable.img_eger, null)!!
        res.getString(R.string.town_name_felsotarkany) -> ResourcesCompat.getDrawable(res, R.drawable.img_felsotarkany, null)!!
        res.getString(R.string.town_name_mezokovesd) -> ResourcesCompat.getDrawable(res, R.drawable.img_mezokovesd,null)!!
        res.getString(R.string.town_name_szomolya) -> ResourcesCompat.getDrawable(res, R.drawable.img_szomolya, null)!!
        else -> ResourcesCompat.getDrawable(res, R.drawable.img_noszvaj_panorama, null)!!
    }
}

fun getNatureSights(res: Resources): ArrayList<NatureSight>{
    val testNatureSight = NatureSight("Példa Forrás",
        NatureSightType.SPRING,res.getString(R.string.loremipsum),ResourcesCompat.getDrawable(res,
            R.drawable.vector_hiking,null)!!)
    return arrayListOf(testNatureSight)
}

fun getRestaurants(res: Resources): ArrayList<FoodAndDrink>{
    val testRestaurant = FoodAndDrink("Példa Étterem",res.getString(R.string.loremipsum),
        Pricing.MODERATE,ResourcesCompat.getDrawable(res, R.drawable.vector_food,null)!!)
    return arrayListOf(testRestaurant)
}

fun getServices(res: Resources): ArrayList<Service>{
    val testService = Service("Példa Szolgáltatás",res.getString(R.string.loremipsum),ResourcesCompat.getDrawable(res,
        R.drawable.vector_road_sign,null)!!)
    return arrayListOf(testService)
}

fun getShops(res: Resources): ArrayList<Shop>{
    val testShop = Shop("Példa Test",ResourcesCompat.getDrawable(res, R.drawable.vector_shop,null)!!)
    return arrayListOf(testShop)
}

fun getSights(res: Resources): ArrayList<Sight>{
    val testSight = Sight("Példa Sight",res.getString(R.string.loremipsum),true,ResourcesCompat.getDrawable(res,
        R.drawable.vector_sight,null)!!)
    return arrayListOf(testSight)
}
