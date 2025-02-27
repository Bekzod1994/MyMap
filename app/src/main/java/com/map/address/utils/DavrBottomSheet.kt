package com.map.address.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheet(
    onDismiss: () -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(),
    shape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    containerColor: Color = Color.White,
    title: String = "",
    titleContentColor: Color? = null,
    titleHeight: Dp = 76.dp,
    titleColor: Color = Color.Black,
    titleStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    textAlign: TextAlign = TextAlign.Start,
    horizontalPadding: Dp = 16.dp,
    maxLines: Int = 1,
    sheetContent: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        modifier = Modifier.statusBarsPadding(),
        onDismissRequest = {
            scope.launch { sheetState.hide() }
                .invokeOnCompletion { onDismiss() }
        },
        sheetState = sheetState,
        shape = shape,
        containerColor = containerColor,
        dragHandle = {
            Column(
                modifier = Modifier
                    .background(titleContentColor ?: containerColor)
                    .fillMaxWidth()
                    .height(titleHeight),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .height(4.dp)
                        .width(32.dp)
                        .background(
                            Color.White,
                            RoundedCornerShape(CornerSize(2.dp))
                        )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalPadding),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (textAlign == TextAlign.Center) {
                        Spacer(modifier = Modifier.width(48.dp))
                    }
                    Text(
                        modifier = Modifier.weight(1f),
                        text = title,
                        color = titleColor,
                        style = titleStyle,
                        textAlign = textAlign,
                        maxLines = maxLines,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

        }) {
        sheetContent()
    }
}