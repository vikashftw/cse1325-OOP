package moes;

import java.util.ArrayList;

import customer.Alacarte;
import customer.Student;
import customer.Unlimited;
import product.Media;

/**
 * Moes is the main interface class that provides access to media and student management.
 * It holds the library of media and a list of students.
 * 
 * @author Vikash Mall
 * @version 0.2
 * @since 1.0
 */
public class Moes {
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    /**
     * Adds a media object to the library.
     * 
     * @param media the Media object to be added
     * @since 1.0
     */
    public void addMedia(Media media) {
        library.add(media);
    }

    /**
     * Returns a formatted list of media objects in the library.
     * 
     * @return a formatted string representing the media list
     * @since 1.0
     */
    public String getMediaList() {
        String mediaList = "";
        for (int i = 0; i < library.size(); i++) {
            mediaList += i + ") " + library.get(i).toString() + "\n";
        }
        return mediaList;
    }

    /**
     * Adds a student object to the list of customers.
     * 
     * @param student the Student object to be added
     * @since 1.0
     */
    public void addStudent(Student student) {
        customers.add(student);
    }

    /**
     * Returns a formatted list of students.
     * 
     * @return a formatted string representing the student list
     * @since 1.0
     */
    public String getStudentList() {
        String studentList = "";
        for (int i = 0; i < customers.size(); i++) {
            studentList += i + ") " + customers.get(i).toString() + "\n";
        }
        return studentList;
    }

    /**
     * Gets the points of the student's account.
     * 
     * @param studentIndex the index of the student
     * @return the points remaining or a message for Unlimited accounts
     * @throws UnsupportedOperationException if the Account is an unknown subclass
     * @since 1.0
     */
    public int getPoints(int studentIndex) {
        Student student = customers.get(studentIndex);
        if (student.getAccount() instanceof Alacarte) {
            return ((Alacarte) student.getAccount()).getPointsRemaining();
        } else if (student.getAccount() instanceof Unlimited) {
            return Integer.MAX_VALUE;
        } else {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    /**
     * Buys points for a student's Alacarte account.
     * 
     * @param studentIndex the index of the student
     * @param points the points to be added
     * @return a message revealing the new point balance or if the student has Unlimited
     * @throws UnsupportedOperationException if the Account is an unknown subclass
     * @since 1.0
     */
    public String buyPoints(int studentIndex, int points) {
        Student student = customers.get(studentIndex);
        if (student.getAccount() instanceof Alacarte) {
            Alacarte alacarte = (Alacarte) student.getAccount();
            alacarte.buyPoints(points);
            return student.toString() + " now has " + alacarte.getPointsRemaining() + " points.";
        } else if (student.getAccount() instanceof Unlimited) {
            return student.toString() + " has an unlimited account and needs no additional points!";
        } else {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    /**
     * Plays media for the selected student.
     * 
     * @param studentIndex the index of the student
     * @param mediaIndex the index of the media
     * @return the result of playing the media
     * @since 1.0
     */
    public String playMedia(int studentIndex, int mediaIndex) {
        Student student = customers.get(studentIndex);
        Media media = library.get(mediaIndex);
        return student.requestMedia(media);
    }
}
