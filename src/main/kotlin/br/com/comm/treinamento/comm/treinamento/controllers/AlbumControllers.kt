package br.com.comm.treinamento.comm.treinamento.controllers

import br.com.comm.treinamento.comm.treinamento.models.Album
import br.com.comm.treinamento.comm.treinamento.repository.AlbumRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/notes")
class AlbumControllers {

    @Autowired
    lateinit var aRepository : AlbumRepository

    @ResponseBody
    @GetMapping("/listAll")
    fun listAll() : List<Album> =
        aRepository.findAll().toList()

    @PostMapping("/adicionar")
    fun adicionarMembro(@RequestBody album: Album) : Album?{
        aRepository.save(album)
        val x : Long? = 454L
        return aRepository.findById(album.id).get()
    }

    @GetMapping("/find")
    fun findELement(@RequestParam(value = "nome") nome:String): Album? = aRepository.findByNome(nome)


    @GetMapping("/remove")
    fun removeElement(@RequestParam(value = "id") id: Long): Album? {
        var album = aRepository.findById(id).get()
        aRepository.delete(album)
        return album
    }

    @PostMapping("/update")
    fun updateElement(@RequestBody albumChanged: Album): Album?{
        var album = aRepository.findById(albumChanged.id).get()
        aRepository.delete(album)
        return album
    }

}