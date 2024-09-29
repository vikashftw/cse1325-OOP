package customer;

import product.Media;

/**
 * Represents a student with a name, ID, email, and associated account.
 * The account can either be an Unlimited or Alacarte type.
 * 
 * @author Vikash Mall
 * @version 1.0
 * @since 1.0
 */
public class Student {

    private String name;
    private int id;
    private String email;
    private Account account;

    /**
     * Constructs a Student with a specified name, id, email, and account type.
     * 
     * @param name      the name of the student
     * @param id        the student ID
     * @param email     the email of the student
     * @param unlimited if true, assigns an Unlimited account; otherwise, assigns an Alacarte account
     * @throws IllegalArgumentException if the email is not a UTA email address
     * @since 1.0
     */
    public Student(String name, int id, String email, boolean unlimited) {
        if (!email.endsWith("@uta.edu") && !email.endsWith("@mavs.uta.edu")) {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }
        this.name = name;
        this.id = id;
        this.email = email;
        
        if (unlimited) {
            this.account = new Unlimited();
        } else {
            this.account = new Alacarte();
        }
    }

    /**
     * Requests media to be played for the student.
     * 
     * @param media the Media object to be played
     * @return the result of attempting to play the media
     * @since 1.0
     */
    public String requestMedia(Media media) {
        return account.play(media);
    }

    /**
     * Returns the student's account.
     * 
     * @return the Account object associated with the student
     * @since 1.0
     */
    public Account getAccount() {
        return this.account;
    }

    /**
     * Returns a string representation of the student, including name, id, email, and account number.
     * 
     * @return a string representing the student
     * @since 1.0
     */
    @Override
    public String toString() {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";
    }
}
