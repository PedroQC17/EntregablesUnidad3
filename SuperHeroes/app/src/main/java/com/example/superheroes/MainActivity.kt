package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.HeroresRepository
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperheroesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {

                Surface(modifier = Modifier.fillMaxSize()) {
                    SuperHeroApp(modifier = Modifier)

                }
            }
        }
    }
}


@Composable
fun SuperHeroApp(
    modifier: Modifier= Modifier,

){
    val heroes = HeroresRepository.heroes
    Scaffold(
        topBar = {HeroTopAppBar(modifier)}
    ) {
        it ->
        LazyColumn(contentPadding = it) {
            items(heroes){
                HeroItem(
                    hero = it,

                )
            }
        }
    }
}


@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(bottom = 16.dp, end= 16.dp, start = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            HeroInformation(
                nameHero = stringResource(hero.nameRes),
                descriptionHero = stringResource(hero.descriptionRes),
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            HeroIcon(
                heroIconId = hero.imageRes,
                heroDescription = stringResource(hero.descriptionRes)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier){

    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = stringResource(R.string.app_name)
                )
            }
        },

        modifier=modifier
    )

}


@Composable
fun HeroIcon(
    heroIconId : Int,
    heroDescription : String,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(heroIconId),
        contentDescription = heroDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(72.dp)
            .clip(MaterialTheme.shapes.small)
        ,
    )
}

@Composable
fun HeroInformation(
    nameHero: String,
    descriptionHero: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = nameHero,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = descriptionHero,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 2,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SuperHeroItemPreview(

){
    SuperHeroApp()
}

