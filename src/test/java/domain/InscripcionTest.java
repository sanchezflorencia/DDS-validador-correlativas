package domain;

import domain.alumnos.Alumno;
import domain.materias.Materia;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InscripcionTest {
        List<Materia> materiasAprobadasCarlos = new ArrayList<>();
        List<Materia> materiasAprobadasJuana = new ArrayList<>();

        Materia correlativa1 = new Materia("Analisis 1");
        Materia correlativa2 = new Materia("Fisica 1");
        Materia correlativa3 = new Materia("Ingles 1");
        Materia unaMateria = new Materia("Fisica 2");
        Materia otraMateria = new Materia("Ingles 2");

        Alumno unAlumno = new Alumno("Carlos", "123456", materiasAprobadasCarlos);
        Alumno otroAlumno = new Alumno("Juana", "001029", materiasAprobadasJuana);

    @Test
    public void alumnoLograInscribirse(){
        //carlos aprobo fisica 1, analisis 1, ingles 1
        unAlumno.agregarMateriaAprobada(correlativa1);
        unAlumno.agregarMateriaAprobada(correlativa2);
        unAlumno.agregarMateriaAprobada(correlativa3);

        //juana aprobo ingles 1
        otroAlumno.agregarMateriaAprobada(correlativa3);

        //fisica 2 tiene como correlativas fisica 1 y analisis 1
        unaMateria.agregarMateriaCorrelativa(correlativa1);
        unaMateria.agregarMateriaCorrelativa(correlativa2);
        // ingles 2 tiene como correlativa a ingles 1
        otraMateria.agregarMateriaCorrelativa(correlativa3);


        //Carlos puede anotarse a Ingles 2
        Assert.assertTrue(unAlumno.puedeCursar(otraMateria));
        //Carlos puede anotarse a Fisica 2
        Assert.assertTrue(unAlumno.puedeCursar(unaMateria));
        //Juana puede anotarse a Ingles 2
        Assert.assertTrue(otroAlumno.puedeCursar(otraMateria));

    }

    @Test
    public void alumnoNolograInscribirse(){
        //juana aprobo ingles 1
        otroAlumno.agregarMateriaAprobada(correlativa3);
        //fisica 2 tiene como correlativas fisica 1 y analisis 1
        unaMateria.agregarMateriaCorrelativa(correlativa1);
        unaMateria.agregarMateriaCorrelativa(correlativa2);
        //Juana no puede anotarse a Fisica 2
        Assert.assertFalse(otroAlumno.puedeCursar(unaMateria));

    }
    @Test
    public void inscripcionaMateriaSinCorrelativas(){
        //juana aprobo ingles 1
        otroAlumno.agregarMateriaAprobada(correlativa3);
        //Fisica 1 no tiene correlativas, Juana se puede anotar
        Assert.assertTrue(otroAlumno.puedeCursar(correlativa2));

        //carlos aprobo fisica 1, analisis 1, ingles 1
        unAlumno.agregarMateriaAprobada(correlativa1);
        unAlumno.agregarMateriaAprobada(correlativa2);
        unAlumno.agregarMateriaAprobada(correlativa3);
        //Fisica 1 no tiene correlativas, Carlos se puede anotar
        Assert.assertTrue(unAlumno.puedeCursar(correlativa2));
    }
}
