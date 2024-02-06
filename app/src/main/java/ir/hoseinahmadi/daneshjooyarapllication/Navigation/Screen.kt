package ir.hoseinahmadi.daneshjooyarapllication.Navigation

sealed class Screen(
    val route: String,
) {
    object Splash : Screen("Splash_Screen")
    object Home : Screen("Home_Screen")
    object Category:Screen("cat")
    object PackGold:Screen("packGod")
    object MyPack:Screen("myPack")
    object InfoItemScreen:Screen("Info_Screen")
    object ShopingCard:Screen("shoping_card")


}
