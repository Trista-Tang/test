package neverchina.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 构建DAG
 * @date 2020/2/21 11:52
 *
 */
public class Digraph {
    private Set<Task> tasks;
    private Map<Task, Set<Task>> map;

    public Digraph() {
        this.tasks = new HashSet<Task>();
        this.map = new HashMap<Task, Set<Task>>();
    }
/**
 * @param task 当前任务
 * @param prev 前置任务
 * @date 2020/2/21 11:52
 * @return void
 */
    public void addEdge(Task task, Task prev) {
        if (!tasks.contains(task) || !tasks.contains(prev)) {
            throw new IllegalArgumentException();
        }
        Set<Task> prevs = map.get(task);
        if (prevs == null) {
            prevs = new HashSet<Task>();
            map.put(task, prevs);
        }
        if (prevs.contains(prev)) {
            throw new IllegalArgumentException();
        }
        prevs.add(prev);
    }
    /**
     * 添加任务
     * @param task 当前任务
     * @date 2020/2/21 11:53
     * @return void
     */
    public void addTask(Task task) {
        if (tasks.contains(task)) {
            throw new IllegalArgumentException();
        }
        tasks.add(task);
    }
    /**
     * 移除当前任务
     * @param task 当前任务
     * @date 2020/2/21 11:53
     * @return void
     */
    public void remove(Task task) {
        if (!tasks.contains(task)) {
            return;
        }
        if (map.containsKey(task)) {
            map.remove(task);
        }
        for (Set<Task> set : map.values()) {
            if (set.contains(task)) {
                set.remove(task);
            }
        }
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Map<Task, Set<Task>> getMap() {
        return map;
    }

    public void setMap(Map<Task, Set<Task>> map) {
        this.map = map;
    }
}
