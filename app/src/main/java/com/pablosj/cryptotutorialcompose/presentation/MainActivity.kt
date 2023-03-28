package com.pablosj.cryptotutorialcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pablosj.cryptotutorialcompose.presentation.item_detail.ItemDetailScreen
import com.pablosj.cryptotutorialcompose.presentation.item_list.ItemsListScreen
import com.pablosj.cryptotutorialcompose.presentation.ui.theme.CryptoTutorialComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTutorialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.ItemListScreen.route){
                        composable(route = Screen.ItemListScreen.route){
                            ItemsListScreen(navController)
                        }
                        composable(route = Screen.ItemDetailsScreen.route + "/{coinId}"){
                            ItemDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    CryptoTutorialComposeTheme {
//        Greeting("Android")
//    }
//}