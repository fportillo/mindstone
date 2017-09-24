package br.com.almana

import java.util.*

/**
 * @author Francisco Portillo (francisco.portillo@ifood.com.br)
 * Created on 9/24/17.
 */

object Configs {

    private val dbProperties: Properties = Properties()

    init {
        dbProperties.load(Configs::class.java.getResourceAsStream("/database.properties"))
    }

    fun dbUsername():String {
        return dbProperties.getProperty("db.username")
    }

    fun dbPassword():String {
        return dbProperties.getProperty("db.password")
    }

    fun jdbcUrl():String {
        return dbProperties.getProperty("jdbc.url")
    }

    fun jdbcDriver():String {
        return dbProperties.getProperty("jdbc.driver")
    }

}