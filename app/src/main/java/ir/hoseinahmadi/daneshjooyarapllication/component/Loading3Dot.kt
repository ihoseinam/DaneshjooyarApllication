package ir.hoseinahmadi.daneshjooyarapllication.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.hoseinahmadi.daneshjooyarapllication.R

@Composable
fun Loading3Dot(){
val composetion by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading3dotsdark))
    LottieAnimation(composition = composetion,
        iterations = LottieConstants.IterateForever
        )
}