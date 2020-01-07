package br.com.comm.treinamento.comm.treinamento.controllers

import br.com.comm.treinamento.comm.treinamento.models.Album
import org.springframework.web.bind.annotation.*




@RestController
@RequestMapping("/notes")
class AlbumControllers {

    val listaAlbuns = mutableListOf<Album>()

    @ResponseBody
    @GetMapping("/listAll")
    fun listAll() : List<Album> =
        listaAlbuns

    @PostMapping("/adicionar")
    fun adicionarMembro(@RequestBody album: Album) : Album?{
        listaAlbuns.add(album);
        return listaAlbuns.find { it.equals(album) }
    }

    @GetMapping("/find")
    fun findELement(@RequestParam(value = "nome") nome:String): Album?{
        return listaAlbuns.find { it.nome.equals(nome) }
    }

}