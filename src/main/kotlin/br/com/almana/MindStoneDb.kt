package br.com.almana

import org.jetbrains.exposed.sql.Database

/**
 * @author Francisco Portillo (francisco.portillo@ifood.com.br)
 * Created on 9/24/17.
 */
object MindStoneDb {
    fun connect() {
        Database.connect(
                url = Configs.jdbcUrl(),
                user = Configs.dbUsername(),
                password = Configs.dbPassword(),
                driver = Configs.jdbcDriver()
        )
    }
}
