package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.main(){

    routing {
        get("/"){
            call.respondText("Hello World!")
        }

        route("/hello"){

            get("{name}"){
                val name = call.parameters["name"] ?: return@get call.respondText(
                    "Bad Request",
                    status = HttpStatusCode.BadRequest
                )

                call.respondText("Hello, $name")
            }
        }
    }
}
