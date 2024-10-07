package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
     * Constructs a Student object by reading values from a BufferedReader.
     * Reads name, id, email, and then the class name of the Account type before reconstructing the account.
     *
     * @param br BufferedReader object for reading the student fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public Student(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        this.email = br.readLine();

        String accountType = br.readLine();
        switch (accountType) {
            case "customer.Unlimited":
                this.account = new Unlimited(br);
                break;
            case "customer.Alacarte":
                this.account = new Alacarte(br);
                break;
            default:
                throw new IOException("Unknown account type: " + accountType);
        }
    }

    /**
     * Saves the student fields to a file using the provided BufferedWriter.
     * Writes the name, ID, email, and the type and fields of the associated account.
     *
     * @param bw BufferedWriter object for writing the student fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(Integer.toString(id) + "\n");
        bw.write(email + "\n");
        bw.write(account.getClass().getName() + "\n");

        account.save(bw);
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
