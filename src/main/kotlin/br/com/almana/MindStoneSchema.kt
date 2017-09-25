package br.com.almana

import br.com.almana.entity.ReleaseTable
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    MindStoneDb.connect()
    transaction {
        create(ReleaseTable)
    }
}
