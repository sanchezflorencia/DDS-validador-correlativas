package domain.materias;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    public List<Materia> materiasCorrelativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.materiasCorrelativas = new ArrayList<>();
    }

    public boolean cumpleCorrelativas(List<Materia> materiasAprobadas){
        if(this.materiasCorrelativas.isEmpty()){
            return true;
        }else return materiasAprobadas.containsAll(this.materiasCorrelativas);
    }

    public void agregarMateriaCorrelativa(Materia unaMateria){
        this.materiasCorrelativas.add(unaMateria);
    }

}
