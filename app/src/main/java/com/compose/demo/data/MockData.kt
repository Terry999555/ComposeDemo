package com.compose.demo.data

import com.compose.demo.R

data class ChatMessage(
    val id: Long,
    val senderName: String,
    val content: String,
    val time: String,
    val isMe: Boolean,
)

data class Chat(
    val id: Long,
    val name: String,
    val avatar: Int = R.mipmap.icon_avatar,
    val lastMessage: String,
    val time: String,
    val unreadCount: Int,
    val messages: List<ChatMessage> = emptyList(),
)

data class Contact(
    val id: Long,
    val name: String,
    val avatar: Int = R.mipmap.icon_avatar,
    val phone: String = "",
    val signature: String = "",
)

data class DiscoverItem(
    val id: Long,
    val title: String,
    val icon: Int = R.mipmap.icon_friends,
    val type: DiscoverType,
)

enum class DiscoverType { MOMENTS, SCAN, SHAKE, MINI_PROGRAM }

data class Moment(
    val id: Long,
    val userName: String,
    val avatar: Int = R.mipmap.icon_avatar,
    val content: String,
    val time: String,
    val likeCount: Int,
    val images: List<String> = emptyList(),
)

data class User(
    val name: String = "张三",
    val avatar: Int = R.mipmap.icon_avatar,
    val phone: String = "18888888888",
)

// ───── Mock Data ─────

val mockChats = listOf(
    Chat(1, "文件传输助手", R.mipmap.icon_avatar, "文件已发送", "12:30", 0),
    Chat(
        2, "Alice", R.mipmap.icon_avatar, "晚上一起吃饭？", "11:45", 2,
        messages = listOf(
            ChatMessage(1, "Alice", "今天天气真好", "10:00", false),
            ChatMessage(2, "张三", "是的，适合出去走走", "10:05", true),
            ChatMessage(3, "Alice", "晚上一起吃饭？", "11:45", false)
        )
    ),
    Chat(
        3, "Bob", R.mipmap.icon_avatar, "那个项目进度怎么样了", "昨天", 1,
        messages = listOf(
            ChatMessage(1, "Bob", "这个周末有空吗", "昨天 14:00", false),
            ChatMessage(2, "张三", "有空的，怎么安排", "昨天 14:30", true),
            ChatMessage(3, "Bob", "那个项目进度怎么样了", "昨天 15:00", false)
        )
    ),
    Chat(
        4, "技术交流群", R.mipmap.icon_avatar, "有人用过 Compose 吗", "昨天", 99,
        messages = listOf(
            ChatMessage(1, "小明", "有人用过 Compose 吗", "昨天 09:00", false),
            ChatMessage(2, "小红", "正在用，挺好用的", "昨天 09:05", false),
            ChatMessage(3, "张三", "+1，声明式 UI 确实香", "昨天 09:10", true)
        )
    ),
    Chat(
        5, "Charlie", R.mipmap.icon_avatar, "周末打篮球吗", "周一", 0,
        messages = listOf(
            ChatMessage(1, "Charlie", "周末打篮球吗", "周一 16:00", false),
            ChatMessage(2, "张三", "好，老地方", "周一 16:30", true)
        )
    ),
    Chat(6, "Diana", R.mipmap.icon_avatar, "合同已发邮箱", "周一", 0),
    Chat(7, "产品需求群", R.mipmap.icon_avatar, "@所有人 明天开会", "周日", 5),
    Chat(
        8, "Eve", R.mipmap.icon_avatar, "生日快乐！", "上周五", 0,
        messages = listOf(
            ChatMessage(1, "Eve", "生日快乐！", "上周五 08:00", false),
            ChatMessage(2, "张三", "谢谢！", "上周五 08:05", true)
        )
    ),
    Chat(9, "Frank", R.mipmap.icon_avatar, "OK", "上周四", 0),
    Chat(10, "Grace", R.mipmap.icon_avatar, "照片收到了", "上周三", 0)
)

val mockContacts = listOf(
    Contact(1, "Alice", R.mipmap.icon_avatar, "13900139000", "生活不止眼前的苟且"),
    Contact(2, "Bob", R.mipmap.icon_avatar, "13900139001", "代码改变世界"),
    Contact(3, "Charlie", R.mipmap.icon_avatar, "13900139002", "天天向上"),
    Contact(4, "Diana", R.mipmap.icon_avatar, "13900139003", "保持热爱"),
    Contact(5, "Eve", R.mipmap.icon_avatar, "13900139004", "一路向北"),
    Contact(6, "Frank", R.mipmap.icon_avatar, "13900139005", "Stay hungry"),
    Contact(7, "Grace", R.mipmap.icon_avatar, "13900139006", "顺其自然"),
    Contact(8, "Henry", R.mipmap.icon_avatar, "13900139007", "知行合一"),
    Contact(9, "Ivy", R.mipmap.icon_avatar, "13900139008", "未来可期"),
    Contact(10, "Jack", R.mipmap.icon_avatar, "13900139009", "心之所向")
)

val mockDiscoverItems = listOf(
    DiscoverItem(1, "朋友圈", R.mipmap.icon_friends, DiscoverType.MOMENTS),
    DiscoverItem(2, "扫一扫", R.mipmap.icon_scan, DiscoverType.SCAN),
    DiscoverItem(3, "摇一摇", R.mipmap.icon_shake, DiscoverType.SHAKE),
    DiscoverItem(4, "小程序", R.mipmap.icon_mini_program, DiscoverType.MINI_PROGRAM)
)

val mockMoments = listOf(
    Moment(1, "Alice", R.mipmap.icon_avatar, "周末去了趟西湖，风景真不错！", "今天 09:30", 12, listOf("🏞️", "🌅")),
    Moment(2, "Bob", R.mipmap.icon_avatar, "Compose 写得越来越顺手了", "昨天 15:20", 28),
    Moment(3, "Charlie", R.mipmap.icon_avatar, "推荐一家很好吃的火锅店 🍲", "昨天 12:00", 45, listOf("🍲", "🥩")),
    Moment(4, "Diana", R.mipmap.icon_avatar, "新项目上线，加班中 😂", "前天 21:00", 8),
    Moment(5, "Eve", R.mipmap.icon_avatar, "生日快乐！谢谢大家的祝福 🎂", "前天 10:00", 56, listOf("🎂"))
)

val mockUser = User()
