package org.gromber05.act2t3.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

@Table("PAISES")
data class Pais(
    @Id
    val id: Long? = null,

    val nombre: String,
    val codigoIso: String,
    val capital: String,
    val poblacion: Long,
    val superficieKm2: BigDecimal,
    val moneda: String,
    val idiomaPrincipal: String,
    val continente: String
)