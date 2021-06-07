package com.example

import freemarker.cache.ClassTemplateLoader
import freemarker.core.HTMLOutputFormat
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.main(){

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
    }

    routing {
        get("/"){

            val records = mutableListOf(
                Record("Test", "testBody"),
                Record("Test", "testBody"),
                Record("Test", "testBody")
            )

            call.respond(FreeMarkerContent("index.ftl", mapOf("records" to records), ""))
        }
    }
}
