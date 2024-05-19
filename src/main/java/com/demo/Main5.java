package com.demo;

public class Main5 {
    
}

interface ISortEngin {
    void setList();
    void sort();
    void reserveSort();
    void printSortListPretty();
}

class A_SortEngin implements ISortEngin {

    A_SortEngin AEngin;
    B_SortEngine BEngine;

    A_SortEngin(A_SortEngin AEngin, B_SortEngine BEngine) {
        this.AEngin = AEngin;
        this.BEngine = BEngine;
    }

    @Override
    public void printSortListPretty() {
        // TODO Auto-generated method stub
        AEngin.printSortListPretty();
        
    }

    @Override
    public void reserveSort() {
        BEngine.sorting(true);
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setList() {
        BEngine.setList();
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sort() {
        BEngine.sorting(true);
        // TODO Auto-generated method stub
        
    }

}

class B_SortEngine {
    public void setList() {} // 정렬할 리스트
    public void sorting(boolean isReverse) {} // 정렬 / 역순 정렬 알고리즘 (파라미터로 순서 결정)
}



class SortingMachine {
    ISortEngin engine;

    void setEngine(ISortEngin engine) {
        this.engine = engine;
    }

    void sorting () {
        engine.setList();

        engine.sort();
        engine.printSortListPretty();

        engine.reserveSort();
        engine.printSortListPretty();
    }
}

class SortEngineAdapter implements ISortEngin {

    @Override
    public void printSortListPretty() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reserveSort() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setList() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub
        
    }

    String aa = "";
    String abb = "";
    String cc = "";
    String addd = "";


}