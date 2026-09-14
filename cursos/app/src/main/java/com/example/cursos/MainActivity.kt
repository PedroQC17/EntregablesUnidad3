package com.example.cursos

import android.os.Bundle
import android.view.Display
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursos.data.DataSource
import com.example.cursos.model.Topic

import com.example.cursos.ui.theme.CursosTheme
import com.example.cursos.ui.theme.Gray
import com.example.cursos.ui.theme.Purple
import kotlin.coroutines.coroutineContext

/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}*/

@Composable
fun DescriptionCourse(
    nameCourse: String,
    idIcon: Int,
    numberStudents: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = nameCourse,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = FontFamily.Serif
            ),
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(idIcon),
                contentDescription = "icon",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )

            Text(
                text = numberStudents.toString(),
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = FontFamily.Serif
                ),
                color = Color.Gray
            )
        }
    }
}

@Composable
fun CourseCard(
    modifier: Modifier = Modifier,
    idIcon: Int,
    topic: Topic
) {
    Row(
        modifier = modifier
            .background(
                color = Purple,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Image(
            painter = painterResource(topic.imageResourceId),
            contentDescription = "course",
            contentScale = ContentScale.Crop,
            modifier = Modifier

                .width(80.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 8.dp,
                        bottomStart = 8.dp
                    )
                )
                .height(68.dp)
        )

        DescriptionCourse(
            nameCourse = stringResource(topic.stringResourceId),
            idIcon = idIcon,
            numberStudents = topic.numerOfStudents,

        )
    }
}

@Composable
fun CoursesList(
    modifier: Modifier = Modifier,
    courseList: List<Topic>
) {
    LazyColumn(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(courseList) { course ->
            CourseCard(
                modifier = Modifier.fillMaxWidth(),
                idIcon = R.drawable.students,
                topic = course
            )
        }
    }
}

@Composable
fun CoursesScreen(modifier: Modifier = Modifier, courseList: List<Topic>) {

    val mitad = courseList.size / 2 + courseList.size % 2
    val primeraColumna = courseList.take(mitad)
    val segundaColumna = courseList.drop(mitad)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CoursesList(
            modifier = Modifier.weight(1f),
            courseList = primeraColumna,
        )

        CoursesList(
            modifier = Modifier.weight(1f),
            courseList = segundaColumna,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCoursesScreen() {
    CoursesScreen(
        modifier = Modifier.fillMaxSize(),
        courseList = DataSource.topics
    )
}

/*
@Composable
fun PreviewCourseCard() {

    val topic = DataSource.topics

    CoursesList(
        modifier = Modifier,
        courseList = topic

    )
}
*/
