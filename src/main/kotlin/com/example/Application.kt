package com.example

import freemarker.cache.ClassTemplateLoader
import freemarker.core.HTMLOutputFormat
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.main(){

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
    }

    val records = mutableListOf<Record>()

    routing {
        get("/"){
            call.respond(FreeMarkerContent("index.ftl", mapOf("records" to records), ""))
        }

        post("/submit"){
             val params = call.receiveParameters()
            val title = params["title"] ?: return@post call.respond(HttpStatusCode.BadRequest)
            val body = params["body"] ?: return@post call.respond(HttpStatusCode.BadRequest)

            records.add(Record(title, body))
        }
    }
}
