package br.com.almana

/**
 * @author Francisco Portillo (francisco.portillo@ifood.com.br)
 * Created on 9/23/17.
 */
import spark.kotlin.Http
import spark.kotlin.ignite

fun main(args: Array<String>) {
    val http: Http = ignite()

    SchemaCreator().migrate()

    http.get("/hello") {
        "Hello Spark Kotlin!"
    }
}

