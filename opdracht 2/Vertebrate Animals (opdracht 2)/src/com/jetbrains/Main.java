package com.jetbrains;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        AnimalClass vert = new AnimalClass("vertebrate animals");
        Animalfamily mam = new Animalfamily("Mammalia");
        vert.addChild(mam);
        mam.setParent(vert);
        Animalfamily rep = new Animalfamily("Reptilia");
        vert.addChild(rep);
        rep.setParent(vert);
        AnimalSpecies bat = new AnimalSpecies("Bat");
        mam.addChild(bat);
        bat.setParent(mam);
        AnimalSpecies lio = new AnimalSpecies("Lion");
        mam.addChild(lio);
        lio.setParent(mam);
        AnimalSpecies dol = new AnimalSpecies("Dolphin");
        mam.addChild(dol);
        dol.setParent(mam);
        AnimalSpecies snk = new AnimalSpecies("Snake");
        rep.addChild(snk);
        snk.setParent(rep);
        AnimalSpecies cro = new AnimalSpecies("Crocodile");
        rep.addChild(cro);
        cro.setParent(rep);
        AnimalSpecies turt = new AnimalSpecies("Turtle");
        rep.addChild(turt);
        turt.setParent(rep);

        DepthFirstIterator di = new DepthFirstIterator();
        CommandLinePrinter cp = new CommandLinePrinter();
        OutputFilePrinter op = new OutputFilePrinter("output.txt");
        System.out.println("depth first:");
        ThreeNode n = vert;
        Visitable v = vert;
        v.accept(cp);
        v.accept(op);
        while (di.HasNext(n)){
            n = di.GetNext(n);
            v = (Visitable)((ThreeNode)n);
            v.accept(cp);
            v.accept(op);
        }
        BreadthFirstIterator bi = new BreadthFirstIterator(); // breadthfirst werk niet volledig
        System.out.println("breadth first:");
        n = vert;
        v = vert;
        v.accept(cp);
        v.accept(op);
        while (bi.HasNext(n)){
            n = bi.GetNext(n);
            v = (Visitable)((ThreeNode)n);
            v.accept(cp);
            v.accept(op);
        }
    }
}
