package com.example.dimi.secondfragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dimi.common.BaseFragment
import com.example.dimi.common.Main
import com.example.dimi.common.Navigator
import com.example.dimi.secondfragment.di.PopularComponent
import kotlinx.android.synthetic.main.fragment_popular.*
import javax.inject.Inject

class PopularFragment : BaseFragment() {

    @Inject lateinit var navigator: Navigator

    private val detailComponent: PopularComponent by lazy {
        PopularComponent.init((activity as Main).getMainScreenComponent())
    }

    override val layoutId: Int
        get() = R.layout.fragment_popular

    override fun onCreate(savedInstanceState: Bundle?) {
        detailComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            navigator.forward(this@PopularFragment::class.qualifiedName)
        }
    }
}
