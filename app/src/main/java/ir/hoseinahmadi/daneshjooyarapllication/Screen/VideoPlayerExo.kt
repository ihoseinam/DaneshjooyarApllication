package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayerExo(
    videoUrl: String,
) {
    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build().apply {
        setMediaItem(MediaItem.fromUri(videoUrl))
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
            player.release()
            player.stop()
        }
    }

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(15.dp)),
        factory = {
            playerView
        })

}