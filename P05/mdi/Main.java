package mdi;

import moes.Moes;
import product.Media;

import java.util.Scanner;

import customer.Student;

public class Main {
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;
    private Scanner in = new Scanner(System.in);

    // New Variables that help a lot in formatting the output
    private String formatStart = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
    private String formatEnd = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

    private void addStudent() {
        System.out.print("Student name? ");
        String name = in.nextLine();
        System.out.print("Student ID? ");
        int id = Integer.parseInt(in.nextLine());
        System.out.print("Student email? ");
        String email = in.nextLine();
        System.out.print("(a)lacarte or (u)nlimited? ");
        char account = in.nextLine().charAt(0);
        Student newStudent = new Student(name, id, email, account == 'u');
        moes.addStudent(newStudent);
        output = formatStart + "Added student " + newStudent.toString() + formatEnd;
    }
    private void listStudents() {
        output = formatStart + moes.getStudentList() + formatEnd;
    }

    private void addMedia() {
        System.out.print("Title? ");
        String title = in.nextLine();
        System.out.print("URL? ");
        String url = in.nextLine();
        System.out.print("Points? ");
        int points = Integer.parseInt(in.nextLine());
        Media newMedia = new Media(title, url, points);
        moes.addMedia(newMedia);
        output = formatStart + "Added media "+ newMedia.toString() + formatEnd;
    }
    private void playMedia() {
        System.out.println(moes.getStudentList());
        System.out.print("Student number? ");
        int studentIndex = Integer.parseInt(in.nextLine());
        System.out.println(moes.getMediaList());
        System.out.print("Media number? ");
        int mediaIndex = Integer.parseInt(in.nextLine());
        String nowPlaying = moes.playMedia(studentIndex, mediaIndex);
        output = formatStart + nowPlaying + formatEnd;
    }
    private void listMedia() {
        output = formatStart + moes.getMediaList() + formatEnd;
    }
    private void listAvailablePoints() {
        System.out.print("Student number? ");
        int studentIndex = Integer.parseInt(in.nextLine());
        output = formatStart + "Available Points: " + moes.getPoints(studentIndex) + formatEnd;
    }
    private void buyPoints() {
        System.out.print("Student number? ");
        int studentIndex = Integer.parseInt(in.nextLine());
        int currentPoints = moes.getPoints(studentIndex);
        System.out.println("Current points: " + currentPoints);
        System.out.print("How many additional points would you like to buy? ");
        int pointsToBuy = Integer.parseInt(in.nextLine());
        if (pointsToBuy < 0) {
            output = formatStart + "Cannot purchase negative points." + formatEnd;
        } else {
            output = formatStart + moes.buyPoints(studentIndex, pointsToBuy) + formatEnd;
        }
    }

    public Main() {
        this.moes = new Moes();
        this.menu = new Menu();
        this.output = "";
        this.running = true;
        
        menu.addMenuItem(new MenuItem("Exit\n",                 () -> endApp()));
        menu.addMenuItem(new MenuItem("Play media",             () -> playMedia()));
        menu.addMenuItem(new MenuItem("List media",             () -> listMedia()));
        menu.addMenuItem(new MenuItem("List available points",  () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy points",             () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Add media\n",            () -> addMedia()));
        menu.addMenuItem(new MenuItem("List all students",      () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add a student",          () -> addStudent()));
    }

    public static void main(String[] args) {
        new Main().mdi();
    }

    private static String clearScreen = "";
    public void mdi() {
        while(running) {
            System.out.println(clearScreen);
            System.out.println("                      \\\\\\///");
            System.out.println("                     / _  _ \\");
            System.out.println("                   (| (.)(.) |)");
            System.out.println(".----------------.OOOo--()--oOOO.---------------.");
            System.out.println("|                                               |");
            System.out.println("|    Mavs Online Entertainment System (MOES)    |");
            System.out.println("|    Version 0.3.0           ©2024 Prof Rice    |");
            System.out.println("|                                               |");
            System.out.println("'-----------------------------------------------'\n\n");

            System.out.print(menu);
            System.out.println(output);
            System.out.print("Selection? ");
            int choice = Integer.parseInt(in.nextLine());

            try {
                menu.run(choice);
            } catch (Exception e) {
                System.out.println("Error: Invalid option. Please try again.");
            }
            clearScreen = "\n".repeat(255);
        }
    }
    private void endApp() {
        running = false;
    }
}
