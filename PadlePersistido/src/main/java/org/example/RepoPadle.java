package org.example;


import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import java.util.List;

public class RepoPadle implements WithSimplePersistenceUnit {

  public void registrar(Partido partido) {
    entityManager().persist(partido);
  }

  public Partido obtenerPartido(Long id) {
    return entityManager().find(Partido.class, id);
  }

  public List<Partido> obtenerPartidos() {
    return entityManager().createQuery("from Partido", Partido.class).getResultList();
  }

  public List<Cancha> canchasQueEstuvo(JugadorDePartido jugador){
    return entityManager().
        createQuery(
            "select r.cancha " +
                "from Partido p " +
                "join p.jugadores j " +
                "join p.reserva r " +
                "where j.id = :jugadorId",
            Cancha.class
        )
        .setParameter("jugadorId", jugador.getId())
        .getResultList();
  }
  /*
        .createNativeQuery(
        "select r.cancha " +
        "from Partido p " +
        "left join Partido_JugadorDePartido pj on pj.Partido_idPartido = p.id " +
        "inner join Reserva r on r.ParticipanteQueReservo_id = :jugadorId " +
        "where pj.jugadores_id = :jugadorId",
        Cancha.class
    )*/
}
