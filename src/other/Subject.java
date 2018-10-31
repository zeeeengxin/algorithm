package other;
import java.util.*;

public class Subject {
    private Set<Skill> skills;
    private final String name;
    public Subject(String name) {
        this.name = name;
        skills = new HashSet<>();
    }
    public Subject(String name, Set<Skill> skills) {
        this.name = name;
        this.skills = skills;
    }
    public boolean addSkill(Skill s) {
        if (!s.getSubject().equals(this.name)) {
            return false;
        }
        skills.add(s);
        return true;
    }
    public int getCount() {
        return skills.size();
    }
    public String printSkills() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
