package com.example.cinefacil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinefacil.ui.theme.CineFacilTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CineFacilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun MovieTitle(movieTitle: String, modifier: Modifier = Modifier){
    Row(
        horizontalArrangement  =  Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
        Icons.Default.ArrowBack,
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier.size(24.dp)
    )
        Text(
            text = movieTitle,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(all = 16.dp),
            color = Color.White
        )
    }
}
@Composable
fun MovieBanner(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.saw_poster)
    Column(
        Modifier.fillMaxWidth().
        padding(16.dp),
        verticalArrangement = Arrangement.Center,

    ){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
        )
    }
}
@Composable
fun MovieDescription(movieDescription: String, modifier: Modifier = Modifier){
    Text(
        text = movieDescription,
        modifier = modifier.padding(start = 16.dp, end = 16.dp ),
        textAlign = TextAlign.Justify,
        color = Color.White
    )
}
@Composable
fun MovieImages(modifier: Modifier = Modifier){
    val firstImage = painterResource(id = R.drawable.jigsaw)
    val secondImage = painterResource(id = R.drawable.kramer)
    Row(
        modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement  =  Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = secondImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Image(
            painter = firstImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))

        )
    }
}

@Composable
fun OptionsMenu(modifier: Modifier = Modifier){
    Row(
        modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement  =  Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.Default.Home,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            Icons.Default.Search,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            Icons.Default.Person,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            Icons.Default.List,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
    }
}
@Composable
fun MovieView(modifier: Modifier = Modifier){
   Column (
       verticalArrangement = Arrangement.Center,
       modifier = modifier
           .padding(8.dp)
           .background(Color.Black)
   ){
        MovieTitle(stringResource(id = R.string.movie_title))
        MovieBanner()
        MovieDescription(stringResource(id = R.string.movie_description))
        MovieImages()
        OptionsMenu()
   }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CineFacilTheme {
        MovieView()
    }
}