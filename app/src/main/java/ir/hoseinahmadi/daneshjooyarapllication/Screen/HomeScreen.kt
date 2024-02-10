package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.gson.Gson
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    val loveitem = arrayOf(
        DataProduct(
            1,
            stringResource(id = R.string.androidTitle),
            "علیرضا احمدی",
            R.drawable.androidgold,
            6900000,
            60,
            150,
            815,
            350,
            arrayListOf(
                stringResource(id = R.string.an1),
                stringResource(id = R.string.an2),
                stringResource(id = R.string.an3),
                stringResource(id = R.string.an4),
                stringResource(id = R.string.an5),
                stringResource(id = R.string.an6),
                stringResource(id = R.string.an7),
            ),
            "دوره آموزش اندروید از مقدمات شروع میشه. لازم نیست چیزی یاد داشته باشی رفیق. همینکه بتونی سیستم رو خاموش روشن کنی یا یه سرچ ساده تو گوگل انجام بدی کافیه. میدونی که سیستم عامل اندروید الان 80 درصد بازار گوشی های موبایل رو به خودش اختصاص داده و در تمام ابزارهایی مثل تلویزیون، ساعت هوشمند، عینک و حتی یخچال ها هم مورد استفاده قرار میگیره. البته با فلاتر و جت پک کامپوز میتونی خروجی ویندوز و IOS هم بگیری که این فریمورک ها هم در همین دوره، آموزش داده میشه. پس بازار کار خیلی بزرگی رو پیش روی خودت تصور کن.\n" +
                    "\n" +
                    "سخن مدرس: اگر تضمین کنی که طبق برنامه من پیش بیای و دوره رو ببینی، منم تضمین میکنم که تبدیل به یک برنامه نویس اندروید بشی.\n" +
                    "\n" +
                    "اینکه توانایی استفاده از گوشی های اندرویدی رو داری عالیه، اما سبب کسب درآمد تو از این حوزه نمیشه. تو الان فقط یک مصرف کننده از سیستم عامل اندروید هستی. من قصد دارم تو رو از یک مصرف کننده ساده، تبدیل به یک توسعه دهنده\u200E\u200Cی توانمند در حوزه برنامه نویسی اندروید کنم. پس با استفاده از آموزش برنامه نویسی اندروید میتونی هر اپلیکیشنی که مدنظرت هست رو پیاده سازی کنی. اگر قصد مهاجرت داری؛ اگر به فکر استخدام در شرکت های بزرگ ایران نظیر دیجی کالا، سروش، اسنپ، دیوار و غیره هستی یا اگر ایده شخصی داری و میخوای نرم\u200Cافزاری اختصاصی پیاده سازی کنی، به آموزش اندروید خوش اومدی."
        ),
        DataProduct(
            2,
            stringResource(id = R.string.afzoneTitle),
            "حامد مودی",
            R.drawable.word,
            1299000,
            40,
            17, 422, 72,
            arrayListOf(
                stringResource(id = R.string.git1),
                stringResource(id = R.string.git2),
                stringResource(id = R.string.git3),
                stringResource(id = R.string.git4),
                stringResource(id = R.string.git5),
            ),
            "Git متداول\u200Cترین سیستم سورس کنترل است. Git نرم افزاری است که به صورت محلی اجرا شده و پرونده\u200Cها و تاریخچه آن\u200Cها را در رایانه شما ذخیره می\u200Cکند. با این وجود دیگر نگران از دست دادن اطلاعات و سورس کد های خود نخواهید بود. با استفاده از گیت همچنین می\u200Cتوانید از گیت هاب GitHub برای ذخیره یک کپی از پرونده\u200Cها و سابقه ویرایش آن\u200Cها استفاده کنید. بستری جذاب برای برنامه نویس ها برای به اشتراک گذاشتن سورس خود با دیگران و استفاده از سورس دیگران و تجریه های برنامه نویسی آن ها است.\n" +
                    "\n" +
                    "Git می\u200Cتواند تغییرات را به طور خودکار ادغام کند، به عنوان مثال دو نفر می\u200Cتوانند در قسمت\u200Cهای مختلف یک فایل کار کنند و بعدا بدون تغییر کار یکدیگر، آن تغییرات را ادغام کنند! بنابراین صرف نظر از اینکه شما کدی را به تنهایی\u200C می\u200Cنویسید یا در قالب یک تیم کار می\u200Cکنید، آموزش جامع Git برای شما مفید خواهد بود."
        ),

        )
    val newite = arrayOf(
        DataProduct(
            10,
            "آموزش ووکامرس رایگان | ایجاد سایت فروشگاهی با وردپرس",
            "علیرضا احمدی",
            R.drawable.wooo,
            1000000,
            100,
            5,
            28,
            41,
            arrayListOf(
                "نصب ووکامرس بر روی وردپرس",
                "کانفیگ حمل و نقل و مالیات",
                "بازاریابی و تجزیه و تحلیل",
                "نصب قالب مورد نیاز بر روی وردپرس",
                "محصول گذاری متغییر",
                "نصب و پیکربندی افزونه ووکامرس فارسی",
            ),
            "در این آموزش قصد داریم تا یک فروشگاه اینترنتی را از صفر بوسیله افزونه ووکامرس پیاده سازی کنیم. پس از گذراندن دوره آموزش ووکامرس، شما قادر به پیاده سازی یک فروشگاه اینترنتی کاملا حرفه ای در سیستم مدیریت محتوای وردپرس خواهید بود. فروشگاهی که امکان ایجاد محصول، قیمت گذاری و رفتن به درگاه پرداخت را برای شما فراهم میکند. در این دوره آموزش طراحی سایت فروشگاهی با وردپرس از افزونه رسمی ووکامرس استفاده شده ولی شما قادر به پیاده سازی هر فروشگاهی با هر قالبی در وردپرس خواهید بود."
        ),
        DataProduct(
            11, "آموزش ساخت خزنده وب با پایتون (خزش در صفحات دیجی کالا)",
            "علی رستمی",
            R.drawable.khaz,
            299000,
            40, 4, 26, 11,
            arrayListOf(
                "ساخت خزنده وب با پایتون",
                "خزش در صفحات دیجی کالا",
                "مرور سینتکس پایتون",
            ),
            "چنانچه به دنبال راهی هستید که مهارت\u200Cهای کراولینگ وب را با استفاده از زبان پایتون به دست آورید،  دوره آموزش ساخت خزنده وب با پایتون یک سفر هیجان انگیز در دنیای کراولینگ وب است که شما را به دنیایی از امکانات فراوان هدایت می\u200Cکند. با این دوره، شما با روش\u200Cهای پیشرفته کراولینگ آشنا می\u200Cشوید و تکنیک\u200Cهای جدیدتر را برای مدیریت و استخراج داده\u200Cها از وب آموزش می\u200Cبینید. این به شما اجازه می\u200Cدهد تا به آسانی اطلاعات مورد نیاز خود را از وب جمع\u200Cآوری کرده و به سود خود بهره\u200Cبرداری کنید. علاوه بر این، با یادگیری پایتون، به دید بهتری از کاربردهای جذاب برنامه\u200Cنویسی این زبان دست خواهید یافت. با ضمانت صددرصد بازگشت وجه در صورت نارضایتی، شما می\u200Cتوانید با آرامش خاطر این دوره را شروع کنید و به سرعت مهارت خود در زمینه کراولینگ وب با پایتون را بهبود بخشید. بنابراین، این فرصت را از دست ندهید و همین حالا شروع کنید!\n" +
                    "\n" +
                    "آموزش ساخت خزنده وب با پایتون برای چه کسانی مفید است؟\n" +
                    "آموزش ساخت خزنده وب با پایتون برای چه کسانی مفید است؟ این سوالی است که حتما به ذهن شما نیز خطور خواهد کرد و بهتر است بدانید تمامی برنامه\u200C نویس\u200Cها می\u200Cتوانند از این روش استفاده کنند. در صورتی که با داده\u200Cهای به روز و آنلاین سر و کار دارید و قصد شما دریافت و استفاده از آن\u200Cها در یک ابزار برنامه نویسی شده است، مطمئنا وب کراولینگ با پایتون شما را کمک خواهد کرد تا مدیریت خوبی روی داده\u200Cها داشته باشید.\n" +
                    "\n" +
                    "اگر توسعه دهنده اپلیکیشن\u200Cهای موبایلی هستید، وب کراولینگ روشی است که می\u200Cتوان در بسیاری از اپلیکیشن\u200Cها از آن استفاده کرد و در این روش شما به سرعت می\u200Cتوانید داده\u200Cهایی را از یک سرور دریافت و در حالت مورد نیاز استفاده کنید. برای نمونه، دریافت داده\u200Cهای هواشناسی از یک سرور می\u200Cتواند کاربرد مهم وب کراولینگ با پایتون باشد یا حتی می\u200Cتوان با این روش متادیتا هایی را در مورد فیلم\u200Cها از یک منبع اینترنتی دریافت کرد. \n" +
                    "\n" +
                    "در مقابل، برای توسعه اپلیکیشن\u200Cهای دسکتاپ و حتی وب نیز از وب کراول استفاده می\u200Cشود که پایتون در این مورد بهترین گزینه\u200C است. کتابخانه\u200Cهای متنوع و قدرتمندی در این زبان وجود دارند که در عمل کار شما را برای ساخت یک وب کراولر در پایتون آسان خواهند کرد."
        ),
        DataProduct(
            12, " دوره آموزش جاوا بهمراه ۲۰ تمرین واقعی",
            "طاها اهوازی", R.drawable.java, 1900000, 40, 20, 31, 85,
            arrayListOf(
                "آموزش شی گرایی در زبان برنامه نویسی جاوا",
                "بررسی کامل مدیریت فایل ها در جاوا",
                "آموزش کامل سینتکس زبان برنامه نویسی جاوا",
                "بررسی عملگر ها در جاوا",
            ),
            "هنگامی که پله\u200Cهای دانش برنامه\u200Cنویسی را به سوی آینده\u200Cای پر از امکانات و خلاقیت پشت سر می\u200Cگذارید، جاوا در کنار شما خواهد بود. فکر کنید به دنیایی که در آن می\u200Cتوانید ایده\u200Cهای خود را به واقعیت تبدیل کنید، برنامه\u200Cهایی بنویسید که باعث تحول در جامعه شوند و امکانات جدیدی را برای مردم فراهم کنید. جاوا، آن بستر عجیبی است که شما را به سمت جاده\u200Cهای تازه\u200Cای از ابتکار و خلاقیت هدایت می\u200Cکند. با آموزش جاوا در دانشجویار، شما به یادگیری مفاهیم پایه این زبان می\u200Cپردازید و سپس با آگاهی از اصول شیءگرایی، به دنیایی از کلاس\u200Cها، شیء\u200Cها و روش\u200Cها وارد می\u200Cشوید. آماده\u200Cاید به ماجراجویی جاوا در دانشجویار بپیوندید؟ جاوا در انتظار شماست تا شما را به مبدأ جدیدی از خلاقیت برنامه\u200Cنویسی ببرد.\n" +
                    "\n" +
                    "پیش\u200Cنیاز آموزش جاوا چیست؟\n" +
                    "برای یادگیری جاوا نیاز به داشتن دانش قبلی نیست. در این دوره آموزشی از صفر تا صد زبان برنامه نویسی جاوا را خواهید آموخت. شما فقط به یک کامپیوتر که قابلیت اجرای نرم افزار IntelliJ IDEA را داشته باشد، هیچ پیش نیاز دیگری لازم نیست\n" +
                    "\n" +
                    "آموزش جاوا دانشجویار مناسب چه افرادیست؟\n" +
                    "این دوره آموزش جاوا مناسب برای تمام افرادیست که میخواهند یک زبان برنامه نویسی قدیمی و البته به روز را شروع به یادگیری کنند و در صنایع مختلف مشغول به کار شوند برای مثال، افرادی که به دنبال کار در صنعت فناوری اطلاعات هستند با توجه به گستردگی استفاده از جاوا در صنعت، آشنایی با آن می\u200Cتواند برای افرادی که قصد ورود به این صنعت را دارند، بسیار مفید باشد.\n" +
                    "به طور کلی، جاوا یکی از زبان\u200Cهای برنامه\u200Cنویسی پرکاربرد و گسترده است که برای افراد با تمام سطوح تجربه واهداف مختلف می\u200Cتواند مناسب باشد."
        ),
        DataProduct(
            13, "آموزش پیاده سازی ۲۰ پروژه جاوا اسکریپتی مناسب بازار کار",
            "محمد حسین معین", R.drawable.javascr,
            299000, 40, 3, 34, 20,
            arrayListOf(
                "صفحه بندی سایت",
                "ساخت بازی عدد رندوم",
                "گرفتن اطلاعات در ناسا",
                "ساخت ساعت زنگ دار",
            ),
            "جاوا اسکریپت یکی از زبان\u200Cهای برنامه نویسی بسیار محبوب و رایج برای توسعه وب است. با توجه به افزایش استفاده از فناوری\u200Cهای وب و دسترسی آسان به منابع آموزشی، بازار کار جاوا اسکریپت رونق بالایی داشته است. شرکت\u200Cهای فعال در حوزه توسعه و طراحی وب جاوا اسکریپت، برنامه\u200Cنویسان با تجربه در این زمینه را جذب می\u200Cکنند. از این رو در این دوره آموزشی از دانشجویار سعی کرده\u200Cایم با انجام گام به گام ۲۰ پروژه عملی جاوا اسکریپت شما را برای ورود به بازار کار واقعی در ایران و جهان آماده کنیم. برای انجام این پروژه\u200Cها شما فقط نیازمند دانش مبتدی از مباحث طراحی سایت هستید.\n" +
                    "\n" +
                    "مزیت های دوره:\n" +
                    "آموزش کاربردی: این دوره برای شرکت\u200Cکنندگان به عنوان یک دوره کاربردی در زمینه جاوا اسکریپت طراحی شده است. شما با ۲۰ پروژه متنوع مواجه خواهید شد که در آن\u200Cها مهارت\u200Cهای اساسی و پیشرفته جاوا اسکریپت را به کار خواهید برد. این مزیت به شما امکان می\u200Cدهد تجربه عملی و عملیاتی در جاوا اسکریپت به دست آورید.\n" +
                    "\n" +
                    "آموزش شغلی: با تکمیل این دوره و اجرای پروژه\u200Cهای مختلف، شما قادر خواهید بود تا به عنوان یک توسعه\u200Cدهنده جاوا اسکریپت وارد بازار کار شوید. این دوره به شما ابزارها، مفاهیم و تکنیک\u200Cهای لازم را در اختیار می\u200Cگذارد تا به عنوان یک حرفه\u200Cای در زمینه جاوا اسکریپت موفق عمل کنید."
        )
    )
    Scaffold(
        containerColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.White,
                shape = CircleShape,
                onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.posh),
                    contentDescription ="",
                    modifier = Modifier.size(60.dp)
                    )
            }
        },
        topBar = { MyTopBarHome() }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
            state = rememberLazyListState()
        ) {
            item {
                MySlider()
            }
            item {
                TopProduct(
                    text = "جدید ترین ها",
                    navController,
                    Screen.PackGold.route,
                    Screen.Home.route
                )
                LazyRow(
                    reverseLayout = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp)
                        .wrapContentHeight()
                ) {
                    itemsIndexed(newite) { index: Int, item: DataProduct ->
                        ItemProduct(data = item, navController)
                    }
                }

            }

            item {
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    state = rememberLazyListState(),
                    reverseLayout = true,
                    modifier = Modifier
                        .background(Color(0xFFC77905))
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                        .wrapContentHeight()
                ) {
                    item { AmazingStart() }
                    item { }
                    itemsIndexed(loveitem) { index, item ->
                        AmazingItem(navController = navController, data = item)
                    }
                    item {
                        AmazingEnd(navController, Screen.PackGold.route, Screen.Home.route)
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                TopProduct(
                    text = "محبوب ترین ها",
                    navController,
                    Screen.PackGold.route,
                    Screen.Home.route
                )
                LazyRow(
                    reverseLayout = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp)
                        .wrapContentHeight()
                ) {
                    itemsIndexed(loveitem) { index: Int, item: DataProduct ->
                        ItemProduct(data = item, navController)
                    }
                }
            }
        }

    }

}


@Composable
fun AmazingStart() {
    Column(
        modifier = Modifier
            .width(180.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .width(150.dp)
                .height(120.dp),
            text = "پکیج های طلایی",
            fontSize = 35.sp,
            color = Color.White,
            fontFamily = myFont,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(105.dp),
            painter = painterResource(id = R.drawable.box), contentDescription = ""
        )
    }
}

@Composable
fun AmazingEnd(navController: NavHostController, route1: String, route2: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .width(180.dp)
            .height(300.dp)
            .padding(start = 10.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                border = BorderStroke(1.5.dp, Color.Red),
                color = Color.White
            ) {
                IconButton(onClick = {
                    navController.navigate(route1) {
                        popUpTo(route2) {
                            inclusive = true
                        }
                    }
                }) {
                    Icon(
                        Icons.Default.KeyboardArrowLeft,
                        contentDescription = "",
                        Modifier.size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "مشاهده همه",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = myFont
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmazingItem(navController: NavHostController, data: DataProduct) {
    val zori = DataProduct(
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
        data.more
    )
    val gson = Gson()
    val itemstring = gson.toJson(zori)
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {
            navController.navigate(Screen.InfoItemScreen.route + "?data=${itemstring}")
        },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(220.dp)
            .height(300.dp)
            .padding(start = 10.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            Image(
                painter = painterResource(id = data.img), contentDescription = "",
                Modifier
                    .width(220.dp)
                    .height(140.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = data.title,
                fontFamily = myFont,
                fontSize = 16.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(end = 5.dp, start = 1.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = data.nameTicher,
                fontFamily = myFont,
                fontSize = 14.sp,
                color = dancolor,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(end = 5.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0xfffffff))
            )
            Row(
                modifier = Modifier.padding(start = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.toman),
                    contentDescription = "",
                    Modifier.size(23.dp)
                )
                Text(
                    text = darsadfun(data.priceOr, data.darsad),
                    fontFamily = myFont,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .fillMaxWidth()
                )
            }

        }
    }
}

@Composable
fun MyTopBarHome() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
            Image(painter = painterResource(id = R.drawable.logotype), contentDescription = "")

        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.5.dp)
                .background(Color(0x0F4C4A4A))
        )

    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MySlider(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
    )
    val pagerState = com.google.accompanist.pager.rememberPagerState(
        pageCount =
        images.size
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier.wrapContentSize()) {
            com.google.accompanist.pager.HorizontalPager(
                state = pagerState,
                modifier
                    .wrapContentSize()
            ) { currentPage ->
                Card(
                    modifier
                        .wrapContentSize()
                        .padding(10.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = images[currentPage]),
                        contentDescription = ""
                    )
                }
            }
            IconButton(
                onClick = {
                    val nextPage = pagerState.currentPage + 1
                    if (nextPage < images.size) {
                        scope.launch {
                            pagerState.scrollToPage(nextPage)
                        }
                    }
                },
                modifier
                    .padding(30.dp)
                    .size(48.dp)
                    .align(Alignment.CenterEnd)
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x52373737)
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.LightGray
                )
            }
            IconButton(
                onClick = {
                    val prevPage = pagerState.currentPage - 1
                    if (prevPage >= 0) {
                        scope.launch {
                            pagerState.scrollToPage(prevPage)
                        }
                    }
                },
                modifier
                    .padding(30.dp)
                    .size(48.dp)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x52373737)
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.LightGray
                )

            }


        }

    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage, modifier = modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp, label = "")
    Box(
        modifier = modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xff373737) else Color(0xA8373737))
    )
}

@Composable
fun TopProduct(text: String, navController: NavHostController, route1: String, route2: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(0.5f),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextButton(onClick = {
                navController.navigate(route1) {
                    popUpTo(route2) {
                        inclusive = true
                    }
                }
            }) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                    Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = "مشاهده همه",
                    fontSize = 16.sp,
                    fontFamily = myFont
                )


            }
        }
        Text(
            modifier = Modifier
                .weight(0.5f)
                .padding(end = 8.dp),
            text = text,
            fontSize = 24.sp,
            textAlign = TextAlign.End,
            fontFamily = myFont
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemProduct(data: DataProduct, navController: NavHostController) {
    val zori = DataProduct(
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
        data.more
    )
    val gson = Gson()
    val itemstring = gson.toJson(zori)
    val priceortakh = darsadfun(data.priceOr, data.darsad)

    Card(
        onClick = {
            navController.navigate(
                route = Screen.InfoItemScreen.route + "?data=${itemstring}"
            )
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(15.dp),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(300.dp)
            .height(320.dp)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.6f),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = data.img),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                        .padding(2.dp),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 10.dp), contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = "${data.darsad} %",
                        modifier = Modifier
                            .width(48.dp)
                            .height(25.dp)
                            .background(
                                Color(0xfff32e2e),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = myFont,
                        fontSize = 15.sp
                    )
                }
            }
            Column(modifier = Modifier.weight(0.5f)) {
                Text(
                    text = data.title,
                    textAlign = TextAlign.End,
                    fontSize = 16.sp,
                    fontFamily = myFont

                )
                Text(
                    text = data.nameTicher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    fontSize = 15.sp,
                    fontFamily = myFont,
                    textAlign = TextAlign.End,
                    color = dancolor
                )
                Spacer(modifier = Modifier.height(5.dp))
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(Color(0x0F6B6969))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            Modifier.size(26.dp),
                        )

                        Text(
                            text = priceortakh,
                            modifier = Modifier
                                .padding(start = 6.dp),
                            fontSize = 17.sp,
                            fontFamily = myFont,
                            color = Color.Black
                        )
                    }
                    val zori = String.format("%,d", data.priceOr)
                    Text(
                        text = zori,
                        modifier = Modifier
                            .padding(end = 4.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 13.sp,
                        fontFamily = myFont,
                        textDecoration = TextDecoration.LineThrough
                    )
                }

            }


        }


    }
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


