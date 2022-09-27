package kr.ac.kumoh.s20200886.kotlin_mycounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20200886.kotlin_mycounter.ui.theme.Kotlin_MyCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyApp(content = { Greeting("test") })
            MyApp {
                Column {
                    Row{

                        Counter()
                        Counter()
                        Counter()

                    }
                    Row{
                        Counter()
                        Counter()
                        Counter()
                        Counter()

                    }
                    Row{
                        Counter()
                        Counter()
                        Counter()
                        Counter()
                    }

                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Kotlin_MyCounterTheme() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var count by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier
        //.fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$count",
            fontSize = 70.sp,
        )
        Column{
            Button(modifier = Modifier
                //.fillMaxWidth(),
                .height(50.dp),
//                verticalArrangement = Arrangement.Center,
                onClick = { count++ })
                {
                Text(text = "증가")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(modifier = Modifier.height(50.dp),
            onClick = {if (count>0) count --}) {
                Text(text="감소")
                }
            }
        }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() = MyApp {
    Counter()
}