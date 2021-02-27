package com.example.kismadrapp.utils

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R
import com.example.kismadrapp.models.*
import kotlin.random.Random

enum class NatureType { LAKE, VIEWPOINT, SPRING, OTHER }
enum class Pricing { CHEAP, MODERATE, EXPENSIVE, VEXPENSIVE }

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
        getDistance(),
        listOfSight(res),
        getTownDrawables(res, bogacsName)
    )
    val townSzomolya = Town(
        szomolyaName,
        res.getString(R.string.test_town_des),
        getDistance(),
        listOfSight(res),
        getTownDrawables(res, szomolyaName)
    )
    val townEger = Town(
        egerName,
        res.getString(R.string.test_town_des),
        getDistance(),
        listOfSight(res),
        getTownDrawables(res, egerName)
    )
    val townMezokovesd = Town(
        mezokovesdName,
        res.getString(R.string.test_town_des),
        getDistance(),
        listOfSight(res),
        getTownDrawables(res, mezokovesdName)
    )
    val townFelsotarkany = Town(
        felsotarkanyName,
        res.getString(R.string.test_town_des),
        getDistance(),
        listOfSight(res),
        getTownDrawables(res, felsotarkanyName)
    )
    val townBukkszerc = Town(
        bukkzsercName,
        res.getString(R.string.test_town_des),
        getDistance(),
        listOfSight(res),
        getTownDrawables(res, bukkzsercName)
    )
    val townCserepfalu = Town(
        cserepfaluName,
        res.getString(R.string.test_town_des),
        getDistance(),
        listOfSight(res),
        getTownDrawables(res, cserepfaluName)
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
fun getCategoryFood(res: Resources):Category{
    return  Category(
        ResourcesCompat.getDrawable(res, R.drawable.ic_restaurant, null),
        res.getString(R.string.category_food_drink)
    )
}
fun getCategoryServices(res: Resources):Category{
    return Category(
        ResourcesCompat.getDrawable(res, R.drawable.ic_gear, null),
        res.getString(R.string.category_services)
    )
}
fun getCategoryShop(res: Resources):Category{
    return Category(
        ResourcesCompat.getDrawable(res, R.drawable.ic_shop, null),
        res.getString(R.string.category_shops)
    )
}
fun getCategorySight(res: Resources):Category{
    return Category(
        ResourcesCompat.getDrawable(res, R.drawable.ic_building, null),
        res.getString(R.string.category_sights)
    )
}
fun getCategoryNatureSight(res: Resources):Category{
    return Category(
        ResourcesCompat.getDrawable(res, R.drawable.ic_tree, null),
        res.getString(R.string.category_nature)
    )
}
fun getCategoryTowns(res: Resources):Category{
    return Category(
        ResourcesCompat.getDrawable(res, R.drawable.ic_map, null),
        res.getString(R.string.category_surroundings)
    )
}

fun getCategories(res: Resources): ArrayList<Category> {

    return arrayListOf(getCategoryFood(res), getCategoryNatureSight(res), getCategoryServices(res), getCategoryShop(res), getCategorySight(res), getCategoryTowns(res))
}

private fun getDistance(): Double {
    return Random.nextDouble(1.0, 100.0)
}

private fun listOfSight(res: Resources): List<Sight> {// TODO: 2021. 02. 02. when elágazás
    val sight = Sight(
        "Test Sight", "test sight description", true,
        ResourcesCompat.getDrawable(res, R.drawable.ic_tree, null)!!, null
    )
    return listOf(sight)
}

private fun getTownDrawables(res: Resources, townName: String): List<Drawable> {
    return when (townName) {
        res.getString(R.string.town_name_bogacs) -> listOf(
            ResourcesCompat.getDrawable(
                res,
                R.drawable.img_bogacs,
                null
            )!!
        )
        res.getString(R.string.town_name_bukkzserc) -> listOf(
            ResourcesCompat.getDrawable(
                res,
                R.drawable.img_bukkzserc,
                null
            )!!
        )
        res.getString(R.string.town_name_cserepfalu) -> listOf(
            ResourcesCompat.getDrawable(
                res,
                R.drawable.img_cserepfalu,
                null
            )!!
        )
        res.getString(R.string.town_name_eger) -> listOf(
            ResourcesCompat.getDrawable(
                res,
                R.drawable.img_eger,
                null
            )!!
        )
        res.getString(R.string.town_name_felsotarkany) -> listOf(
            ResourcesCompat.getDrawable(
                res,
                R.drawable.img_felsotarkany,
                null
            )!!
        )
        res.getString(R.string.town_name_mezokovesd) -> listOf(
            ResourcesCompat.getDrawable(
                res,
                R.drawable.img_mezokovesd,
                null
            )!!
        )
        res.getString(R.string.town_name_szomolya) -> listOf(
            ResourcesCompat.getDrawable(
                res,
                R.drawable.img_szomolya,
                null
            )!!
        )
        else -> listOf(ResourcesCompat.getDrawable(res, R.drawable.img_noszvaj_panorama, null)!!)
    }
}

fun listOfEvents(res: Resources): ArrayList<Drawable> {
    val eventList: List<Drawable>
    val img = ResourcesCompat.getDrawable(res, R.drawable.vector_festivities, null)!!
    return arrayListOf(img, img, img)
}

fun getNatureSights(res: Resources): ArrayList<Nature>{
    val testNatureSight = Nature("Példa Forrás",
        NatureType.SPRING,res.getString(R.string.loremipsum),ResourcesCompat.getDrawable(res,
            R.drawable.vector_hiking,null)!!,null)
    return arrayListOf(testNatureSight)
}

fun getRestaurants(res: Resources): ArrayList<Restaurant>{
    val testRestaurant = Restaurant("Példa Étterem",res.getString(R.string.loremipsum),
        Pricing.MODERATE,ResourcesCompat.getDrawable(res, R.drawable.vector_food,null)!!,null)
    return arrayListOf(testRestaurant)
}

fun getServices(res: Resources): ArrayList<Service>{
    val testService = Service("Példa Szolgáltatás",res.getString(R.string.loremipsum),ResourcesCompat.getDrawable(res,
        R.drawable.vector_road_sign,null)!!,null)
    return arrayListOf(testService)
}

fun getShops(res: Resources): ArrayList<Shop>{
    val testShop = Shop("Példa Test",ResourcesCompat.getDrawable(res, R.drawable.vector_shop,null)!!,null)
    return arrayListOf(testShop)
}

fun getSights(res: Resources): ArrayList<Sight>{
    val testSight = Sight("Példa Sight",res.getString(R.string.loremipsum),true,ResourcesCompat.getDrawable(res,
        R.drawable.vector_sight,null)!!,null)
    return arrayListOf(testSight)
}
fun getCategoryAsCategoryModel(){

}