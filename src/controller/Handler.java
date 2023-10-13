/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import common.PersonManagement;
import java.io.IOException;
import java.util.List;
import model.Person;
import view.Menu;

/**
 *
 * @author huynh
 */
public class Handler extends Menu<String> {

    static String[] mc = {"Find person information", "Copy text to new file", "Exit"};

    private Library library;
    private PersonManagement personManagement;

    public Handler() {
        super("===== FILE PROCESSING =====", mc);
        library = new Library();
        personManagement = new PersonManagement();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String pathFile = library.getString("Enter Path: ");
                int minSalary = library.getInt("Enter minimun salary: ");

                try {
                    List<Person> result = personManagement.readFromFile(pathFile, minSalary);
                    System.out.println("Name\tAddress\tMoney");
                    for (Person person : result) {
                        System.out.println(person);
                    }
                } catch (Exception e) {
                }
                break;
            case 2:
                String fileSrc = library.getString("Enter source: ");
                String newFile = library.getString("Enter new file name: ");

                try {
                    personManagement.copyFile(fileSrc, newFile);
                } catch (IOException ex) {
                }

                break;

            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Your choice invalid! Pls input another choice");
        }
    }
}

