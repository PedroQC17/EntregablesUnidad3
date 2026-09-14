package com.example.ejercicios

//PRACTICA
enum class Daypart{
    MORNING, AFTERNOON, EVENING
}
data class Event (
    val title : String,
    val description : String? = null,
    val daypart : Daypart,
    val durationInMinutes : Int
){

}
fun main(){

    val event = Event (
        "Estudiar Kotlin",
        "Comprometerser a estudair Kotlin al menos 15 minuts al dia",
        Daypart.EVENING,
        15
    )
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    print(event)

    val events = mutableListOf<Event>(
        event,
        event1,
        event2,
        event3,
        event4,
        event5,
        event6

    )

    val shortsEvents = events.filter {
        it.durationInMinutes<60
    }

    println("Eventos cortos (<60min)")
    shortsEvents.forEach{
        println(it.title)
    }
    val summaryEvents = events.groupBy{
        it.daypart
    }

    println("Resmuen de eventos por dia")
    summaryEvents.forEach{ (daypart,events) ->
        println("$daypart: ${events.size} events")

    }

}