package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserva {

  @Id
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  public Long id;

  @ManyToOne
  public Cancha cancha;

  @ManyToOne
  public Participante ParticipanteQueReservo;
}
