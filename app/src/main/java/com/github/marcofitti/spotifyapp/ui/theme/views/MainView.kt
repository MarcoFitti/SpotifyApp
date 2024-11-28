package com.github.marcofitti.spotifyapp.ui.theme.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.marcofitti.spotifyapp.R


data class Categories(
    @DrawableRes
    val icon: Int,
    val name: String,
    val route : String
)

val categories = listOf<Categories>(
    Categories(R.drawable.artists, "Artists", "artists"),
    Categories(R.drawable.album, "Albums", "albums"),
    Categories(R.drawable.songs, "Songs", "songs")
)

@Composable
fun CategoryItem(
    cat : Categories,
    onClick : (String) -> Unit
) {
    Column() {
        Row(
            modifier = Modifier
                .clickable {

                }
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                painter = painterResource(id = cat.icon),
                modifier = Modifier.padding(horizontal = 8.dp),
                contentDescription = cat.name
            )

            Text(text = cat.name)

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Go to"
            )
        }

        Divider()
    }
}


@Composable
fun Library(navController: NavController) {


    LazyColumn() {
        items(categories) { cat ->
            CategoryItem(cat = cat,
                onClick = { route ->
                    navController.navigate(route)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LibraryPreview(){
    Library(navController = rememberNavController())
}




