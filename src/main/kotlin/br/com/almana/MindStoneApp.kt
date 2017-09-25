package br.com.almana

/**
 * @author Francisco Portillo (francisco.portillo@ifood.com.br)
 * Created on 9/23/17.
 */
import br.com.almana.entity.Release
import br.com.almana.entity.ReleaseTable
import br.com.almana.entity.ReleaseTable.createdAt
import br.com.almana.entity.ReleaseTable.description
import br.com.almana.entity.ReleaseTable.id
import br.com.almana.entity.ReleaseTable.serviceName
import br.com.almana.entity.ReleaseTable.updatedAt
import br.com.almana.entity.ReleaseTable.username
import br.com.almana.entity.ReleaseTable.version
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import spark.kotlin.get
import spark.kotlin.staticFiles

fun main(args: Array<String>) {

    MindStoneDb.connect()
    staticFiles.location("/public")

    get("/hello") {
        transaction {
            jacksonObjectMapper().writeValueAsString(
            ReleaseTable.selectAll().map {
                Release(id= it[id],
                        serviceName = it[serviceName],
                        version = it[version],
                        createdAt = it[createdAt],
                        description = it[description],
                        updatedAt = it[updatedAt],
                        username = it[username])
            }.toList())
            TODO("joda.time.DateTime default json serialization sucks")
        }
    }
}

