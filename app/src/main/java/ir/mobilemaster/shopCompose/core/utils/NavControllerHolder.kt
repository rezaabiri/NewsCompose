package ir.mobilemaster.shopCompose.core.utils

import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavControllerHolder @Inject constructor() {
    var navController: NavController? = null
}
