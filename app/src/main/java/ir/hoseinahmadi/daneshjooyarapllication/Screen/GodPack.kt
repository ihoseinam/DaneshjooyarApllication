package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.gson.Gson
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.TopTicher
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont

val selectedTabGold = mutableStateOf(1)
@SuppressLint("UnrememberedMutableState")
@Composable
fun PackGold(navController: NavHostController) {
    var select by remember {
        selectedTabGold
    }
    val title = listOf(
        "اساتید طلایی",
        "دوره های طلایی"
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = select,
            contentColor = Color.Black,
            containerColor = Color.White,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[select])
                        .height(3.dp)
                        .background(dancolor)
                )
            },
            modifier = Modifier.padding(horizontal = 5.dp),
        ) {
            title.forEachIndexed { index, title ->
                Tab(
                    selected = select == index,
                    onClick = { select = index },
                    selectedContentColor = dancolor,
                    unselectedContentColor = Color.DarkGray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                fontFamily = myFont
                            )
                        }
                    },
                )

            }
        }
        when (select) {
            1 -> pack(navController)
            0 -> ticher()
        }


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoldPackItem(navController: NavHostController, data: DataProduct) {
    val datazori = DataProduct(
        data.id,
        data.title,
        data.nameTicher,
        data.img,
        data.priceOr,
        data.darsad,
        data.Houre,
        data.student,
        data.jalase,
        data.info,
        data.videoUrl,
    )
    val gson = Gson()
    val itemString = gson.toJson(datazori)
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {
            navController.navigate(Screen.InfoItemScreen.route + "?data=${itemString}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
            ) {
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    text = data.title,
                    fontFamily = myFont
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.nameTicher, fontFamily = myFont,
                    textAlign = TextAlign.End,
                    color = dancolor
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.8.dp)
                        .background(Color(0x0F6B6969))
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.toman), contentDescription = "",
                        Modifier
                            .size(25.dp)
                            .padding(start = 5.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = darsadfun(data.priceOr, data.darsad), fontFamily = myFont,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.Red
                    )
                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .weight(0.4f)
            ) {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .padding(4.dp),
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = data.img),
                    contentDescription = ""
                )
            }


        }
    }

}

@Composable
fun TopTicherTab(data: TopTicher) {
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(410.dp)
            .clickable { }
            .padding(2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
        ) {
            Image(
                modifier = Modifier
                    .width(240.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .height(300.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp),
                painter = painterResource(id = data.img), contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = data.name,
                fontSize = 20.sp,
                fontFamily = myFont,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(end = 6.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data.info,
                fontSize = 14.sp,
                fontFamily = myFont,
                color = Color.Black,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(end = 6.dp)
            )

        }
    }
}


@Composable
fun pack(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp)
            .background(Color(0xffd6a927)),
    ) {
        val loveitem = arrayOf(
            DataProduct(
                1,
                "جامع ترین دوره آموزش برنامه نویسی اندروید (کاتلین، فلاتر و جاوا)",
                "علیرضا احمدی",
                R.drawable.androidgold,
                6900000,
                60,
                150,
                815,
                350,
                arrayListOf(

                    "آموزش کامل نصب و راه اندازی نرم افزار اندروید استودیو",
                    "آموزش برنامه نویسی با کمک جت جی پی تی و گوگل بارد",
                    "آموزش فلاتر و جاوا جهت تکمیل رزومه",
                    "ایجاد اپلیکیشن نمایش قیمت ارز و طلا به صورت آنلاین",
                    "آموزش اعتبارسنجی و احراز هویت کاربران با ایمیل",
                    "آموزش تخصصی ارتباط با سرور و آنلاین کردن اپلیکیشن ها",
                    "دریافت مدرک طلایی قابل استعلام پس از اتمام دوره",
                ),
                "دوره آموزش اندروید از مقدمات شروع میشه. لازم نیست چیزی یاد داشته باشی رفیق. همینکه بتونی سیستم رو خاموش روشن کنی یا یه سرچ ساده تو گوگل انجام بدی کافیه. میدونی که سیستم عامل اندروید الان 80 درصد بازار گوشی های موبایل رو به خودش اختصاص داده و در تمام ابزارهایی مثل تلویزیون، ساعت هوشمند، عینک و حتی یخچال ها هم مورد استفاده قرار میگیره. البته با فلاتر و جت پک کامپوز میتونی خروجی ویندوز و IOS هم بگیری که این فریمورک ها هم در همین دوره، آموزش داده میشه. پس بازار کار خیلی بزرگی رو پیش روی خودت تصور کن.\n" +
                        "\n" +
                        "سخن مدرس: اگر تضمین کنی که طبق برنامه من پیش بیای و دوره رو ببینی، منم تضمین میکنم که تبدیل به یک برنامه نویس اندروید بشی.\n" +
                        "\n" +
                        "اینکه توانایی استفاده از گوشی های اندرویدی رو داری عالیه، اما سبب کسب درآمد تو از این حوزه نمیشه. تو الان فقط یک مصرف کننده از سیستم عامل اندروید هستی. من قصد دارم تو رو از یک مصرف کننده ساده، تبدیل به یک توسعه دهنده\u200E\u200Cی توانمند در حوزه برنامه نویسی اندروید کنم. پس با استفاده از آموزش برنامه نویسی اندروید میتونی هر اپلیکیشنی که مدنظرت هست رو پیاده سازی کنی. اگر قصد مهاجرت داری؛ اگر به فکر استخدام در شرکت های بزرگ ایران نظیر دیجی کالا، سروش، اسنپ، دیوار و غیره هستی یا اگر ایده شخصی داری و میخوای نرم\u200Cافزاری اختصاصی پیاده سازی کنی، به آموزش اندروید خوش اومدی.",
                "https://dl.daneshjooyar.com/mvie/Ahmadi-Alireza/Android-Programming/present/Demo-Android.mp4"
            ),
            DataProduct(
                2,
                "دوره آموزش افزونه نویسی وردپرس، پلاگین نویسی حرفه ای برای وردپرس",
                "حامد مودی",
                R.drawable.word,
                1299000,
                40,
                17,
                422,
                72,
                arrayListOf(
                    "آشنایی کامل با مفهوم و فلسفه سورس کنترل ها",
                    "مفاهیم اولیه در گیت، نظیر نصب و ساخت ریپازیتوری و ...",
                    "ایجاد شاخه در گیت",
                    "جابجایی بین کامیت های مختلف",
                    "خطایابی و دیباگینگ بوسیله گیت",
                ),
                "Git متداول\u200Cترین سیستم سورس کنترل است. Git نرم افزاری است که به صورت محلی اجرا شده و پرونده\u200Cها و تاریخچه آن\u200Cها را در رایانه شما ذخیره می\u200Cکند. با این وجود دیگر نگران از دست دادن اطلاعات و سورس کد های خود نخواهید بود. با استفاده از گیت همچنین می\u200Cتوانید از گیت هاب GitHub برای ذخیره یک کپی از پرونده\u200Cها و سابقه ویرایش آن\u200Cها استفاده کنید. بستری جذاب برای برنامه نویس ها برای به اشتراک گذاشتن سورس خود با دیگران و استفاده از سورس دیگران و تجریه های برنامه نویسی آن ها است.\n" +
                        "\n" +
                        "Git می\u200Cتواند تغییرات را به طور خودکار ادغام کند، به عنوان مثال دو نفر می\u200Cتوانند در قسمت\u200Cهای مختلف یک فایل کار کنند و بعدا بدون تغییر کار یکدیگر، آن تغییرات را ادغام کنند! بنابراین صرف نظر از اینکه شما کدی را به تنهایی\u200C می\u200Cنویسید یا در قالب یک تیم کار می\u200Cکنید، آموزش جامع Git برای شما مفید خواهد بود.",
                "https://dl.daneshjooyar.com/mvie/Moodi_Hamed/Wordpress-Plugin-Development/Wordpress-Plugin-Development-Demo-720.mp4"
            ),

            )
        itemsIndexed(loveitem) { index, item ->
            GoldPackItem(navController = navController, data = item)
        }
    }

}


@Composable
fun ticher() {
    val topTicher = arrayOf(
        TopTicher(
            1,
            "استاد علیرضا احمدی",
            R.drawable.ali,
            "متخصص برنامه نویسی موبایل "
        ),
        TopTicher(
            2,
            "استاد حامد مودی",
            R.drawable.modi,
            "طراح و کدنویس افزونه و قالب وردپرس "
        ),
        TopTicher(
            1,
            "استاد طاها اهوازی",
            R.drawable.taha,
            "برنامه نویس فول استک موبایل"
        ),
    )
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(4.dp),
        content = {
            itemsIndexed(topTicher) { index: Int, item: TopTicher ->
                TopTicherTab(data = item)
            }
        })
}


private fun darsadfun(price: Int, darsad: Int): String {
    return if (darsad > 0) {
        val ee = (price * darsad) / 100
        val b = price - ee
        String.format("%,d", b)
    } else {
        price.toString()
    }
}
