package com.bamboodroid.composelearning.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.transform.CircleCropTransformation
import com.bamboodroid.composelearning.R
import com.bamboodroid.composelearning.ui.theme.Blue600
import com.bamboodroid.composelearning.ui.theme.Gray100
import com.bamboodroid.composelearning.ui.theme.Gray400
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun Home(homeViewModel: HomeViewModel = viewModel()) {
    val selectedTab: BottomTabs by homeViewModel.selectedTab.observeAsState(BottomTabs.CHATS)
    val profileImageUrl: String by homeViewModel.userProfileImageUrl.observeAsState("")
    Scaffold(
        topBar = { TopBar(profileImageUrl, selectedTab, homeViewModel::createNewChat) },
        bottomBar = { BottomNavigationBar(selectedTab, homeViewModel::selectTab) }
    ) {

    }
}

@Composable
fun BottomNavigationBar(selectedTabs: BottomTabs, onTabClicked: (BottomTabs) -> Unit) {
    BottomNavigation(
        backgroundColor = Gray100,
        elevation = 4.dp
    ) {
        BottomTabs.values().forEach { tab ->
            BottomNavigationItem(
                selected = selectedTabs == tab,
                onClick = {
                    onTabClicked(tab)
                },
                label = { Text(text = tab.tabName) },
                alwaysShowLabel = true,
                selectedContentColor = Blue600,
                unselectedContentColor = Gray400,
                icon = {
                    Icon(
                        painter = painterResource(id = tab.iconRes),
                        contentDescription = tab.tabName
                    )
                }
            )
        }
    }
}

@Composable
fun TopBar(profileUrl: String, selectedTabs: BottomTabs, onCreateChatClick: () -> Unit) {
    TopAppBar(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Gray100, Color.White),
                    startY = 0f,
                    endY = 1f
                )
            ),
        backgroundColor = Gray100,
        elevation = 0.dp,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
    ) {
        val titleText = if (selectedTabs == BottomTabs.CHATS) "Chats" else "Friends"
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = rememberCoilPainter(
                    request = profileUrl,
                    previewPlaceholder = R.drawable.ic_people,
                    fadeIn = true,
                    requestBuilder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = profileUrl,
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = titleText,
                modifier = Modifier
                    .padding(PaddingValues(4.dp))
                    .weight(1f, fill = true),
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            if (selectedTabs == BottomTabs.CHATS) {
                Icon(
                    Icons.Outlined.Create,
                    tint = Blue600,
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                        .clickable(onClick = onCreateChatClick)
                )
            } else {
                Spacer(modifier = Modifier.size(30.dp, 30.dp))
            }
        }
    }
}

@Composable
fun MainContent(selectedTabs: BottomTabs) {
    if (selectedTabs == BottomTabs.CHATS) {

    } else {

    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(profileUrl = "", selectedTabs = BottomTabs.CHATS) {}
}

@Preview
@Composable
fun PreviewHome() {
    val selectedTab: BottomTabs by remember {
        mutableStateOf(BottomTabs.CHATS)
    }
    Scaffold(
        topBar = { TopBar("", selectedTab) {} },
        bottomBar = {
            BottomNavigationBar(selectedTab) {

            }
        }
    ) {

    }
}