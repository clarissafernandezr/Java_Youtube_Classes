/**
 * driver class to call other classes.
 * @author Clarissa Fernandez
 * @version 1
 */
public class Youtube {
    /**
     * main method to create objects and call  methods.
     * @param args default string array args
     */
    public static void main(String[] args) {
        Video v1 = new Video(-2.0, 6, 2);
        Video v2 = new Video(9.0, 10, 3);
        Comment c1 = new Comment(800, 23, "Omg so cool1!", false);
        Comment c3 = new Comment(800, 23, "Omg so cool2!", false);
        Comment c2 = new Comment(1000, 43, "Omg not cool1!", true);
        Comment c4 = new Comment(1000, 43, "Omg not cool!2", true);
        v1.createComment(c1);
        v1.createComment(c2);
        v1.createComment(c3);
        v1.createComment(c4);
        v1.spamComments();
        v1.setDislikes(0);
        v1.setDislikes(4);
        v1.setLikes(5);
        v1.setLength(5.0);
        v1.setComments(null);
        System.out.println(c2.compareTo(c1));
        for (Object e:v1.toArray()) {
            System.out.println(e.toString());
        }
        System.out.println(1);
        for (Comment e:v1.topAndWorstComment()) {
            System.out.println(e.toString());
        }
        System.out.println(v1.toString());
        System.out.println(v1.equals(v2));
        System.out.println(c1.equals(c3));
    }
}
