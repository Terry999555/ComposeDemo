package com.compose.demo.ui.me

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.demo.data.mockUser
import com.compose.demo.R

@Composable
fun MeScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(mockUser.avatar),
                        contentDescription = "头像",
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(mockUser.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "微信号: demo_${mockUser.name}", fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        item { HorizontalDivider(thickness = 8.dp, color = MaterialTheme.colorScheme.surfaceVariant) }

        item {
            MeItem(icon = R.mipmap.icon_pay, title = "支付")
            HorizontalDivider(modifier = Modifier.padding(start = 52.dp))
        }
        item {
            MeItem(icon = R.mipmap.icon_sc, title = "收藏")
            HorizontalDivider(modifier = Modifier.padding(start = 52.dp))
        }
        item {
            MeItem(icon = R.mipmap.icon_photo, title = "相册")
            HorizontalDivider(modifier = Modifier.padding(start = 52.dp))
        }
        item {
            MeItem(icon = R.mipmap.icon_card, title = "卡包")
            HorizontalDivider(modifier = Modifier.padding(start = 52.dp))
        }
        item {
            MeItem(icon = R.mipmap.icon_face, title = "表情")
            HorizontalDivider(modifier = Modifier.padding(start = 52.dp))
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }
        item { HorizontalDivider(thickness = 8.dp, color = MaterialTheme.colorScheme.surfaceVariant) }

        item {
            MeItem(icon = R.mipmap.icon_setting, title = "设置")
            HorizontalDivider(modifier = Modifier.padding(start = 52.dp))
        }
    }
}

@Composable
private fun MeItem(icon: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = icon
            ),
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(title, fontSize = 16.sp, modifier = Modifier.weight(1f))
        Text("›", fontSize = 20.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
