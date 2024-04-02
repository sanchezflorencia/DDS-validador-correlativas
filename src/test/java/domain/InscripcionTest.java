package domain;

import domain.alumnos.Alumno;
import domain.materias.Materia;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InscripcionTest {
    @Test
    public void alumnosIntentanInscribirse(){
        List<Materia> materiasAprobadasCarlos = new ArrayList<>();
        List<Materia> materiasAprobadasJuana = new ArrayList<>();

        Materia correlativa1 = new Materia("Analisis 1");
        Materia correlativa2 = new Materia("Fisica 1");
        Materia correlativa3 = new Materia("Ingles 1");

        Alumno unAlumno = new Alumno("Carlos", "123456", materiasAprobadasCarlos);
        Alumno otroAlumno = new Alumno("Juana", "001029", materiasAprobadasJuana);

        unAlumno.agregarMateriaAprobada(correlativa1);
        unAlumno.agregarMateriaAprobada(correlativa2);
        unAlumno.agregarMateriaAprobada(correlativa3);

        otroAlumno.agregarMateriaAprobada(correlativa3);

        Materia unaMateria = new Materia("Fisica 2");
        Materia otraMateria = new Materia("Ingles 2");

        unaMateria.agregarMateriaCorrelativa(correlativa1);
        unaMateria.agregarMateriaCorrelativa(correlativa2);
        otraMateria.agregarMateriaCorrelativa(correlativa3);

        //Carlos puede anotarse a Ingles 2
        Assert.assertTrue(unAlumno.cumpleCorrelativas(otraMateria));
        //Carlos puede anotarse a Fisica 2
        Assert.assertTrue(unAlumno.cumpleCorrelativas(unaMateria));
        //Juana no puede anotarse a Fisica 2
        Assert.assertFalse(otroAlumno.cumpleCorrelativas(unaMateria));
        //Juana puede anotarse a Ingles 2
        Assert.assertTrue(otroAlumno.cumpleCorrelativas(otraMateria));
    }
}
