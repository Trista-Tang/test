package neverchina.test;


import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assert ( true );
    }
    /**
     * problemOneTest
     */
    @Test
    public void problemOneTest(){
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
    /**
     * problemTwoTest
     */
    @Test
    public void problemTwoTest(){
        CachedData cache = new CachedData();
        cache.processCachedData();
    }

    /**
     * problemTwoTest
     */
    @Test
    public void problemThreeTest(){
        UserQueue<String> q = new UserQueue<String>(String.class, 5);
        q.push("1");
        q.push("2");
        q.push("2");
        q.push("3");
        q.push("4");
        q.push("5");
        System.out.println("添加数据"+q);
        System.out.println("pop数据"+q.pop());
        q.push("6");
        System.out.println("push数据"+q);
        q.clear();
        System.out.println("empty数据"+q);
    }
}
