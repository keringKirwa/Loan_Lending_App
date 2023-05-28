package com.example.kkdev_hustler_fund_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kkdev_hustler_fund_app.ui.theme.Kkdev_Hustler_Fund_AppTheme
import com.example.kkdev_hustler_fund_app.ui.theme.MyColors

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kkdev_Hustler_Fund_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   HomeScreenPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    Kkdev_Hustler_Fund_AppTheme {
        HomeScreen()
    }
}
@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
        .safeContentPadding()
    ){

        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-16).dp)
                .clip(shape = RoundedCornerShape(bottomEnd = 0.dp, bottomStart = 0.dp)), contentScale = ContentScale.FillWidth,)

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(10.dp),

        ){
            SearchRow()
            AccountInfoRow()
            Promotions()
        }
    }



}


@Composable
fun SearchRow() {

    val enteredText = remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(2.dp) ,
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
        Box(modifier = Modifier.weight(1f)){
            CustomTextField()
        }

        IconButton(
            onClick = { /*TODO*/ },
        ) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(Color.White, shape = CircleShape)

                    ,
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Settings",

                    tint = Color.Black,
                    modifier = Modifier.size(34.dp)
                )
            }
        }
        
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        singleLine = true,
        onValueChange = {
            text = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        label = { Text(text = "Search Items") },
        placeholder = { Text(text = "e.g clothes , food ...") },
    )

}


@Composable
fun AccountInfoRow() {
    Spacer(modifier = Modifier.padding(5.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)

            ) {
        Row( modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(20.dp) ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround) {
            IconButton(onClick = { /*TODO*/ }) {

            }
            Column(
                modifier = Modifier.padding(horizontal = 3.dp)
            ) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "Settings",

                    tint =Color.Green ,
                    modifier = Modifier.size(34.dp)
                )
                Text(text = "Account Info")
            }
            VerticalDivider()
            Column(
                modifier = Modifier.padding(horizontal = 3.dp)
            ) {
                Row(
                    modifier=Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Settings",

                        tint = Color.Gray,
                        modifier = Modifier.size(34.dp)
                    )
                    Text(text = "Account Info")

                }
            }

        }
        
    }
}


@Composable
fun VerticalDivider() {
    Divider(
        color = Color.Gray,
        modifier = Modifier
            .width(1.dp)
            .fillMaxHeight()
    )
}


@Composable
fun Promotions() {
    LazyRow(
        Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.bank_image_2),
                title = "Fruit",
                subtitle = "Start @",
                header = "$1",
                backgroundColor = MyColors.Orange
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.bank_image_1),
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                backgroundColor= MyColors.LightBlue
            )
        }
    }
}


@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)

    ) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

