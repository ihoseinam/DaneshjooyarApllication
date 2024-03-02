package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FaveViewModel
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FavoriteTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopViewModel
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun InfoItem(navController: NavHostController, data: Int?) {
    val allProduct = arrayOf<DataProduct>(
        DataProduct(
            1,
            "جامع ترین دوره آموزش برنامه نویسی اندروید (کاتلین، فلاتر و جاوا)",
            "علیرضا احمدی",
            "https://www.daneshjooyar.com/wp-content/uploads/2023/08/android-1-min-1-400x225.jpg",
            6900000,
            60,
            150,
            815,
            350,
            arrayListOf(
                "آموزش راه اندازی اندروید استودیو",
                "آموزش برنامه نویسی با کمکهوش مصنوعی",
                "آموزش فلاتر و جاوا جهت تکمیل رزومه",
                "ایجاد اپلیکیشن نمایش قیمت ارز و طلا ",
                "اعتبارسنجی و احراز هویت کاربران با ایمیل",
                "آموزش تخصصی ارتباط با سرور ",
                "دریافت مدرک طلایی قابل استعلام ",
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
            "https://www.daneshjooyar.com/wp-content/uploads/2023/05/wordpress-min-min-400x225.jpg",
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
        DataProduct(
            11,
            "آموزش ساخت خزنده وب با پایتون (خزش در صفحات دیجی کالا)",
            "علی رستمی",
            "https://www.daneshjooyar.com/wp-content/uploads/2023/01/python.png",
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
            "https://www.daneshjooyar.com/wp-content/uploads/2024/01/java-2-min-400x225.jpg",
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
            "https://www.daneshjooyar.com/wp-content/uploads/2023/11/js-1-min-400x225.png",
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
        ),

        //free
        DataProduct(
            31,
            "آموزش ووکامرس رایگان | ایجاد سایت فروشگاهی با وردپرس",
            "علیرضا احمدی",
            "https://www.daneshjooyar.com/wp-content/uploads/2024/02/woocommerce-min-400x225.png",
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
            "علیرضا احمدی",
            "https://www.daneshjooyar.com/wp-content/uploads/2023/12/Wordpress-min-511x312.png",
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
            "https://www.daneshjooyar.com/wp-content/uploads/2023/12/Grammar-min-400x225.png",
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
    val product = allProduct.find { it.id == data }
    val ee = (product!!.priceOr * product.darsad) / 100
    val b = product.priceOr - ee
    val fave = FavoriteTable(
        product!!.id,
        product.title,
        b,
        product.img,
        product.nameTicher
    )
    val viewModel = viewModel(ShopViewModel::class.java)
    val viewMode2 = viewModel(FaveViewModel::class.java)
    Scaffold(
        topBar = {
            MyTop(navController, fave, viewMode2)
        },
        bottomBar = {
            MyBottomBar(product, viewModel)
        },
        floatingActionButton = {}
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
        ) {
            item {
                infoPack(product)
            }
            item {
                Text(
                    text = "قراره تو این دوره چی یاد بگیرم؟",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = myFont,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                )
            }
            itemsIndexed(product!!.info) { index, item ->
                chiYad(text = item)
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(dancolor)
                        .wrapContentHeight()
                        .padding(5.dp)
                ) {
                    Text(
                        text = "درباره این پکیج آموزشی",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF505A94))
                            .padding(5.dp),
                        textAlign = TextAlign.End,
                        fontFamily = myFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        text = product!!.more, textAlign = TextAlign.End,
                        fontFamily = myFont,
                        color = Color.White
                    )
                }
            }
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(navController: NavHostController, item: FavoriteTable, viewModel: FaveViewModel) {
    var checkState by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true) {
        viewModel.checkProduct(item.id).collect {
            checkState = it
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconToggleButton(checked = checkState,
                onCheckedChange = {
                    checkState = !checkState
                    if (checkState) {
                        viewModel.addNewProduct(item)
                    } else {
                        viewModel.deleteProduct(item)
                    }

                })
            {
                if (checkState) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = "",
                        Modifier.size(30.dp),
                        tint = Color.Red
                    )
                } else {
                    Icon(
                        Icons.Rounded.FavoriteBorder, contentDescription = "",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.padding(start = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "مشخصات محصول", fontFamily = myFont,
                fontSize = 20.sp,
                color = Color.Black
            )
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Default.Close, contentDescription = "",
                    tint = Color.Black
                )
            }

        }


    }


}

@Composable
fun MyBottomBar(data: DataProduct, viewModel: ShopViewModel) {
    var check by remember {
        mutableStateOf(false)
    }
    BottomAppBar(
        containerColor = Color.White,
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.CenterVertically),
        tonalElevation = 15.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val priceortakh = darsadfun(data.priceOr, data.darsad)
            Column(
                Modifier
                    .weight(0.4f)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    val zori = String.format("%,d", data.priceOr)
                    Text(
                        text = zori,
                        fontFamily = myFont,
                        fontSize = 13.sp,
                        color = Color.Red,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        modifier = Modifier
                            .width(27.dp)
                            .background(
                                Color(0xFFFF0000),
                                shape = CircleShape
                            ),
                        text = "${data.darsad}%",
                        color = Color.White,
                        fontFamily = myFont,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.toman), contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = priceortakh,
                        fontSize = 21.sp,
                        fontFamily = myFont,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

            }

            Row(
                Modifier.weight(0.6f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                val ee = (data.priceOr * data.darsad) / 100
                val b = data.priceOr - ee
                LaunchedEffect(true) {
                    viewModel.chekedProduct(data.id).collect {
                        withContext(Dispatchers.Main) {
                            check = it
                        }
                    }
                }
                AnimatedVisibility(!check) {
                    Button(
                        modifier = Modifier.padding(start = 5.dp),
                        onClick = {
                            val eee = ShopTable(
                                data.id,
                                data.title,
                                b,
                                data.img,
                                data.nameTicher
                            )
                            viewModel.addNewProduct(eee)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff08c056),
                            contentColor = Color.White,
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "افزودن به سبد خرید",
                            fontFamily = myFont,
                            fontSize = 17.sp,
                            color = Color.White
                        )
                    }
                }
                AnimatedVisibility(check) {
                    Row(
                        Modifier.padding(end = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = {
                            val tt = ShopTable(data.id, "", 0, "", "")
                            viewModel.deleteProduct(tt)
                        }
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_delete),
                                contentDescription = "",
                                tint = Color.Red,
                                modifier = Modifier.size(35.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            style = TextStyle(textDirection = TextDirection.Rtl),
                            text = "موجود در سبد خرید",
                            fontFamily = myFont,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF1100)
                        )
                    }

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

@Composable
fun chiYad(text: String) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 7.dp, bottom = 7.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontFamily = myFont
            )
            Spacer(modifier = Modifier.width(3.dp))
            Icon(
                Icons.Default.CheckCircle, contentDescription = "",
                tint = dancolor,
                modifier = Modifier.size(30.dp)
            )

        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun infoPack(data: DataProduct) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .background(dancolor),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        val e = data.videoUrl
        val context = LocalContext.current
        val player = ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(e))
        }
        val playerView = PlayerView(context)
        val playWhenReady by rememberSaveable {
            mutableStateOf(false)
        }
        playerView.player = player

        LaunchedEffect(player) {
            player.prepare()
            player.playWhenReady = playWhenReady
        }
        DisposableEffect(player) {
            onDispose {
                player.stop()
                player.release()
            }
        }
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(3.dp)
                .clip(RoundedCornerShape(15.dp)),
            factory = {
                playerView
            })

        Text(
            text = data.title,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            fontFamily = myFont,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(end = 8.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = data.nameTicher,
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            fontFamily = myFont,
            modifier = Modifier
                .padding(end = 8.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF5365C2)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = " ${data.Houre} :ساعت",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = myFont,
            )
            Text(
                text = " ${data.jalase}:جلسه",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = myFont,
            )
            Text(
                text = "${data.student} :دانشجو ",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = myFont,
            )
        }
    }
}
