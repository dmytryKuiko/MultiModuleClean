package com.example.dimi.secondfragment.adapter

import android.support.v7.recyclerview.extensions.AsyncListDiffer
import com.example.dimi.secondfragment.model.MovieDisplayable
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

class PopularAdapter : ListDelegationAdapter<MutableList<MovieDisplayable>>() {

    private val asyncListDiffer: AsyncListDiffer<MovieDisplayable> =
        AsyncListDiffer(this, DiffUtilCallbackMovie())

    init {
        items = mutableListOf()
        delegatesManager.addDelegate(PopularMovieAdapter())
            .addDelegate(PopularErrorAdapter())
            .addDelegate(PopularLastAdapter())
            .addDelegate(PopularLoadingAdapter())
    }
}