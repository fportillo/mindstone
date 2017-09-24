package br.com.almana

/**
 * @author Francisco Portillo (francisco.portillo@ifood.com.br)
 * Created on 9/23/17.
 */
import br.com.almana.entity.Release
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import spark.kotlin.get
import spark.kotlin.staticFiles

fun main(args: Array<String>) {

    MindStoneDb.connect()
    MindStoneDb.migrate()
    staticFiles.location("/public")

    get("/hello") {
        transaction {
            val selectAll = Release.selectAll()
            selectAll
        }
    }
}

