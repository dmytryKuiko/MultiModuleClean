package com.example.dimi.secondfragment.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.dimi.secondfragment.model.MovieDisplayable
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate

class PopularMovieAdapter : AdapterDelegate<MutableList<MovieDisplayable>>(){
    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isForViewType(items: MutableList<MovieDisplayable>, position: Int): Boolean =
        items[position] is MovieDisplayable.Movie

    override fun onBindViewHolder(
        items: MutableList<MovieDisplayable>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}