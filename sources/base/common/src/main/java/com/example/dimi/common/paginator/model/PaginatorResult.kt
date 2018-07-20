package com.example.dimi.common.paginator.model

class PaginatorResult<T>(
    val viewState: ViewState = ViewState.DATA,
    val paginatorModelData: PaginatorData<T>? = null
)