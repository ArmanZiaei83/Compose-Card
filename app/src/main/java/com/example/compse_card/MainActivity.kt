package com.example.compse_card

import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.animatedVectorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compse_card.ui.theme.CompseCardTheme
import com.example.compse_card.ui.theme.Shapes
import kotlinx.coroutines.ThreadContextElement
import java.lang.reflect.Type

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseCardTheme {
                Surface(color = MaterialTheme.colors.background) {
                    setLayout()
                }
            }
        }
    }
}

@Composable
fun setLayout(){
    Column(modifier = Modifier.padding(10.dp).fillMaxWidth()){
        createCard("تولد نگار", " میزبان نگار" , "همین الان")
        createCard("تولد آرمان", " میزبان آرمان" , "همین الان")
        createCard("تولد مامان بزرگ", " میزبان مامان بزرگ" , "همین الان")
    }
}

@Composable
fun createCard(title : String, mizban : String, time : String){
    Surface(elevation = 8.dp, shape = RectangleShape, modifier = Modifier.padding(bottom = 10.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {

            Column(modifier = Modifier.background(Color.White)) {

                Row(modifier = Modifier.width(350.dp).padding(top = 16.dp, end = 16.dp), horizontalArrangement = Arrangement.SpaceBetween){

                    Surface(elevation = 0.dp, modifier = Modifier.padding(start = 12.dp)) {
                        Button(onClick = {}, modifier = Modifier.width(55.dp).height(55.dp)
                            .border(ButtonDefaults.OutlinedBorderSize, color = Color.White)
                            .align(Alignment.CenterVertically),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            border = BorderStroke(0.dp, Color.White)
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_share_24),
                                contentDescription = "Share Button",
                                tint = Color(0xFF087e8c)
                            )
                        }
                    }

                    Text(title, style = TextStyle(
                        color = Color(0xFF000000) ,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.iran_sans)),
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.align(Alignment.CenterVertically))
                }

                Row(modifier = Modifier.align(Alignment.End).padding(end = 14.dp)) {
                    Text(mizban, style = TextStyle(
                        color = Color(0xFFa7a7a7),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.iran_sans)),
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(start = 0.dp))

                }

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(350.dp)) {
                    Surface(shape = CircleShape, elevation = 8.dp, border = BorderStroke(1.dp, color = Color(0xFF087E8C)), modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)) {
                        Button(onClick = {}, modifier = Modifier.width(95.dp).height(50.dp)
                            .align(Alignment.CenterVertically),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ){
                            Text("جزئیات", style = TextStyle(
                                color = Color(0xFF32757b),
                                fontFamily = FontFamily(Font(R.font.iran_sans)),
                                fontSize = 18.sp
                            ))
                        }
                    }

                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(8.dp).align(Alignment.Bottom)) {
                        Text(time, modifier = Modifier.align(Alignment.Bottom), style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.iran_sans)),
                            fontSize = 12.sp,
                            color = Color(0xFF505050)
                        ))

                        Spacer(modifier = Modifier.padding(2.dp))

                        Icon(
                            modifier = Modifier.align(Alignment.Bottom),
                            contentDescription = "calendar",
                            painter = painterResource(R.drawable.ic_baseline_calendar_today_24)
                        )
                    }
                }
            }

            Text("", style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.iran_sans)),
                textAlign = TextAlign.Center
            ), modifier = Modifier.align(Alignment.CenterVertically).width(14.dp).height(158.dp).background(Color(0xFF84cdb2)))
        }
    }
}

//For creating TextViews:
@Composable
fun CreateTextView(text : String, textSize : Int , color : Color) {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompseCardTheme {
        setLayout()
    }
}