package com.example.dimi.firstfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dimi.common.BaseFragment
import com.example.dimi.common.Main
import com.example.dimi.common.Navigator
import com.example.dimi.firstfragment.di.DetailComponent
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment : BaseFragment() {

    private val detailComponent: DetailComponent by lazy {
        DetailComponent.init((activity as Main).getMainScreenComponent())
    }

    @Inject
    lateinit var navigator: Navigator

    override val layoutId: Int
        get() = R.layout.fragment_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        detailComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
            .also {
               it?.findViewById<Toolbar>(R.id.toolbar)?.setNavigationIcon(R.drawable.ic_arrow_back)
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            navigator.back(this@DetailFragment::class.qualifiedName)
        }
    }
}
