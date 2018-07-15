package com.example.dimi

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.dimi.common.Coordinator
import com.example.dimi.common.Navigator
import com.example.dimi.secondfragment.PopularFragment
import javax.inject.Inject

class NavigatorImpl
@Inject constructor(private val activity: Activity) : Navigator {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity, R.id.fragment)
    }

    override fun forward(className: String?) {
        when (className) {
            PopularFragment::class.qualifiedName -> 
                navController.navigate(R.id.action_popularFragment_to_detailFragment)
            else -> TODO()
        }
    }

    override fun back(className: String?) {
        navController.popBackStack()
    }
}