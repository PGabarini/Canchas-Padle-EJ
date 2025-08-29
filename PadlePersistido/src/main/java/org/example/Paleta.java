package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Paleta {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  public Long id;

  @Column
  public Float grosor;

  @ManyToOne
  public Color color;

  @ManyToOne
  public Constructor constructor;

}
