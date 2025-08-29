package org.example;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Partido{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long idPartido;

  @ManyToOne
  public Reserva reserva;

  @Column
  public LocalDate Inicio;

  @Column
  public LocalDate Fin;

  @Column
  public Integer cantidadJugadores;

  @ManyToMany
  public List<JugadorDePartido> jugadores;

  public Partido(Reserva reserva, LocalDate Inicio, LocalDate Fin, Integer cantidadJugadores) {
    this.reserva = reserva;
    this.Inicio = Inicio;
    this.Fin = Fin;
    this.cantidadJugadores = cantidadJugadores;
  }

  public Partido() {

  }

  public Long getId() {
    return idPartido;
  }
}
