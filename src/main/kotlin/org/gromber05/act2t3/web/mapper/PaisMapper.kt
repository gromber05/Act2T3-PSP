package org.gromber05.act2t3.web.mapper


import org.gromber05.act2t3.model.Pais
import org.gromber05.act2t3.web.dto.PaisDto
import java.math.BigDecimal
import kotlin.math.roundToLong

object PaisMapper {

    private const val MILLON = 1_000_000.0

    fun toDto(p: Pais): PaisDto = PaisDto(
        id = p.id,
        nombre = p.nombre,
        codigoIso = p.codigoIso,
        capital = p.capital,
        poblacionMillones = (p.poblacion.toDouble() / MILLON),
        superficieKm2 = p.superficieKm2.toDouble(),
        moneda = p.moneda,
        idiomaPrincipal = p.idiomaPrincipal,
        continente = p.continente
    )

    fun toEntity(dto: PaisDto): Pais = Pais(
        id = dto.id,
        nombre = dto.nombre,
        codigoIso = dto.codigoIso.uppercase().take(3),
        capital = dto.capital,
        poblacion = (dto.poblacionMillones * MILLON).roundToLong(),
        superficieKm2 = BigDecimal.valueOf(dto.superficieKm2),
        moneda = dto.moneda,
        idiomaPrincipal = dto.idiomaPrincipal,
        continente = dto.continente
    )
}
