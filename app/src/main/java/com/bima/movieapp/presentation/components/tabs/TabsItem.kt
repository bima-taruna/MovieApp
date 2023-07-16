package com.bima.movieapp.presentation.components.tabs

import com.bima.movieapp.domain.model.TabItem
import com.bima.movieapp.presentation.components.Overview

fun tabsItem(content:String): List<TabItem> {
    return listOf(
        TabItem(
            title = "Overview",
            screen = { Overview(content = content) }
        ),
        TabItem(
            title = "Reviews",
            screen = { Overview(content = content) }
        ),
        TabItem(
            title = "Cast",
            screen = { Overview(content = content) }
        )
    )
}