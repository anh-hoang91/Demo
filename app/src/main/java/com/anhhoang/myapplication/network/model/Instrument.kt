package com.anhhoang.myapplication.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * "id": "cead5cf4-9f22-11ec-b909-0242ac120002",
 *     "name": "Apple",
 *     "ticker": "AAPL",
 *     "instrument_type": "stock",
 *     "current_price": 142.70,
 *     "previous_price": 141.70,
 *     "description": "Apple is a blah blah blah..."
 * */

@Serializable
data class Instrument(
    val id: String,
    val name: String,
    @SerialName("instrument_type")
    val instrumentType: String,
    @SerialName("current_price")
    val currentPrice: Double,
    @SerialName("previous_price")
    val previousPrice: Double,
    val description: String,
)
