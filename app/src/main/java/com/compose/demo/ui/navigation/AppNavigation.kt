package com.compose.demo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.compose.demo.ui.splash.SplashScreen
import com.compose.demo.ui.login.LoginScreen
import com.compose.demo.ui.home.HomeScreen
import com.compose.demo.ui.chat.ChatDetailScreen
import com.compose.demo.ui.contacts.ContactDetailScreen
import com.compose.demo.ui.discover.MomentDetailScreen

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val HOME = "home"
    const val CHAT_DETAIL = "chat_detail/{chatId}"
    const val CONTACT_DETAIL = "contact_detail/{contactId}"
    const val MOMENT_DETAIL = "moment_detail/{momentId}"

    fun chatDetail(chatId: Long) = "chat_detail/$chatId"
    fun contactDetail(contactId: Long) = "contact_detail/$contactId"
    fun momentDetail(momentId: Long) = "moment_detail/$momentId"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen(
                onChatClick = { chatId ->
                    navController.navigate(Routes.chatDetail(chatId))
                },
                onContactClick = { contactId ->
                    navController.navigate(Routes.contactDetail(contactId))
                },
                onMomentClick = { momentId ->
                    navController.navigate(Routes.momentDetail(momentId))
                }
            )
        }

        composable(
            Routes.CHAT_DETAIL,
            arguments = listOf(navArgument("chatId") { type = NavType.LongType })
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getLong("chatId") ?: 0L
            ChatDetailScreen(
                chatId = chatId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            Routes.CONTACT_DETAIL,
            arguments = listOf(navArgument("contactId") { type = NavType.LongType })
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getLong("contactId") ?: 0L
            ContactDetailScreen(
                contactId = contactId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            Routes.MOMENT_DETAIL,
            arguments = listOf(navArgument("momentId") { type = NavType.LongType })
        ) { backStackEntry ->
            val momentId = backStackEntry.arguments?.getLong("momentId") ?: 0L
            MomentDetailScreen(
                momentId = momentId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
