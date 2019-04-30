package other;
import java.util.*;

public class PersonWithCandy {
    private Map<String, Integer> candies;
    private Set<String> likes;
    private Set<String> dislikes;

    public PersonWithCandy(Map<String, Integer> c, Set<String> l, Set<String> dis) {
        for (Iterator<String> it = l.iterator(); it.hasNext();) {
            String s = it.next();
            if (dis.contains(s)) {
                throw new IllegalArgumentException("Likes and Dislikes should not contain the same kind of candy!");
            }
        }
        candies = c;
        likes = l;
        dislikes = dis;
    }

    public PersonWithCandy() {
        candies = new HashMap<>();
        likes = new HashSet<>();
        dislikes = new HashSet<>();
    }
    public void addCandies(String candy, int n) {
        int count = candies.getOrDefault(candy, 0);
        candies.put(candy, count + n);
    }
    public void addLikes(String candy) {
        if (dislikes.contains(candy)) {
            throw new IllegalArgumentException("Likes and Dislikes should not contain the same kind of candy!");
        }
        likes.add(candy);
    }
    public void removeLikes(String candy) {
        likes.remove(candy);
    }
    public void addDislikes(String candy) {
        if (likes.contains(candy)) {
            throw new IllegalArgumentException("Likes and Dislikes should not contain the same kind of candy!");
        }
        dislikes.add(candy);
    }
    public void removeDislikes(String candy) {
        dislikes.remove(candy);
    }
    public int giveAwayCandies(String candy, int n) {
        if (!candies.containsKey(candy) || likes.contains(candy)) {
            return 0;
        }
        int count = candies.get(candy);
        if (dislikes.contains(candy) || n >= count) {
            candies.remove(candy);
            return count;
        } else {
            candies.put(candy, count - n);
            return n;
        }
    }
    public void askForCandies(PersonWithCandy p, String candy, int n) {
        int count = p.giveAwayCandies(candy, n);
        if (count > 0) {
            addCandies(candy, count);
        }
    }
}
