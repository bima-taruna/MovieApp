@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.bima.movieapp.presentation.components.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun DetailTabs(content:String,movieId:String,modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { tabsItem(content, movieId).size }
    )
    val coroutineScope = rememberCoroutineScope()
    Column (
        modifier = modifier
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
        ) {
            tabsItem(content, movieId).forEachIndexed { index, item ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = { Text(text = item.title, style = MaterialTheme.typography.titleMedium) },
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }
        HorizontalPager(
//            pageCount = tabsItem(content, movieId).size,
            state = pagerState
        ) {
            tabsItem(content, movieId)[pagerState.currentPage].screen()
        }
    }
}