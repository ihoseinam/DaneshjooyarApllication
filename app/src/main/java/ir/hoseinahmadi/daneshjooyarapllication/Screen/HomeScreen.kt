package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Brush
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
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.Category
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.TopTicher
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
                    "اینکه توانایی استفاده از گوشی های اندرویدی رو داری عالیه، اما سبب کسب درآمد تو از این حوزه نمیشه. تو الان فقط یک مصرف کننده از سیستم عامل اندروید هستی. من قصد دارم تو رو از یک مصرف کننده ساده، تبدیل به یک توسعه دهنده\u200E\u200Cی توانمند در حوزه برنامه نویسی اندروید کنم. پس با استفاده از آموزش برنامه نویسی اندروید میتونی هر اپلیکیشنی که مدنظرت هست رو پیاده سازی کنی. اگر قصد مهاجرت داری؛ اگر به فکر استخدام در شرکت های بزرگ ایران نظیر دیجی کالا، سروش، اسنپ، دیوار و غیره هستی یا اگر ایده شخصی داری و میخوای نرم\u200Cافزاری اختصاصی پیاده سازی کنی، به آموزش اندروید خوش اومدی.",
            "https://dl.daneshjooyar.com/mvie/Ahmadi-Alireza/Android-Programming/present/Demo-Android.mp4"
        ),
        DataProduct(
            2,
            stringResource(id = R.string.afzoneTitle),
            "حامد مودی",
            R.drawable.word,
            1299000,
            40,
            17,
            422,
            72,
            arrayListOf(
                stringResource(id = R.string.git1),
                stringResource(id = R.string.git2),
                stringResource(id = R.string.git3),
                stringResource(id = R.string.git4),
                stringResource(id = R.string.git5),
            ),
            "Git متداول\u200Cترین سیستم سورس کنترل است. Git نرم افزاری است که به صورت محلی اجرا شده و پرونده\u200Cها و تاریخچه آن\u200Cها را در رایانه شما ذخیره می\u200Cکند. با این وجود دیگر نگران از دست دادن اطلاعات و سورس کد های خود نخواهید بود. با استفاده از گیت همچنین می\u200Cتوانید از گیت هاب GitHub برای ذخیره یک کپی از پرونده\u200Cها و سابقه ویرایش آن\u200Cها استفاده کنید. بستری جذاب برای برنامه نویس ها برای به اشتراک گذاشتن سورس خود با دیگران و استفاده از سورس دیگران و تجریه های برنامه نویسی آن ها است.\n" +
                    "\n" +
                    "Git می\u200Cتواند تغییرات را به طور خودکار ادغام کند، به عنوان مثال دو نفر می\u200Cتوانند در قسمت\u200Cهای مختلف یک فایل کار کنند و بعدا بدون تغییر کار یکدیگر، آن تغییرات را ادغام کنند! بنابراین صرف نظر از اینکه شما کدی را به تنهایی\u200C می\u200Cنویسید یا در قالب یک تیم کار می\u200Cکنید، آموزش جامع Git برای شما مفید خواهد بود.",
            "https://dl.daneshjooyar.com/mvie/Moodi_Hamed/Wordpress-Plugin-Development/Wordpress-Plugin-Development-Demo-720.mp4"
        ),

        )
    val newite = arrayOf(
        DataProduct(
            11,
            "آموزش ساخت خزنده وب با پایتون (خزش در صفحات دیجی کالا)",
            "علی رستمی",
            R.drawable.khaz,
            299000,
            40,
            4,
            26,
            11,
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
                    "در مقابل، برای توسعه اپلیکیشن\u200Cهای دسکتاپ و حتی وب نیز از وب کراول استفاده می\u200Cشود که پایتون در این مورد بهترین گزینه\u200C است. کتابخانه\u200Cهای متنوع و قدرتمندی در این زبان وجود دارند که در عمل کار شما را برای ساخت یک وب کراولر در پایتون آسان خواهند کرد.",
            "https://dl.daneshjooyar.com/mvie/Rostami-Ali/other/demo-crawler.mp4"
        ),
        DataProduct(
            12,
            "  دوره آموزش جاوا به همراه ۲۰ تمرین واقعی + آموزش شی گرایی",
            "طاها اهوازی",
            R.drawable.java,
            1900000,
            40,
            20,
            31,
            85,
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
                    "به طور کلی، جاوا یکی از زبان\u200Cهای برنامه\u200Cنویسی پرکاربرد و گسترده است که برای افراد با تمام سطوح تجربه واهداف مختلف می\u200Cتواند مناسب باشد.",
            "https://dl.daneshjooyar.com/mvie/Ahvazi_Taha_d056890e/java/demo-java.mp4"

        ),
        DataProduct(
            13,
            "آموزش پیاده سازی ۲۰ پروژه جاوا اسکریپتی مناسب بازار کار",
            "محمد حسین معین",
            R.drawable.javascr,
            299000,
            40,
            3,
            34,
            20,
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
                    "آموزش شغلی: با تکمیل این دوره و اجرای پروژه\u200Cهای مختلف، شما قادر خواهید بود تا به عنوان یک توسعه\u200Cدهنده جاوا اسکریپت وارد بازار کار شوید. این دوره به شما ابزارها، مفاهیم و تکنیک\u200Cهای لازم را در اختیار می\u200Cگذارد تا به عنوان یک حرفه\u200Cای در زمینه جاوا اسکریپت موفق عمل کنید.",
            "https://dl.daneshjooyar.com/mvie/Moein-Mohammad/other/%D9%88%DB%8C%D8%AF%DB%8C%D9%88-%D8%A7%D8%B5%D9%84%DB%8C.mp4"
        )
    )
    val topTicher = arrayOf(
        TopTicher(1, "استاد علیرضا احمدی", R.drawable.ali, "متخصص برنامه نویسی موبایل و مدرس"),
        TopTicher(2, "استاد حامد مودی", R.drawable.modi, "طراح و کدنویس افزونه و قالب وردپرس "),
        TopTicher(1, "استاد طاها اهوازی", R.drawable.taha, "برنامه نویس فول استک موبایل"),
    )
    val freePack = arrayOf(
        DataProduct(
            31,
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
            "در این آموزش قصد داریم تا یک فروشگاه اینترنتی را از صفر بوسیله افزونه ووکامرس پیاده سازی کنیم. پس از گذراندن دوره آموزش ووکامرس، شما قادر به پیاده سازی یک فروشگاه اینترنتی کاملا حرفه ای در سیستم مدیریت محتوای وردپرس خواهید بود. فروشگاهی که امکان ایجاد محصول، قیمت گذاری و رفتن به درگاه پرداخت را برای شما فراهم میکند. در این دوره آموزش طراحی سایت فروشگاهی با وردپرس از افزونه رسمی ووکامرس استفاده شده ولی شما قادر به پیاده سازی هر فروشگاهی با هر قالبی در وردپرس خواهید بود.",
            "https://dl.daneshjooyar.com/mvie/Ahmadi-Alireza/woo-free/S01-Part01-intro.mp4"
        ),
        DataProduct(
            32,
            "آموزش وردپرس رایگان(پروژه ساخت سایت خبری)",
            "",
            R.drawable.wordpres,
            0,
            0,
            11,
            426,
            64,
            arrayListOf(
                "آموزش نصب وردپرس بر روی لوکال هاست",
                "نحوه بروزرسانی وردپرس و افزونه ها",
                "نحوه انتشار نوشته ها در وردپرس",
                "دسته بندی کردن نوشته ها در وردپرس",
                "آموزش کار با برگه ها در وردپرس",
                "کار با قالب های وردپرس",
            ),
            "وردپرس یک سیستم مدیریت محتوای کاملا رایگان و متن باز است. شما با آموزش وردپرس رایگان، هر نوع وبسایتی را میتوانید پیاده سازی کنید. هر نوع؟ بله هر نوع وبسایتی! مثال بزنم؟ خوب همین وبسایت دانشجویار با وردپرس پیاده سازی شده. درسته که در دانشجویار کدنویسی اختصاصی انجام میشه (افزونه نویسی و قالب نویسی) اما در اصل موضوع که سایت بر روی سیستم وردپرس هست، تفاوتی ایجاد نمیکنه.\n" +
                    "\n" +
                    "پس با وردپرس میتونید سایت خبری، فروشگاهی، آموزشی، رزومه شخصی، شرکتی و حتی وبسایت هایی مشابه دیجی کالا، دیوار و باسلام رو ایجاد و پیاده سازی کنید. اما قبل از اینکه به فکر پیاده سازی بیوفتید، کمی صبر کنید. پیش از شروع هر کاری باید مهارت لازم رو کسب کرد. پس به دوره آموزش WordPress رایگان، خوش اومدین؛ جایی که قراره از نصب تا راه اندازی قالب خبری در وردپرس، بهتون آموزش داده بشه.",
            "https://dl.daneshjooyar.com/mvie/Ahmadi-Alireza/wordpress-free/S01-intro/S01-Part01-Intro.mp4"
        ),
        DataProduct(
            33,
            "آموزش گرامر زبان انگلیسی ( یادگیری از صفر )",
            "تینا ظهوری",
            R.drawable.gramer,
            0,
            0,
            0,
            0,
            0,
            arrayListOf(
                "گرامر حال ساده (Present Simple Tense)",
                "گرامر گذشته ساده (Past Simple Tense)",
                "گرامر آینده ساده با استفاده از will (Future Simple Tense)",
                "گرامر آینده ساده با استفاده از be going to (Future Simple Tense)",
                "گرامر حال استمراری (Present continuous Tense)",
            ),
            "دوره آموزش گرامر زبان انگلیسی یکی از مهم\u200Cترین واسطه\u200Cها در یادگیری زبان انگلیسی برای دانشجویان است. این دوره در راستای آموزش زبان انگلیسی، به دانشجویان امکان می\u200Cدهد تا قواعد و ساختارهای زبان انگلیسی را به طور جامع فرا بگیرند و توانایی خواندن، نوشتن، گفتار و شنیداری خود را بهبود بخشند.",
            "https://dl.daneshjooyar.com/mvie/Zohouri-Tina/english-1/Introduction.mp4"
        )

    )
    val cat = arrayOf(
        Category(1, R.drawable.sitecat, "طراحی سایت", 142),
        Category(2, R.drawable.andcat, "برنامه نویسی موبایل", 44),
        Category(3, R.drawable.danwshga, "دروس دانشگاهی", 24),
        Category(4, R.drawable.hosh, "هوش مصنوعی", 31),
        Category(5, R.drawable.windo, "برنامه نویسی ویندوز", 88),
        Category(6, R.drawable.pagadade, "پایگاه داده", 12),
        Category(7, R.drawable.shabakan, "شبکه", 17),
        Category(8, R.drawable.bazisazi, "بازی سازی", 22),
        Category(9, R.drawable.tarahi, "طراحی و گرافیک", 70),
        Category(10, R.drawable.electrinic, "آموزش الکترونیک", 42),
        Category(11, R.drawable.casbokar, "کسب و کار", 53),
        Category(12, R.drawable.oder, "نرم افزارهای کاربردی", 32),
    )
    Scaffold(
        containerColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.White,
                shape = CircleShape,
                onClick = {}) {
                Image(
                    painter = painterResource(id = R.drawable.posh),
                    contentDescription = "",
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
                TopProduct(text = "جدید ترین ها")
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
                        .background(Color(0xffd6a927))
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                        .wrapContentHeight()
                ) {
                    item { AmazingStart() }
                    itemsIndexed(loveitem) { index, item ->
                        AmazingItem(navController = navController, data = item)
                    }
                    item {
                        AmazingEnd(navController, Screen.PackGold.route, Screen.Home.route)
                    }
                }
            }
            item {
                CategoryHome(cat)
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                TopProduct(text = "محبوب ترین ها")
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


            item {
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    state = rememberLazyListState(),
                    reverseLayout = true,
                    modifier = Modifier
                        .background(dancolor)
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                        .wrapContentHeight()
                ) {

                    item { AmazingTicher() }
                    itemsIndexed(topTicher) { index, item ->
                        TopTicher(data = item)
                    }
                    item { AmazingEndTich(navController) }

                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                TopProduct(text = "دوره های رایگان")
                LazyRow(
                    reverseLayout = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp)
                        .wrapContentHeight()
                ) {
                    itemsIndexed(freePack) { index, item ->
                        FreeItem(data = item, navController)
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
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            painter = painterResource(id = R.drawable.topitem), contentDescription = "",
        )
        Spacer(modifier = Modifier.height(15.dp))

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
    }
}

@Composable
fun AmazingTicher() {
    Column(
        modifier = Modifier
            .width(190.dp)
            .clickable { }
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier
                .width(190.dp)
                .height(140.dp),
            painter = painterResource(id = R.drawable.besttich), contentDescription = "",
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            modifier = Modifier
                .width(170.dp)
                .height(120.dp),
            text = "مدرسین برتر",
            fontSize = 35.sp,
            color = Color.White,
            fontFamily = myFont,
            textAlign = TextAlign.Center
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
                    eeeee.value = 1
                    pack.value = true
                    ticher.value = false
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
fun AmazingEndTich(navController: NavHostController) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .width(180.dp)
            .height(399.dp)
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
                    eeeee.value = 0
                    pack.value = false
                    ticher.value = true
                    navController.navigate(Screen.PackGold.route) {
                        popUpTo(Screen.Home.route) {
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
        data.more,
        data.videoUrl
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
                    .background(Color(0x0F5A5959))
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
        R.drawable.s,
        R.drawable.s4,
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
            .height(250.dp),
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
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(400.dp, 250.dp)
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
fun TopProduct(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(0.5f),
        ) {
            TextButton(onClick = {
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
        data.more,
        data.videoUrl
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
            .height(310.dp)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = data.img), contentDescription = "",
                    Modifier
                        .width(270.dp)
                        .height(160.dp),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 4.dp), contentAlignment = Alignment.TopStart
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
                    fontFamily = myFont,
                    modifier = Modifier.fillMaxWidth(),

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreeItem(data: DataProduct, navController: NavHostController) {
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
        data.more,
        data.videoUrl
    )
    val gson = Gson()
    val itemstring = gson.toJson(zori)
    Card(
        onClick = {
            navController.navigate(Screen.InfoItemScreen.route + "?data=${itemstring}")
        },
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .width(285.dp)
            .height(300.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
        ) {
            Image(
                painter = painterResource(id = data.img), contentDescription = "",
                Modifier
                    .width(270.dp)
                    .padding(top = 5.dp)
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = data.title,
                fontFamily = myFont,
                fontSize = 16.sp,
                textAlign = TextAlign.End,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = data.nameTicher,
                fontFamily = myFont,
                fontSize = 15.sp,
                color = dancolor,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0x0F626060))
            )
            Text(
                text = "رایگان",
                fontFamily = myFont,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp),
                color = Color.Black
            )
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

@Composable
fun TopTicher(data: TopTicher) {
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .width(250.dp)
            .height(400.dp)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
        ) {
            Image(
                modifier = Modifier
                    .width(250.dp)
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryHome(data: Array<Category>) {
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "موضوعات کاربردی و منتخب", fontFamily = myFont,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
    )
    Spacer(modifier = Modifier.height(8.dp))
    FlowRow(
        maxItemsInEachRow = 3,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalArrangement = Arrangement.Center
    ) {
        for (item in data) {
            Catitem(data = item)
        }
        Spacer(modifier = Modifier.height(14.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Catitem(data: Category) {
    Card(
        onClick = {},
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth(0.32f)
            .padding(top = 13.dp)
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF8CBBEB),
                            Color.White,
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(data.img), contentDescription = "")
            Text(
                text = data.title,
                fontFamily = myFont,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = dancolor

                )

                Text(
                    text = "دوره",
                    fontFamily = myFont,
                    fontSize = 12.sp,
                    color = dancolor
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = data.number.toString(),
                    fontFamily = myFont,
                    fontSize = 14.sp,
                    color = dancolor
                )

            }

        }
    }
}

@Composable
fun MyNavigationDrawer(){

}