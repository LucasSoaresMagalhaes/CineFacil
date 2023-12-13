package com.example.cinefacil.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinefacil.R
import com.example.cinefacil.navigation.BottomNavigationItem
import com.example.cinefacil.ui.theme.SourceSansPro
import com.example.cinefacil.util.TestTags

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavigationItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier.height(dimensionResource(id = R.dimen.bottom_navigation_height)),
        backgroundColor = Color.Black,
        elevation = 4.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            val testTag =
                if (item.icon == R.drawable.ic_home) TestTags.HOME_ICON else TestTags.FAVORITES_ICON
            BottomNavigationItem(
                modifier = Modifier.testTag(testTag),
                selected = selected,
                selectedContentColor = Color.Yellow,
                unselectedContentColor = Color.LightGray,
                onClick = { onItemClick(item) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = stringResource(id = item.name)
                        )
                        if (selected) {
                            Text(
                                text = stringResource(id = item.name),
                                style = TextStyle(
                                    color = Color.Yellow,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp,
                                    fontFamily = SourceSansPro
                                )
                            )
                        }
                    }
                }
            )
        }
    }
}