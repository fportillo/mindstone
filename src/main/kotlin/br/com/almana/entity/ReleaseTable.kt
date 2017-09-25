package br.com.almana.entity

import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

/**
 * @author Francisco Portillo (francisco.portillo@ifood.com.br)
 * Created on 9/23/17.
 */
object ReleaseTable : Table() {
    val id = long("id").primaryKey().autoIncrement()
    val serviceName = text("service_name").index(isUnique = false)
    val version = text("version")
    val description = text("description")
    val createdAt = datetime("created_at").index(isUnique = false)
    val updatedAt = datetime("updated_at").nullable()
    var username = text("username")
}

data class Release(val id: Long,
                   val serviceName: String,
                   val version: String,
                   val description: String,
                   val createdAt: DateTime,
                   val updatedAt: DateTime?,
                   val username: String)
