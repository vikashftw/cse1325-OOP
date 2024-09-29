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

    private void addStudent() {
        System.out.print("Student name? ");
        String name = in.nextLine();
        System.out.print("Student ID? ");
        int id = Integer.parseInt(in.nextLine());
        System.out.print("Student email? ");
        String email = in.nextLine();
        System.out.print("(a)lacarte or (u)nlimited? ");
        char account = in.nextLine().charAt(0);
        moes.addStudent(new Student(name, id, email, account == 'u'));
    }
    private void listStudents() {
        System.out.println(moes.getStudentList());
    }

    private void addMedia() {
        System.out.print("Title? ");
        String title = in.nextLine();
        System.out.print("URL? ");
        String url = in.nextLine();
        System.out.print("Points? ");
        int points = Integer.parseInt(in.nextLine());
        moes.addMedia(new Media(title, url, points));
    }
    private void playMedia() {
        System.out.println(moes.getStudentList());
        System.out.print("Student number? ");
        int studentIndex = Integer.parseInt(in.nextLine());
        System.out.println(moes.getMediaList());
        System.out.print("Media number? ");
        int mediaIndex = Integer.parseInt(in.nextLine());
        System.out.println(moes.playMedia(studentIndex, mediaIndex));
    }
    private void listMedia() {
        System.out.println(moes.getMediaList());
    }
    private void listAvailablePoints() {
        System.out.print("Student number? ");
        int studentIndex = Integer.parseInt(in.nextLine());
        System.out.println(moes.getPoints(studentIndex));
    }
    private void buyPoints() {
        System.out.print("Student number? ");
        int studentIndex = Integer.parseInt(in.nextLine());
        int currentPoints = moes.getPoints(studentIndex);
        System.out.println("Current points: " + currentPoints);
        System.out.print("How many additional points would you like to buy? ");
        int pointsToBuy = Integer.parseInt(in.nextLine());
        if (pointsToBuy < 0) {
            System.out.println("Cannot purchase negative points.");
        } else {
            System.out.println(moes.buyPoints(studentIndex, pointsToBuy));
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
        menu.addMenuItem(new MenuItem("Add a student",        () -> addStudent()));
    }

    public static void main(String[] args) {
        new Main().mdi();
    }

    public void mdi() {
        while(running) {
            System.out.println(menu);
            System.out.print("Selection? ");
            int choice = Integer.parseInt(in.nextLine());

            try {
                menu.run(choice);
            } catch (Exception e) {
                System.out.println("Error: Invalid option. Please try again.");
            }
        }
    }
    private void endApp() {
        running = false;
    }
}
