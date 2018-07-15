package com.example.dimi.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.dimi.R
import com.example.dimi.di.MainScreenComponent
import com.example.dimi.common.App
import com.example.dimi.common.di.MainProvider
import com.example.dimi.common.main.DrawerController
import com.example.dimi.common.main.FragmentNavigator
import com.example.dimi.common.main.Main
import com.example.dimi.firstfragment.DetailFragment
import com.example.dimi.secondfragment.PopularFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Main,
    FragmentNavigator, DrawerController {

    private val mainScreenComponent: MainScreenComponent by lazy {
        (application as App).getMainScreenComponent() as MainScreenComponent
    }

    override fun getMainScreenComponent(): MainProvider = mainScreenComponent

    override fun forward(data: Any, className: String?) {
        when (className) {
            PopularFragment::class.qualifiedName ->
                Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_popularFragment_to_detailFragment)
            else -> TODO()
        }
    }

    override fun back(className: String?) {
        when (className) {
            DetailFragment::class.qualifiedName ->
                Navigation.findNavController(this, R.id.fragment)
                    .popBackStack()
            else -> TODO()
        }
    }

    override fun openDrawer() {
        drawerLayout.openDrawer(Gravity.START)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainScreenComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationUI.setupWithNavController(
            navigationView,
            Navigation.findNavController(this, R.id.fragment)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) (application as App).clearMainScreenComponent()
    }
}
