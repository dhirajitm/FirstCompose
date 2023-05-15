package com.example.firstcompose

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(heightDp = 400)
fun PreviewItem() {
/*
    LazyColumn(content = {
        items(getCategoryList()) { item ->
            BlogCategory(imgId = item.imgId, title = item.title, subTitle = item.subTitle)
        }
    })
*/
    Column(Modifier.verticalScroll(rememberScrollState())) {
        getCategoryList().map { item ->
            BlogCategory(imgId = item.imgId, title = item.title, subTitle = item.subTitle)
        }
    }
/*
    BlogCategory(
        imgId = R.drawable.baseline_supervised_user_circle_24,
        title = "Dhiraj Kumar",
        subTitle = "Android Dev"
    )
*/
}

@Composable
fun BlogCategory(imgId: Int, title: String, subTitle: String) {
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imgId),
                contentDescription = "",
                Modifier
                    .size(68.dp)
                    .padding(8.dp)
                    .weight(0.2f)
            )
            ItemDescription(title, subTitle, Modifier.weight(0.8f))
        }
    }
}

@Composable
fun ItemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Thin
        )
    }
}

data class Category(val imgId: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.baseline_supervised_user_circle_24, "Dhiraj", "Android"))
    list.add(Category(R.drawable.baseline_help_24, "Pankaj", "MBBS"))
    list.add(Category(R.drawable.baseline_account_circle_24, "Me", "Android"))
    list.add(Category(R.drawable.baseline_group_work_24, "Rupesh", "Something"))
    list.add(Category(R.drawable.baseline_supervised_user_circle_24, "Dhiraj", "Android"))
    list.add(Category(R.drawable.baseline_help_24, "Pankaj", "MBBS"))
    list.add(Category(R.drawable.baseline_account_circle_24, "Me", "Android"))
    list.add(Category(R.drawable.baseline_group_work_24, "Rupesh", "Something"))
    list.add(Category(R.drawable.baseline_supervised_user_circle_24, "Dhiraj", "Android"))
    list.add(Category(R.drawable.baseline_help_24, "Pankaj", "MBBS"))
    list.add(Category(R.drawable.baseline_account_circle_24, "Me", "Android"))
    list.add(Category(R.drawable.baseline_group_work_24, "Rupesh", "Something"))
    return list
}