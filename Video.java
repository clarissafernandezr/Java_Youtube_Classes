import java.util.ArrayList;
/**
 * Video class for video objects.
 * @author Clarissa Fernandez
 * @version 1
 */
public class Video implements Likeable {
    private ArrayList<Comment> comments;
    private double length;
    private int likes;
    private int dislikes;
    /**
     * Video constructor.
     * @param length length of video
     * @param likes number of likes of video
     * @param dislikes number of dislikes of video
     */
    public Video(double length, int likes, int dislikes) {
        this.comments = new ArrayList<>();
        if (length > 0 && length < 60) {
            this.length = length;
        } else {
            this.length = 0;
        }
        if (likes > 0) {
            this.likes = likes;
        } else {
            this.likes = 0;
        }
        if (dislikes > 0) {
            this.dislikes = dislikes;
        } else {
            this.dislikes = 0;
        }
    }
    /**
     * setter for comments.
     * @param comments arraylist of comments
     */
    public void setComments(ArrayList<Comment> comments) {
        if (comments != null) {
            this.comments = comments;
        }
    }
    /**
     * setter for length.
     * @param length length of video
     */
    public void setLength(double length) {
        if (length > 0.00 && length < 60.00) {
            this.length = length;
        }
    }
    /**
     * setter for likes.
     * @param likes likes of video
     */
    public void setLikes(int likes) {
        if (likes > 0) {
            this.likes = likes;
        }
    }
    /**
     * setter for dislikes.
     * @param dislikes dislikes of video
     */
    public void setDislikes(int dislikes) {
        if (dislikes > 0) {
            this.dislikes = dislikes;
        }
    }
    //getters
    /**
     * getter for comments.
     * @return arraylist of comments
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }
    /**
     * getter for length.
     * @return double length
     */
    public double getLength() {
        return this.length;
    }
    /**
     * getter for likes.
     * @return int likes
     */
    public int getLikes() {
        return this.likes;
    }
    /**
     * getter for dislikes.
     * @return int dislikes
     */
    public int getDislikes() {
        return this.dislikes;
    }
    /**
     * create comment method to create comments.
     * @param comment comment object
     */
    public void createComment(Comment comment) {
        getComments().add(comment);
    }
    /**
     * remove comment method to remove a comment.
     * @param comment comment object
     * @return true or false if removed
     */
    public boolean removeComment(Comment comment) {
        int test = 0;
        for (int x = 0; x < getComments().size(); x++) {
            if (getComments().get(x).equals(comment)) {
                getComments().remove(comment);
                test = 1;
            }
        }
        if (test == 1) {
            return true;
        }
        return false;
    }
    /**
     * method for spam comments array.
     * @return array of spam
     */
    public  ArrayList<Comment> spamComments() {
        ArrayList<Comment> spamComments = new ArrayList<>();
        for (int x = 0; x < getComments().size(); x++) {
            Comment com = getComments().get(x);
            if (com.getIsSpam()) {
                spamComments.add(com);
            }
        }
        return spamComments;
    }
    /**
     * method to change comments to normal array.
     * @return normal array
     */
    public Object[] toArray() {
        Object[] newArray = this.comments.toArray();
        return newArray;
    }
    /**
     * method for top and worst comments.
     * @return comment array with top and worst.
     */
    public Comment[] topAndWorstComment() {
        int topLikeFactor = getComments().get(0).getLikes() -  getComments().get(0).getDislikes();
        Comment topLikeComment = getComments().get(0);
        int worstLikeFactor = getComments().get(0).getLikes() -  getComments().get(0).getDislikes();
        Comment worstLikeComment = getComments().get(0);
        for (int x = 1; x < getComments().size(); x++) {
            Comment comment1 = getComments().get(x);
            int likeF = comment1.getLikes() - comment1.getDislikes();
            if (likeF > topLikeFactor) {
                topLikeFactor = likeF;
                topLikeComment = comment1;
            } else if (likeF < worstLikeFactor) {
                worstLikeFactor = likeF;
                worstLikeComment = comment1;
            }
        }
        //AGREGA IF TIE
        Comment[] finalArray = new Comment[2];
        finalArray[0] = topLikeComment;
        finalArray[1] = worstLikeComment;
        return finalArray;
    }
    /**
     * to string override method.
     * @return String.
     */
    public String toString() {
        return "This video has " + getComments().size() + " comments and is " + getLength() + " long.";
    }
    /**
     * equals override default.
     * @return boolean true or false
     * @param other object
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Video) {
            Video video1 = (Video) other;
            return video1.getComments().size() == this.getComments().size()
                && video1.getLength() == this.getLength()
                && video1.getLikes() == this.getLikes()
                && video1.getDislikes() == this.getDislikes();
        }
        return false;
    }
}