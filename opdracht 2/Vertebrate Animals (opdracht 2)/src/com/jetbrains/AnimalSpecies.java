package com.jetbrains;

import java.util.ArrayList;

public class AnimalSpecies implements ThreeNode, Visitable {
    private Animalfamily mParent;
    private ArrayList<ThreeNode> mChildren;
    private String mData;

    public AnimalSpecies(String data){
        mData = data;
        mParent = null;
        mChildren = null;
    }

    @Override
    public void setParent(ThreeNode parent) {
        mParent = (Animalfamily)parent;
    }

    @Override
    public void addChild(ThreeNode child) {

    }

    @Override
    public ThreeNode getParent() {
        return mParent;
    }

    @Override
    public ArrayList<ThreeNode> getChildren() {
        return null;
    }

    @Override
    public String getData() {
        return mData;
    }

    @Override
    public void accept(Visitor v) {
        v.visitSpecies(this);
    }
}
