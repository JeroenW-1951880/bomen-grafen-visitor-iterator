package com.jetbrains;

import java.io.FileWriter;

public class OutputFilePrinter implements Visitor {
    FileWriter fw;

    public OutputFilePrinter(String filename){
        try{fw = new FileWriter(filename);}catch (Exception e){};
    }


    @Override
    public void visitClass(AnimalClass c) {
        try{fw.write(c.getData() + "\n");}catch (Exception e){};
    }

    @Override
    public void visitFamily(Animalfamily f) {
        try{fw.write( "\t" + f.getData() + "\n");}catch (Exception e){};
    }

    @Override
    public void visitSpecies(AnimalSpecies s) {
        try{fw.write( "\t" + s.getData() + "\n");}catch (Exception e){};
    }
}
