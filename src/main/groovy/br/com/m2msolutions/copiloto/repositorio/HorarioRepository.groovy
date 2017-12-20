package br.com.m2msolutions.copiloto.repositorio

import br.com.m2msolutions.copiloto.modelo.planejamento.Horario
import org.springframework.data.jpa.repository.JpaRepository

interface HorarioRepository extends JpaRepository<Horario,Integer>{}