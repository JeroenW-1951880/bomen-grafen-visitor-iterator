package com.jetbrains;

public interface Visitor {
    public void visitClass(AnimalClass c);

    public void visitFamily(Animalfamily f);

    public void visitSpecies(AnimalSpecies s);

}
