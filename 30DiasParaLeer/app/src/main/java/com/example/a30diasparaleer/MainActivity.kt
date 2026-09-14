package com.example.a30diasparaleer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30diasparaleer.data.BookRepository
import com.example.a30diasparaleer.model.Book
import com.example.a30diasparaleer.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                ReviewBooksApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}

@Composable
fun ReviewBooksApp() {
    Scaffold(
        topBar = { BookTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        ListBooks(
            books = BookRepository.books,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ListBooks(
    books: List<Book>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(books) { index, book ->
            BookItem(
                book = book,
                day = index + 1,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun BookItem(
    book: Book,
    day: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column {
            Text(
                text = "Día $day",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 4.dp)
            )
            BookImage(
                bookId = book.imageRes,
                descriptionBook = stringResource(book.nameRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            BookInformation(
                nameBook = stringResource(book.nameRes),
                descriptionBook = stringResource(book.descriptionRes),
                modifier = Modifier.padding(12.dp),
            )
        }
    }
}

@Composable
fun BookInformation(
    nameBook: String,
    descriptionBook: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = nameBook,
            style = MaterialTheme.typography.displayMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = descriptionBook,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun BookImage(
    bookId: Int,
    descriptionBook: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = bookId),
        contentDescription = descriptionBook,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReviewBooksAppPreview() {
    AppTheme {
        ReviewBooksApp()
    }
}
