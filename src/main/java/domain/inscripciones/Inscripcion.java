package domain.inscripciones;

import domain.alumnos.Alumno;
import domain.materias.Materia;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasAInscribir;

    public Inscripcion(List<Materia> materiasAInscribir) {
        this.materiasAInscribir = materiasAInscribir;
    }

    public boolean aprobada(){
       return this.materiasAInscribir.stream().allMatch(materia -> this.alumno.puedeCursar(materia));
    }

}
