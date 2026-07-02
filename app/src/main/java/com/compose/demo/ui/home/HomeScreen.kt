package com.compose.demo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.demo.R
import com.compose.demo.ui.chat.ChatListScreen
import com.compose.demo.ui.contacts.ContactsScreen
import com.compose.demo.ui.discover.DiscoverScreen
import com.compose.demo.ui.me.MeScreen

private enum class Tab(
    val label: String,
    val selectedIconRes: Int,
    val unselectedIconRes: Int
) {
    CHAT("微信", R.mipmap.icon_wx_select, R.mipmap.icon_wx_unselect),
    CONTACTS("通讯录", R.mipmap.icon_txl_select, R.mipmap.icon_txl_unselect),
    DISCOVER("发现", R.mipmap.icon_find_select, R.mipmap.icon_find_unselect),
    ME("我的", R.mipmap.icon_mine_select, R.mipmap.icon_mine_unselect)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onChatClick: (Long) -> Unit,
    onContactClick: (Long) -> Unit,
    onMomentClick: (Long) -> Unit
) {
    var selectedTab by remember { mutableStateOf(Tab.CHAT) }
    val tabTitle = when (selectedTab) {
        Tab.CHAT -> "微信"
        Tab.CONTACTS -> "通讯录"
        Tab.DISCOVER -> "发现"
        Tab.ME -> "我的"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(tabTitle, fontWeight = FontWeight.Medium) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        },
        bottomBar = {
            NavigationBar {
                Tab.entries.forEach { tab ->
                    val selected = selectedTab == tab
                    NavigationBarItem(
                        selected = selected,
                        onClick = { selectedTab = tab },
                        icon = {
                            Image(
                                painter = painterResource(
                                    id = if (selected) tab.selectedIconRes else tab.unselectedIconRes
                                ),
                                contentDescription = tab.label,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = {
                            Text(
                                tab.label,
                                fontSize = 11.sp,
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Unspecified,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = Color.Unspecified,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            indicatorColor = Color.Transparent
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                Tab.CHAT -> ChatListScreen(onChatClick = onChatClick)
                Tab.CONTACTS -> ContactsScreen(onContactClick = onContactClick)
                Tab.DISCOVER -> DiscoverScreen(onMomentClick = onMomentClick)
                Tab.ME -> MeScreen()
            }
        }
    }
}
