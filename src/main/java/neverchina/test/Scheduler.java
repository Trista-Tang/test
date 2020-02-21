package neverchina.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Scheduler {
    public void schedule(Digraph digraph) {
        while (true) {
            List<Task> todo = new ArrayList<Task>();
            for (Task task : digraph.getTasks()) {
                if (!task.hasExecuted()) {
                    Set<Task> prevs = digraph.getMap().get(task);
                    if (prevs != null && !prevs.isEmpty()) {
                        boolean toAdd = true;
                        for (Task task1 : prevs) {
                            if (!task1.hasExecuted()) {
                                toAdd = false;
                                break;
                            }
                        }
                        if (toAdd) {
                            todo.add(task);
                        }
                    } else {
                        todo.add(task);
                    }
                }
            }
            if (!todo.isEmpty()) {
                for (Task task : todo) {
                    if (!task.execute()) {
                        throw new RuntimeException();
                    }
                }
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Digraph digraph = new Digraph();
        Task A = new Task(1L, "A", 0);
        Task B = new Task(2L, "B", 0);
        Task C = new Task(3L, "C", 0);
        Task D = new Task(4L, "D", 0);
        Task E = new Task(5L, "E", 0);
        Task F = new Task(6L, "F", 0);
        Task G = new Task(7L, "G", 0);
        Task H = new Task(8L, "H", 0);
        digraph.addTask(A);
        digraph.addTask(B);
        digraph.addTask(C);
        digraph.addTask(D);
        digraph.addTask(E);
        digraph.addTask(F);
        digraph.addTask(G);
        digraph.addTask(H);
        digraph.addEdge(A, C);
        digraph.addEdge(A, G);
        digraph.addEdge(C, H);
        digraph.addEdge(G, B);
        digraph.addEdge(E, B);
        digraph.addEdge(D, A);
        digraph.addEdge(F, D);
        digraph.addEdge(F, E);
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(digraph);
    }
}
