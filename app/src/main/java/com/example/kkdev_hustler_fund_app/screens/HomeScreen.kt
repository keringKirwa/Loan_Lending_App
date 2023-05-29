package com.example.kkdev_hustler_fund_app.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kkdev_hustler_fund_app.R
import com.example.kkdev_hustler_fund_app.ui.theme.DividerColor
import com.example.kkdev_hustler_fund_app.ui.theme.MyColors
import com.example.kkdev_hustler_fund_app.ui.theme.PrimaryColor


@Composable
    fun HomeScreen(){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .safeContentPadding()
        ){
            Image(painter = painterResource(id = R.drawable.ic_launcher_background_main), contentDescription = "",
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
                Spacer(modifier = Modifier.height(16.dp))
                AccountInfoRow()
                Spacer(modifier = Modifier.height(16.dp))
                Promotions()
            }
        }



    }


    @Composable
    fun SearchRow() {

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
                Icon(imageVector= Icons.Outlined.Favorite,
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector= Icons.Outlined.Notifications,
                    contentDescription = "Settings",

                    tint = Color.White,
                    modifier = Modifier.size(34.dp)
                )
            }

        }


    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomTextField(
    ) {
        var text =  remember { mutableStateOf(TextFieldValue("")) }
        TextField(

            value = text.value,
            singleLine = true,
            onValueChange = {
                text.value = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
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
                .padding(horizontal = 16.dp)
                .height(64.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            shape = RoundedCornerShape(8.dp)

        ) {
            Row(modifier =  Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                QrButton()
                VerticalDivider()

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_money ), contentDescription ="", tint = Color.Green )

                    }
                    Column() {
                        Text(text ="$120", fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold )
                        Text(text ="Top Up", color= PrimaryColor)

                    }

                }
                VerticalDivider()
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_coin ), contentDescription ="", tint = PrimaryColor )

                    }
                    Column() {
                        Text(text ="$10", fontSize = 16.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold )
                        Text(text ="Points", color= Color.LightGray, fontSize = 12.sp)

                    }

                }


            }

        }
    }

    @Composable
    fun QrButton() {
        IconButton(
            onClick = {},
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_scan),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }


    @Composable
    fun VerticalDivider() {
        Divider(
            color = DividerColor,
            modifier = Modifier
                .width(1.dp)
                .height(45.dp)
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
                    backgroundColor = PrimaryColor
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
            item {
                PromotionItem(
                    imagePainter = painterResource(id = R.drawable.bank_image_2),
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
            Modifier.width(250.dp),
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