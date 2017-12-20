package br.com.m2msolutions.copiloto.modelo.planejamento



import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(name = 'horario')
class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = 'id_horario')
    Integer idHorario
    @Temporal(TemporalType.TIME)
    Date partida
    @Temporal(TemporalType.TIME)
    Date chegada
}
