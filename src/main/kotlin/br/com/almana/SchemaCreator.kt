package br.com.almana

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.SchemaUtils.drop
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

/**
 * @author Francisco Portillo (francisco.portillo@ifood.com.br)
 * Created on 9/23/17.
 */
object Releases : Table() {
    val id = long("id").primaryKey().autoIncrement()
    val serviceName = text("service_name")
    val version = text("version")
    val description = text("description")
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at").nullable()
    var username = text("username")
}

class SchemaCreator {
    fun migrate() {
        Database.connect("jdbc:postgresql://localhost:5432/mindstone_db",
                user = "mindstone",
                password = "mindstone",
                driver = "org.postgresql.ds.PGSimpleDataSource")

        transaction{
            drop(Releases)
            create(Releases)

            Releases.insert {
                it[serviceName] = "ifood-payment-platform"
                it[version] = "versionFoo"
                it[description] = "teste de descrição"
                it[createdAt] = DateTime.now()
                it[username] = "Johnes Doeus"
            }
        }
    }
}