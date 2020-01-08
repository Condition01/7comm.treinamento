package br.com.comm.treinamento.comm.treinamento.models

import javax.persistence.*

@Entity
@Table(name = "album")
data class Album(
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id : Long = 0,

    @Column(name = "nome", nullable = false)
    var nome : String,

    @Column(name = "ano", nullable = false)
    var ano : Int
)