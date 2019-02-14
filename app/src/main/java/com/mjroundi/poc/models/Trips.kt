package com.mjroundi.poc.models

/**
 * Created by mJroundi on 14/01/2019.
 *
 */data class Trips(
    val distance: Int,
    val duration: Int,
    val facets: List<Facet>,
    val full_trips_count: Int,
    val links: Links,
    val lowest_price: Int,
    val lowest_price_object: LowestPriceObject,
    val pager: Pager,
    val recommended_price: Int,
    val savings: Int,
    val sorting_algorithm: String,
    val top_trips: List<Any>,
    val total_trip_count_to_display: Int,
    val trips: List<Trip>
)

data class LowestPriceObject(
    val currency: String,
    val string_value: String,
    val symbol: String,
    val value: Int
)

data class Links(
    val _front: String,
    val _self: String
)

data class Trip(
    val answer_delay: Int,
    val arrival_meeting_point: ArrivalMeetingPoint,
    val arrival_passenger_routing: ArrivalPassengerRouting,
    val arrival_place: ArrivalPlace,
    val booking_mode: String,
    val booking_type: String,
    val car: Car,
    val commission: Commission,
    val corridoring_type: String,
    val departure_date: String,
    val departure_meeting_point: DepartureMeetingPoint,
    val departure_passenger_routing: DeparturePassengerRouting,
    val departure_place: DeparturePlace,
    val distance: Distance,
    val duration: Duration,
    val freeway: Boolean,
    val is_comfort: Boolean,
    val links: Links,
    val locations_to_display: List<String>,
    val multimodal_id: MultimodalId,
    val permanent_id: String,
    val price: Price,
    val price_with_commission: PriceWithCommission,
    val price_without_commission: PriceWithoutCommission,
    val seats: Int,
    val seats_left: Int,
    val trip_details_id: String,
    val user: User,
    val vehicle_pictures: List<Any>,
    val viaggio_rosa: Boolean
)

data class DeparturePassengerRouting(
    val proximity: String,
    val routes: List<Route>
)

data class Route(
    val distance_in_meters: Int,
    val type: String
)

data class User(
    val age: Int,
    val bbpro: Boolean,
    val bbpro_segment: String,
    val dialog: String,
    val display_name: String,
    val encrypted_id: String,
    val gender: String,
    val grade: Int,
    val has_picture: Boolean,
    val links: Links,
    val music: String,
    val pets: String,
    val phone_hidden: Boolean,
    val picture: String,
    val rating: Double,
    val rating_count: Int,
    val smoking: String,
    val uuid: String
)

data class DeparturePlace(
    val address: String,
    val city_name: String,
    val country_code: String,
    val latitude: Double,
    val longitude: Double
)

data class ArrivalMeetingPoint(
    val address: String,
    val city_name: String,
    val country_code: String,
    val full_name: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val tags: List<Any>
)

data class ArrivalPassengerRouting(
    val proximity: String,
    val routes: List<Route>
)

data class Commission(
    val currency: String,
    val string_value: String,
    val symbol: String,
    val value: Double
)

data class PriceWithoutCommission(
    val currency: String,
    val price_color: String,
    val string_value: String,
    val symbol: String,
    val value: Int
)

data class Car(
    val category: String,
    val comfort: String,
    val comfort_nb_star: Int,
    val id: String,
    val make: String,
    val model: String
)

data class PriceWithCommission(
    val currency: String,
    val price_color: String,
    val string_value: String,
    val symbol: String,
    val value: Double
)

data class Distance(
    val unity: String,
    val value: Int
)

data class MultimodalId(
    val id: String,
    val source: String
)

data class Price(
    val currency: String,
    val price_color: String,
    val string_value: String,
    val symbol: String,
    val value: Int
)

data class Duration(
    val unity: String,
    val value: Int
)

data class ArrivalPlace(
    val address: String,
    val city_name: String,
    val country_code: String,
    val latitude: Double,
    val longitude: Double
)

data class DepartureMeetingPoint(
    val address: String,
    val city_name: String,
    val country_code: String,
    val full_name: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val tags: List<Any>
)

data class Pager(
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)

data class Facet(
    val items: List<Item>,
    val name: String,
    val type: String
)

data class Item(
    val count: Int,
    val is_selected: Boolean,
    val value: Int
)
