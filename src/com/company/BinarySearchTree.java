package com.company;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<AnyType>{
        //constructor
        BinaryNode(AnyType theElement){
            this(theElement, null, null);
        }
        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
            element = theElement; left = lt; right = rt;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }
    private BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
    }
    public  void makeEmpty(){
        root = null;
    }
    public boolean contains(AnyType x){
        return contains(x, root);
    }

    public void insert(AnyType x){
        root = insert(x, root);
    }
    public void remove(AnyType x){
        root = remove(x, root);
    }

    public void printTree(){

    }
    private boolean contains(AnyType x, BinaryNode<AnyType> T){
        if (T == null){
            return false;
        }
        int compareResult = x.compareTo(T.element);

        if (compareResult < 0){
            return contains(x, T.left);
        }else if (compareResult > 0){
            return contains(x, T.right);
        }else {
            return true;
        }
    }
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> T){
        if (T == null){
            return null;
        }else if(T.left == null){
            return T;
        }
        return findMin(T.left);
    }
    private BinaryNode<AnyType> findMax (BinaryNode<AnyType> T){
        if (T != null){
            while (T.right != null){
                T = T.right;
            }

        }
        return T;
    }
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> T){
        if(T == null){
            return new BinaryNode<>(x, null, null);
        }
        int compareResult = x.compareTo(T.element);
        if (compareResult < 0){
            T.left = insert(x, T.left);
        }else if ( compareResult > 0){
            T.right = insert(x, T.right);
        }else
            ;
        return T;
    }
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> T){
        if (T == null){
            return T;
        }
        int compareResult = x.compareTo(T.element);
        if (compareResult < 0){
            T.left = remove(x, T.left);
        }else if (compareResult > 0){
            T.right = remove(x, T.right);
        }else if (T.left != null && T.right != null){
            T.element = findMin(T.right).element;
            T.right = remove(T.element, T.right);
        }
        else {
            T = (T.left != null) ? T.left : T.right;

        }
        return T;
    }
    private void printTree(BinaryNode<AnyType> T){
        if (T != null) {
            printTree(T.left);
            System.out.print(T.element + " ");
            printTree(T.right);
        }
    }


}
