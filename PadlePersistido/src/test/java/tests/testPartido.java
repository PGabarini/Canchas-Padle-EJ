package tests;

import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.example.Cancha;
import org.example.Partido;
import org.example.RepoPadle;
import org.example.Reserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.mockito.Mockito.*;


public class testPartido implements SimplePersistenceTest {

  RepoPadle repoPadle = new RepoPadle();
  Reserva reserva1 = mock(Reserva.class);

  Partido unPartido = new Partido(
      reserva1,
      LocalDate.of(2023, 12, 15),
      LocalDate.of(2023, 12, 20),
      2
  );

  Partido otroPartido = new Partido(
      reserva1,
      LocalDate.of(2023, 12, 1),
      LocalDate.of(2023, 12, 3),
      1
  );


  @Test
  void seInsertaYTraeJugador(){

    repoPadle.registrar(unPartido);

    Assertions.assertNotNull(unPartido.getId());

    Partido partidoRepe = repoPadle.obtenerPartido(unPartido.getId());

    Assertions.assertEquals(unPartido, partidoRepe);
  }

  @Test
  void insertaPartidosYTraeTodos(){
    repoPadle.registrar(unPartido);
    repoPadle.registrar(otroPartido);


  List<Partido> partidos = repoPadle.obtenerPartidos();
  Assertions.assertTrue(1< partidos.size());
  Assertions.assertEquals(2, partidos.size());
  Assertions.assertNotEquals(3, partidos.size());
  }
};

