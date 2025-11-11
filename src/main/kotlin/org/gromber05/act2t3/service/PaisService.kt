package org.gromber05.act2t3.service


import org.gromber05.act2t3.model.Pais
import org.gromber05.act2t3.repository.PaisRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class PaisService(
    private val repo: PaisRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<Pais> = repo.findAll() as List<Pais>

    @Transactional(readOnly = true)
    fun findById(id: Long): Optional<Pais> = repo.findById(id)

    @Transactional
    fun create(pais: Pais): Pais = repo.save(pais)

    @Transactional
    fun update(id: Long, actualizado: Pais): Pais {
        val existente = repo.findById(id).orElseThrow { NoSuchElementException("País id=$id no encontrado") }
        val nuevo = existente.copy(
            nombre = actualizado.nombre,
            codigoIso = actualizado.codigoIso,
            capital = actualizado.capital,
            poblacion = actualizado.poblacion,
            superficieKm2 = actualizado.superficieKm2,
            moneda = actualizado.moneda,
            idiomaPrincipal = actualizado.idiomaPrincipal,
            continente = actualizado.continente
        )
        return repo.save(nuevo)
    }

    @Transactional
    fun delete(id: Long) {
        if (!repo.existsById(id)) throw NoSuchElementException("País id=$id no encontrado")
        repo.deleteById(id)
    }
}
