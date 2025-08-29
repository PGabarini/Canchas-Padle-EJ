package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cancha {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "nombre_Cancha")
  public NombreCancha nombre;

  @ManyToOne
  public Color color;

  @Column
  public Boolean estaIluminada;
}
