package semanticprocessing;

import java.io.Serializable;


/**
 * Contains the result of searching a facultyMember for a given list keywords.
 * Stores info on how many times each of those given keywords show up on the
 * facultyMember.
 * Instances of this class are created mainly be the search class.
 * @author Isiah
 */
public class Result implements Comparable<Result> ,Serializable{

    /** The facultyMember whose results are in this instance. */
    // facultyMember contains all the pages of URLs of one faculty member.
    //It has the home page and all the links linking to more info on
    //one faculty member.
    private FacultyMember facultyMember;

    /** The relevancy score given to this facultyMember. Must be positive */
    private double score;

    /**
     * Constructs a new facultyMember with its score value.
     * @param facultyMember The facultyMember whose results are stored in this
     * instance.
     * @param score The relevancy score given to this facultyMember.
     */
    public Result(FacultyMember facultyMember, double score) {
        this.facultyMember = facultyMember;
        this.score = score;
    }

    /**
     * Gets the facultyMember whose results are stored in this instance.
     * @return A facultyMember instance associated with this result.
     */
    public final FacultyMember getPage() {
        return facultyMember;
    }

    /**
     * Retrieves the score of this facultyMember.
     * @return <code>score</code> - An integer representing the relevancy score
     * of this facultyMember.
     */
    public final double getScore() {
        return score;
    }

    /**
     * Compares the score of this Result object, against the parameter's Result
     * object.
     * @param other The other object to compare to.
     * @return A positive number if the current object has a higher score than
     *  <code>other</code>. A negative otherwise, and 0 if equal.
     */
    public int compareTo(Result other) {
        // Nested if statements to convert double to int.
        if (getScore() > other.getScore()) {
            return 1;
        } else {
            if (getScore() < other.getScore()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Returns the Result Main URL and Score in a String.
     * @return A String of (mainURL + " " + 0)
     */
    @Override
    public String toString(){
        return facultyMember.getMainURL().toString() + " " + score;
    }
}