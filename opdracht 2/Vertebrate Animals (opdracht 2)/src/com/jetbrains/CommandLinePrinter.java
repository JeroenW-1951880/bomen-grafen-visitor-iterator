package com.jetbrains;

public class CommandLinePrinter implements Visitor {
    @Override
    public void visitClass(AnimalClass c) {
        System.out.println(c.getData());
    }

    @Override
    public void visitFamily(Animalfamily f) {
        System.out.println('\t' + f.getData());
    }

    @Override
    public void visitSpecies(AnimalSpecies s) {
        System.out.println("\t\t" + s.getData());
    }
}
