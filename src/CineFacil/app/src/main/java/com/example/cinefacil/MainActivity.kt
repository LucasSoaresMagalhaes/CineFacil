package com.example.cinefacil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinefacil.ui.theme.CineFacilTheme
import com.example.cinefacil.model.Serie


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
                    LoginApp()
                }
            }
        }
    }
}

@Composable
fun MovieTitle(movieTitle: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
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
fun MovieBanner(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.saw_poster)
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

        ) {
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
fun MovieDescription(movieDescription: String, modifier: Modifier = Modifier) {
    Text(
        text = movieDescription,
        modifier = modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify,
        color = Color.White
    )
}

@Composable
fun MovieImages(modifier: Modifier = Modifier) {
    val firstImage = painterResource(id = R.drawable.jigsaw)
    val secondImage = painterResource(id = R.drawable.kramer)
    Row(
        modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
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
fun OptionsMenu(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
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
fun MovieView(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .background(Color.Black)
    ) {
        MovieTitle(stringResource(id = R.string.movie_title))
        MovieBanner()
        MovieDescription(stringResource(id = R.string.movie_description))
        MovieImages()
        OptionsMenu()
    }
}


//Login
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        value = value,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions
    )
}


@Composable
fun LoginApp(modifier: Modifier = Modifier) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 190.dp, end = 200.dp)
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(id = R.string.login_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(all = 16.dp),
                color = Color.White
            )
        }
        EditTextField(
            label = R.string.email_input,
            leadingIcon = R.drawable.baseline_account_circle_black_24dp,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = login,
            onValueChanged = { login = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),

        )
        EditTextField(
            label = R.string.password_input,
            leadingIcon = R.drawable.baseline_lock_black_24dp,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = password,
            onValueChanged = { password = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(150.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier.size(width = 150.dp, height = 60.dp)
        ) {
            Text(
                stringResource(R.string.login_button),
                color = Color.Black,
            )
        }
    }
}





//SignUp
@Composable
fun SignUpApp(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 200.dp)
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(id = R.string.signup_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(all = 16.dp),
                color = Color.White
            )
        }
        Text(
            text = stringResource(R.string.signup_description),
               
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
        )
        EditTextField(
            label = R.string.signup_name,
            leadingIcon = R.drawable.baseline_account_circle_black_24dp,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = name,
            onValueChanged = { name = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),

            )
        EditTextField(
            label = R.string.signup_telephone,
            leadingIcon = R.drawable.baseline_account_circle_black_24dp,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = telephone,
            onValueChanged = { telephone = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),

            )
        EditTextField(
            label = R.string.signup_email,
            leadingIcon = R.drawable.baseline_account_circle_black_24dp,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = email,
            onValueChanged = { email = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),

            )
        EditTextField(
            label = R.string.signup_password,
            leadingIcon = R.drawable.baseline_lock_black_24dp,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = password,
            onValueChanged = { password = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(80.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier.size(width = 150.dp, height = 60.dp)

        ) {
            Text(
                stringResource(R.string.signup_button),
                color = Color.Black,
            )
        }
    }
}

//homepage
@Composable
fun serieCard(serie: Serie, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
       // horizontalArrangement = Arrangement.End,
        modifier = Modifier.size(width = 800.dp, height = 800.dp)

    ) {
        Image(
            painter = painterResource(serie.imageId),
            contentDescription = "",
            modifier = Modifier
                .size(width = 150.dp, height = 500.dp)
                .clip(RoundedCornerShape(16.dp))
                .offset(x = 1.dp)
        )
        Column {
            Row(){
                Text(
                    text = stringResource(id = R.string.title_label),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = LocalContext.current.getString(serie.titleId),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Row(){
                Text(
                    text = stringResource(id = R.string.season_label),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = LocalContext.current.getString(serie.seasonId),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Row(){
                Text(
                    text = stringResource(id = R.string.streaming_label),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = LocalContext.current.getString(serie.streamingId),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Composable
fun homePageApp(modifier: Modifier = Modifier){
    var serie = Serie(seasonId = R.string.serie_season1, streamingId = R.string.serie_streaming1, titleId = R.string.serie_title1, imageId = R.drawable.image2)
    serieCard(serie)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CineFacilTheme {
        homePageApp()
    }
}