package ir.hoseinahmadi.daneshjooyarapllication.dataClas

data class DataProduct(
    val id:Int,
    val title :String,
    val nameTicher :String,
    val img :Int,
    val priceOr:Int,
    val darsad :Int =0,
    val Houre :Int,
    val student :Int,
    val jalase :Int,
    val info :ArrayList<String>,
    val more:String="",
    val videoUrl:String="",
)
