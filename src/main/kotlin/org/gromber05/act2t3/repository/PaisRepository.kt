package org.gromber05.act2t3.repository

import org.gromber05.act2t3.model.Pais
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PaisRepository : CrudRepository<Pais, Long>
