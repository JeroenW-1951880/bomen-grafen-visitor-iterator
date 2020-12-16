package com.jetbrains;

/**
 * werkt niet volledig
 */
public class BreadthFirstIterator implements Iterator {
    @Override
    public boolean HasNext(ThreeNode n) {
        if(n.getParent() != null){
            ThreeNode parent = n.getParent();
            if(parent.getChildren().indexOf(n) + 1 < parent.getChildren().size()){
                return true;
            } else{
                for(ThreeNode node : parent.getChildren()){
                    if(node.getChildren() != null && node.getChildren().size() > 0){
                        return true;
                    }
                }
                return false;
            }
        } else if(n.getChildren() != null && n.getChildren().size() > 0){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public ThreeNode GetNext(ThreeNode n) {
        if(n.getParent() != null){
            ThreeNode parent = n.getParent();
            if(parent.getChildren().indexOf(n) + 1 < parent.getChildren().size()){
                return parent.getChildren().get(parent.getChildren().indexOf(n) + 1);
            } else{
                while(parent != null){
                    for(ThreeNode node : parent.getChildren()){
                        if(node.getChildren() != null && node.getChildren().size() > 0){
                            return node.getChildren().get(0);
                        }
                    }
                    parent = parent.getParent();
                }
                System.err.println("out of bounds");
                return null;
            }
        } else if(n.getChildren() != null && n.getChildren().size() > 0){
            return n.getChildren().get(0);
        } else{
            System.err.println("out of bounds");
            return null;
        }
    }
}
