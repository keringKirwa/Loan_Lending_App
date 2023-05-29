package com.example.kkdev_hustler_fund_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kkdev_hustler_fund_app.navigations.Navigation
import com.example.kkdev_hustler_fund_app.ui.theme.Kkdev_Hustler_Fund_AppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kkdev_Hustler_Fund_AppTheme {
               MyApp()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MyApp() {
    Navigation.SetupNavigation()

}


}

