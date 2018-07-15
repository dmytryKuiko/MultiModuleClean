package com.example.dimi.firstfragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.dimi.common.BaseFragment
import com.example.dimi.common.main.DrawerController
import com.example.dimi.common.main.FragmentNavigator
import com.example.dimi.common.main.Main
import com.example.dimi.common.main.MainPresenter
import com.example.dimi.firstfragment.di.DetailComponent
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment : BaseFragment() {

    private val detailComponent: DetailComponent by lazy {
        DetailComponent.init((activity as Main).getMainScreenComponent())
    }

    private var navigator: FragmentNavigator? = null

    @Inject lateinit var mainPresenter: MainPresenter

    override val layoutId: Int
        get() = R.layout.fragment_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        detailComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageButton>(R.id.icon_left).setImageResource(R.drawable.ic_arrow_back)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigator && context is DrawerController) navigator = context
        else throw RuntimeException(context.toString() + " must implement FragmentNavigator")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            navigator?.back(this@DetailFragment::class.qualifiedName)
        }

        view?.findViewById<ImageButton>(R.id.icon_left)?.setOnClickListener {
            navigator?.back(this@DetailFragment::class.qualifiedName)
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigator = null
    }
}
