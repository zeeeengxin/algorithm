package other;
import java.util.*;

public class PrintSkills {
    public String printSkills (Skill[] array){
        Map<String, Subject> subjects = new HashMap<>();
        for (Skill s : array) {
            String subjectName = s.getSubject();
            Subject subject = subjects.getOrDefault(subjectName, new Subject(subjectName));
            subject.addSkill(s);
            subjects.put(subjectName,subject);
        }
        // for each subject, get subject priority
        // for each sorted subject, get list of skills
        return null;
    }
}
