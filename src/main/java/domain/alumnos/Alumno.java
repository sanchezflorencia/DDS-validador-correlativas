package domain.alumnos;

import domain.materias.Materia;

import java.util.List;

public class Alumno {

    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String legajo, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }
    public boolean cumpleCorrelativas(Materia unaMateria){
        return unaMateria.cumpleCorrelativas(this.materiasAprobadas);
    }

    public void agregarMateriaAprobada(Materia unaMateria){
        this.materiasAprobadas.add(unaMateria);
    }
}
