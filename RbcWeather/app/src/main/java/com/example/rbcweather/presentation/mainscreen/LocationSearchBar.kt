package com.example.rbcweather.presentation.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rbcweather.domain.repository.SearchLocationEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationSearchBar(
    textFieldState: TextFieldState = rememberTextFieldState(""),
    searchResults: List<SearchLocationEntity>,
    onSearchResultClick: (SearchLocationEntity) -> Unit = {},
    onQueryChanged: (String) -> Unit = {},
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Box(
        Modifier
            .fillMaxWidth()
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter),
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.text.toString(),
                    onQueryChange = {
                        textFieldState.edit { replace(0, length, it) }
                        onQueryChanged(it)
                    },
                    onSearch = {
                        expanded = false
                    },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = { Text("Search") }
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                searchResults.forEach { result ->
                    ListItem(
                        headlineContent = { Text("${result.name}, ${result.country}") },
                        modifier = Modifier
                            .clickable {
                                textFieldState.clearText()
                                onSearchResultClick(result)
                                expanded = false
                            }
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewSearchBar(modifier: Modifier = Modifier) {
    LocationSearchBar(
        searchResults = listOf(
            SearchLocationEntity(
                name = "New York",
                country = "USA",
                latitude = 40.7128,
                longitude = -74.0060
            ),
            SearchLocationEntity(
                name = "Paris",
                country = "France",
                latitude = 48.8566,
                longitude = 2.3522
            ),
            SearchLocationEntity(
                name = "Tokyo",
                country = "Japan",
                latitude = 35.6895,
                longitude = 139.6917
            )
        )
    )
}