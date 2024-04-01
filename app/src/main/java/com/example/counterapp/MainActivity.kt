package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CounterViewModel = viewModel()
            CounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TheCounterApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun TheCounterApp(viewModel: CounterViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "The-Counter-App",
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Monospace,
              fontSize = 35.sp
            )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Count: ${viewModel.count.value}",
               fontSize = 23.sp,
               fontWeight = FontWeight.Bold,
              fontFamily =  FontFamily.Monospace
            )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            OutlinedButton(onClick = { viewModel.increment() },
                 modifier = Modifier.size(50.dp),
                shape = CircleShape,
                border = BorderStroke(1.dp, Color.Blue),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                ) {
                 Icon(Icons.Default.Add, contentDescription="INCREMENT")
            }
            Spacer(modifier = Modifier.width(30.dp))
            OutlinedButton(onClick = { viewModel.decrement() },
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                border = BorderStroke(1.dp, Color.Red),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
            ) {
               Image(painterResource(R.drawable.baseline_horizontal_rule_24),
                   contentDescription = "DECREMENT")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(text = "INCREMENT",
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Monospace
                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "DECREMENT",
                  fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
                )
        }
    }
}

@Preview
@Composable
fun TheCounterAppPreview(){
    TheCounterApp(viewModel = CounterViewModel())
}
