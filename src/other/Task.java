package other;
import java.util.*;

public class Task {
    int priority;
    int id;
    Set<Task> prerequisites;
    public Task(int p, int i, Set<Task> pre) {
        priority = p;
        id = i;
        prerequisites = pre;
    }
    public Task(int p, int i) {
        priority = p;
        id = i;
        prerequisites = new HashSet<>();
    }
}
