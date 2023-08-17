package com.arzhang.project.mycityapp.data.dataStore

import com.arzhang.project.mycityapp.R
import com.arzhang.project.mycityapp.data.Place
import com.arzhang.project.mycityapp.data.PlaceType

object LocalCityDataProvider {
    val defaultPlace = getCityData()[0]

    fun getCityData(): List<Place> {
        return listOf(
            Place(
            id = 1,
            name = "کافه دهاتی"  ,
            placeType = PlaceType.Cafe,
            image = R.drawable.dehati_cafe,
            placeDetails = "آدرس : کرج، درختی، بعد از پارک عطار، قبل از حافظ" +
                    " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 2,
                name = "کافه وینتیج"  ,
                placeType = PlaceType.Cafe,
                image = R.drawable.vintage_cafe,
                placeDetails = "آدرس : کرج، مهرشهر، پیچک 1، نبش ١١٤ غربى"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 3,
                name = "کافه میکلانژ"  ,
                placeType = PlaceType.Cafe,
                image = R.drawable.cafe_miklanche,
                placeDetails = "کرج دهقان ویلای دوم خیابان نیاکی جنب باشگاه رایان سپند"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 4,
                name = "آبشار خور "  ,
                placeType = PlaceType.Park,
                image = R.drawable.khor_waterfall,
                placeDetails = "ایران، البرز، کرج، جاده کرج-چالوس"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 5,
                name = "دهکده ورزشی چهارباغ"  ,
                placeType = PlaceType.Park,
                image = R.drawable.charbagh,
                placeDetails = "استان البرز، پل کردن ، چهارباغ ، دهکده ورزشی چهارباغ"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 6,
                name = "رودخانه کرج"  ,
                placeType = PlaceType.Park,
                image = R.drawable.karaj_river,
                placeDetails = "البرز مرکزی- شمال باختری تهران"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 7,
                name = "مرکز خرید پارسیان"  ,
                placeType = PlaceType.Shop,
                image = R.drawable.parsian_shoppingcenter,
                placeDetails = "کرج،شهرک فرهنگیان،بلوار تربیت معلم،بلوار تربیت مربی"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 8,
                name = "مرکز خرید مبنا"  ,
                placeType = PlaceType.Shop,
                image = R.drawable.mabna_shoppingcenter,
                placeDetails = "البرز کرج مهرشهر بلوار شهرداری خیابان 111 ، مرکز خرید مبنا"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 9,
                name = "مرکز خرید نیکامال"  ,
                placeType = PlaceType.Shop,
                image = R.drawable.nikamall,
                placeDetails = "کرج،اتحاد،بلوار آزادی،خ. آرش"+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 10,
                name = "کافه کربن"  ,
                placeType = PlaceType.Cafe,
                image = R.drawable.cafe_carbon,
                placeDetails = "کرج مهرشهر بلوار ارم خیابان ..."+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 11,
                name = "کافه شهر"  ,
                placeType = PlaceType.Cafe,
                image = R.drawable.img,
                placeDetails = "کرج مهرشهر بلوار ارم خیابان ..."+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 12,
                name = "کافه صاحبقرانیه"  ,
                placeType = PlaceType.Cafe,
                image = R.drawable.img_1,
                placeDetails = "کرج مهرشهر بلوار ارم خیابان ..."+
                        " \n\n\nشماره تماس: 02622342345"
            ),
            Place(
                id = 13,
                name = "کاخ مروارید"  ,
                placeType = PlaceType.Park,
                image = R.drawable.img_2,
                placeDetails = "کرج مهرشهر بلوار ارم خیابان ..."
            ),
            Place(
                id = 14,
                name = "پارک مکعب"  ,
                placeType = PlaceType.Park,
                image = R.drawable.img_3,
                placeDetails = "کرج مهرشهر شهرداری ..."
            ),
            Place(
                id = 15,
                name = "باغ فاتح"  ,
                placeType = PlaceType.Park,
                image = R.drawable.img_4,
                placeDetails = "کرج خیابان شهید بهشتی ..."
            ),
            Place(
                id = 16,
                name = "راه تندرستی"  ,
                placeType = PlaceType.Park,
                image = R.drawable.img_5,
                placeDetails = "کرج مهرشهر بلوار دانش ..."
            ),
            Place(
                id = 17,
                name = "مهرادمال"  ,
                placeType = PlaceType.Shop,
                image = R.drawable.img_6,
                placeDetails = "کرج عظیمیه ..."
            ),
            Place(
                id = 18,
                name = "مهستان"  ,
                placeType = PlaceType.Shop,
                image = R.drawable.img_5,
                placeDetails = "کرج نبوت..."
            ),
        )
    }
}