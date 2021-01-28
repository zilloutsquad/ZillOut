package com.idea.rentbaaz

sealed class PubDetailItem (val layoutId : Int)

data class OfferItem (
    val  offerImage: String,
    val  offerDescription: String,
    val  onClick: () -> Unit
) : PubDetailItem(R.layout.layout_pub_offer)

data class EventItem (
    val eventImage: String,
    val eventRate: Double,
    val eventDay: String,
    val eventStartTime: String,
    val eventEndTime : String,
    val eventDate: String,
    val onClick : () -> Unit
) : PubDetailItem(R.layout.layout_event_detail)

data class SpecialityItem(
    val specialityName : String,
    val specialityDescription : String,
    val specialityImage: String,
    val specialityTagText: String
) : PubDetailItem(R.layout.layout_speciality)