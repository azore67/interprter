package main.java;

import main.kotlin.Stmt;
import main.kotlin.StmtKt;

import java.util.HashMap;
import java.util.Map;

import static main.kotlin.StmtKt.step;

public final class SequentialProgram {
    private final Stmt topLevelStmt;
   public SequentialProgram(Stmt topLevelStmt){
        this.topLevelStmt = topLevelStmt;

    }
//    am rt fn
    public Map<String, Integer> execute(Map<String,Integer> initialStore) {
       Map<String,Integer> workingStore = new HashMap<>(initialStore);
       Stmt currentStmt = topLevelStmt;
               while(currentStmt != null){
                   currentStmt = StmtKt.step(currentStmt,workingStore);
               }
               return workingStore;
    }

    @Override
    public String toString() {
        return topLevelStmt.toString();
    }
}

