package com.idea.rentbaaz

data class PubItem (
    val pubName : String,
    val pubTag : String,
    val pubDistance : String,
    val onClick : () -> Unit
)