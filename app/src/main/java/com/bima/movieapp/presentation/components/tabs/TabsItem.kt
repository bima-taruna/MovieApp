package com.bima.movieapp.presentation.components.tabs

import com.bima.movieapp.domain.model.TabItem
import com.bima.movieapp.presentation.components.Overview

fun tabsItem(content:String, movieId:String): List<TabItem> {
    return listOf(
        TabItem(
            title = "Overview",
            screen = { Overview(content = content) }
        ),
        TabItem(
            title = "Reviews",
            screen = { ReviewTabs(movieId = movieId) }
        ),
        TabItem(
            title = "Cast",
            screen = { CastTabs( movieId = movieId) }
        )
    )
}