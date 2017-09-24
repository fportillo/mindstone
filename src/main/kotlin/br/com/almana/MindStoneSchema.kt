package br.com.almana

import br.com.almana.entity.Release
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.SchemaUtils.drop
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

fun main(args: Array<String>) {
    MindStoneDb.connect()
    transaction {
        // TODO: drop this drop... may cause troubles
        drop(Release)
        create(Release)

        Release.insert {
            it[serviceName] = "ifood-payment-platform"
            it[version] = "versionFoo"
            it[description] = "teste de descrição"
            it[createdAt] = DateTime.now()
            it[username] = "Johnes Doeus"
        }
    }
}
