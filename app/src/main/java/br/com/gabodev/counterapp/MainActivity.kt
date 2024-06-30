package br.com.gabodev.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.gabodev.counterapp.ui.theme.CounterAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {

      val viewModel: CounterViewModel = viewModel()

      CounterAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          TheCounterApp(modifier = Modifier.padding(innerPadding), viewModel)
        }
      }
    }
  }
}

@Composable
fun TheCounterApp(
  modifier: Modifier = Modifier,
  viewModel: CounterViewModel,
) {


  Column(
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      text = "Count: ${viewModel.count.value}",
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))
    Row {
      Button(onClick = { viewModel.decrement() }) {
        Text(text = "Decrement")
      }
      Spacer(modifier = Modifier.padding(16.dp))
      Button(onClick = { viewModel.increment() }) {
        Text(text = "Increment")
      }
    }
  }
}

//@Preview
//@Composable
//private fun PreviewTheCounterApp() {
//  TheCounterApp()
//}