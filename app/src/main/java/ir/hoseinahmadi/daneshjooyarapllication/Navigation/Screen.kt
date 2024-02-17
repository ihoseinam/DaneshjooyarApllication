package ir.hoseinahmadi.daneshjooyarapllication.Navigation

sealed class Screen(
    val route: String,
) {
    object Splash : Screen("Splash_Screen")
    object Home : Screen("Home_Screen")

    object PackGold:Screen("packGod")
    object InfoItemScreen:Screen("Info_Screen")
    object ShopingCard:Screen("shoping_card")
    object MyProfile:Screen("my_profile")


}
