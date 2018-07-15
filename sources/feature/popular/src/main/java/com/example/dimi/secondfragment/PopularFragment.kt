package com.example.dimi.secondfragment


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.dimi.common.BaseFragment
import com.example.dimi.common.main.DrawerController
import com.example.dimi.common.main.FragmentNavigator
import com.example.dimi.common.main.Main
import com.example.dimi.common.main.MainPresenter
import com.example.dimi.secondfragment.di.PopularComponent
import kotlinx.android.synthetic.main.fragment_popular.*
import javax.inject.Inject

class PopularFragment : BaseFragment() {

    private val detailComponent: PopularComponent by lazy {
        PopularComponent.init((activity as Main).getMainScreenComponent())
    }

    private var navigator: FragmentNavigator? = null

    private var drawerController: DrawerController? = null

    override val layoutId: Int
        get() = R.layout.fragment_popular

    @Inject lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        detailComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigator && context is DrawerController) {
            navigator = context
            drawerController = context
        }
        else throw RuntimeException(context.toString() + " must implement FragmentNavigator")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            navigator?.forward(1, this@PopularFragment::class.qualifiedName)
        }
        view?.findViewById<ImageButton>(R.id.icon_left)?.setOnClickListener {
            drawerController?.openDrawer()
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigator = null
        drawerController = null
    }
}
