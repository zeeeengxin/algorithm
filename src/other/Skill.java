package other;

public class Skill {
    private final String subject;
    private final String name;
    private final int priority;
    public Skill (String s, String n, int p) {
        subject = s;
        name = n;
        priority = p;
    }
    public String getSubject() {
        return subject;
    }
    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }
}
