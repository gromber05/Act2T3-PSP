package org.gromber05.act2t3.web.controlador

import org.gromber05.act2t3.service.PaisService
import org.gromber05.act2t3.web.dto.PaisDto
import org.gromber05.act2t3.web.mapper.PaisMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/paises")
class PaisController(
    private val service: PaisService
) {

    @GetMapping
    fun getAll(): List<PaisDto> =
        service.findAll().map { PaisMapper.toDto(it) }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): PaisDto =
        PaisMapper.toDto(service.findById(id).orElseThrow { NoSuchElementException("País id=$id no encontrado") })

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: PaisDto): PaisDto {
        val saved = service.create(PaisMapper.toEntity(dto.copy(id = null)))
        return PaisMapper.toDto(saved)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: PaisDto): PaisDto {
        val updated = service.update(id, PaisMapper.toEntity(dto.copy(id = id)))
        return PaisMapper.toDto(updated)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(ex: NoSuchElementException) = mapOf("error" to ex.message)
}
