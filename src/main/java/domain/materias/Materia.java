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
        for (Materia materia : materiasAprobadas){
            if(this.materiasCorrelativas.contains(materia)){
                return true;
            }
        } return false;
    }

    public void agregarMateriaCorrelativa(Materia unaMateria){
        this.materiasCorrelativas.add(unaMateria);
    }

}
