package br.com.comm.treinamento.comm.treinamento.repository

import br.com.comm.treinamento.comm.treinamento.models.Album
import org.springframework.data.repository.CrudRepository

interface AlbumRepository : CrudRepository<Album, Long>{
    fun findByNome(nome: String) : Album
}
