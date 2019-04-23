package other;
import java.util.*;

public class TaskSchedule {
    private Set<Task> tasks;
    // don't need to maintain so many things!
    //    private Map<Task, Integer> indegreeMap; // task->its indegree
    //    private Map<Task, List<Task>> childrenMap; // task->its children
    //    private Map<Task, List<Task>> nonExists; // task not in set yet->its children
    public TaskSchedule() {
        tasks = new HashSet<>();
    }
    public boolean addTask(Task t) {
        // add into tasks set
        if (!tasks.add(t)) {
            return false;
        }
        return true;
    }
//    // if t is other tasks' prerequisite, add t's children in childrenMap
//    List<Task> children = nonExists.getOrDefault(t, new ArrayList<>());
//        nonExists.remove(t);
//        childrenMap.put(t, children);
//    // increase children's indegree
//        if (!children.isEmpty()) {
//        for (Task child : children) {
//            Integer indegree = indegreeMap.get(child);
//            indegreeMap.put(child, indegree + 1);
//        }
//    }
//    // update other's childrenMap if t is it's children and t's indegree
//        if (t.prerequisites == null || t.prerequisites.isEmpty()) {
//        indegreeMap.put(t, 0);
//    } else {
//        int indegreeOfT = 0;
//        for (Iterator<Task> it = t.prerequisites.iterator(); it.hasNext(); ) {
//            Task parent = it.next();
//            if(tasks.contains(parent)) {
//                indegreeOfT++;
//                childrenMap.get(parent).add(t);
//            } else {
//                List<Task> childrenOfParent = nonExists.getOrDefault(parent, new ArrayList<>());
//                childrenOfParent.add(t);
//                nonExists.put(parent, childrenOfParent);
//            }
//        }
//        indegreeMap.put(t, indegreeOfT);
//    }
//        return true;

    private void constructGraph(Map<Task, Integer> indegreeMap, Map<Task, List<Task>> childrenMap) {

        for (Task cur : tasks) {
            //System.out.println(cur.id);
            int indegree = 0;
            if (cur.prerequisites == null || cur.prerequisites.size() == 0) {
                indegreeMap.put(cur, indegree);
                continue;
            }
            for (Task parent : cur.prerequisites) {
                if (tasks.contains(parent)) {
                    indegree++;
                    List<Task> parentsChildren = childrenMap.getOrDefault(parent, new ArrayList<>());
                    parentsChildren.add(cur);
                    childrenMap.put(parent, parentsChildren);
                }
            }
            indegreeMap.put(cur, indegree);
        }
    }
    public List<Task> executeTasks() {
        Map<Task, Integer> indegreeMap = new HashMap<>(); // task->its indegree
        Map<Task, List<Task>> childrenMap = new HashMap<>(); // task->its children
        constructGraph(indegreeMap, childrenMap);

//        for (Map.Entry<Task, Integer> e : indegreeMap.entrySet()) {
//            System.out.println("indegree " + e.getKey().id + " " + e.getValue());
//        }

        // initialize pq
        List<Task> result = new ArrayList<>();
        PriorityQueue<Task> pq = new PriorityQueue<>(new taskComparator());
        for (Map.Entry<Task, Integer> e : indegreeMap.entrySet()) {
            if (e.getValue().intValue() == 0) {
                pq.offer(e.getKey());
            }
        }
        while (!pq.isEmpty()) {
            Task cur = pq.poll();
            result.add(cur);
            System.out.println(cur.id);
            if (childrenMap.get(cur) == null) continue; // avoid npe!!
            for (Task child : childrenMap.get(cur)) {
                Integer indegree = indegreeMap.get(child);
                indegree--;
                indegreeMap.put(child, indegree);
                if (indegree == 0) {
                    pq.offer(child);
                }
            }
        }
        return result;
    }
    private class taskComparator implements Comparator<Task> {
        @Override
        public int compare(Task a, Task b) {
            if (a.priority == b.priority) {
                return 0;
            }
            return a.priority > b.priority ? -1 : 1;
        }
    }
    public void test() {
        Task one = new Task(10, 1);
        Task zero = new Task(10, 0);
        Task two = new Task(5, 2);
        Task three = new Task(6, 3);
        Task four = new Task(7, 4);
        Task five = new Task(8, 5);
        two.prerequisites.add(zero);
        three.prerequisites.add(one);
        three.prerequisites.add(two);
        four.prerequisites.add(one);
        five.prerequisites.add(four);

        this.addTask(one);
        this.addTask(two);
        this.addTask(three);
        this.addTask(four);
        this.addTask(five);
        this.executeTasks();
    }
}
