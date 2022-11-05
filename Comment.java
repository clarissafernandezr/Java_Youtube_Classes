/**
 * class comments in a video.
 * @author Clarissa Fernandez
 * @version 1
 */
public class Comment implements Comparable<Comment>, Likeable {
    private boolean isSpam;
    private int likes;
    private int dislikes;
    private String value;
    /**
     * setter for isSpam.
     * @param isSpam boolean determines if spam or not
     */
    public void setIsSpam(boolean isSpam) {
        this.isSpam = isSpam;
    }
    /**
     * setter for likes.
     * @param likes int number of likes
     */
    public void setLikes(int likes) {
        if (likes > 0) {
            this.likes = likes;
        }
    }
    /**
     * setter for dislikes.
     * @param dislikes number of dislikes
     */
    public void setDislikes(int dislikes) {
        if (dislikes > 0) {
            this.dislikes = dislikes;
        }
    }
    /**
     * setter for value.
     * @param value string value of comment
     */
    public void setValue(String value) {
        if (value != null) {
            this.value = value;
        }
    }
    /**
     * getter for isSpam.
     * @return true if spam, vice versa
     */
    public boolean getIsSpam() {
        return this.isSpam;
    }
    /**
     * getter for dislikes.
     * @return int dislikes
     */
    public int getDislikes() {
        return this.dislikes;
    }
    /**
     * getter for likes.
     * @return int likes
     */
    public int getLikes() {
        return this.likes;
    }
    /**
     * getter for value.
     * @return string value of comment
     */
    public String getValue() {
        return this.value;
    }
    /**
     * comment constructor.
     * @param likes int number of likes
     * @param dislikes int number of dislikes
     * @param value string value of comment
     * @param isSpam boolean true if spam false if not
     */
    public Comment(int likes, int dislikes, String value, boolean isSpam) {
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
        if (value == null) {
            this.value = "";
        } else {
            this.value = value;
        }
        this.isSpam = isSpam;
    }
    /**
     * method to compare two comment objects.
     * @param comment comment object.
     * @return int with comparison
     */
    public int compareTo(Comment comment) {
        int likefactor2 = comment.getLikes() - comment.getDislikes();
        int likefactor1 = this.getLikes() - this.getDislikes();
        if (likefactor1 > likefactor2) {
            return 1;
        } else if (likefactor2 > likefactor1) {
            return -1;
        } else {
            return 0;
        }
    }
    /**
     * overrides default string method.
     * @return string
     */
    public String toString() {
        return getValue() + " " + getLikes() + " likes, Spam: " + getIsSpam() + ".";
    }
    /**
     * overrides default equals method.
     * @return boolean
     * @param other object
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Comment) {
            Comment comment1 = (Comment) other;
            return comment1.getIsSpam() == this.getIsSpam()
                && comment1.getLikes() == this.getLikes()
                && comment1.getValue() == this.getValue()
                && comment1.getDislikes() == this.getDislikes();
        }
        return false;
    }
}