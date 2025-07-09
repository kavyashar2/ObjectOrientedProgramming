package edu.scu.csen160.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab3 extends JFrame {

    private JTextField nameField;
    private JTextField studentIDField;
    private JRadioButton pizzaButton, burgerButton, saladButton;
    private ButtonGroup foodGroup;

    public lab3() {

        setTitle("Student Information Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        nameField = new JTextField(20);

        JLabel studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setFont(new Font("Arial", Font.BOLD, 12));
        studentIDField = new JTextField(10);

        JLabel foodLabel = new JLabel("Favorite Food:");
        foodLabel.setFont(new Font("Arial", Font.BOLD, 12));

        pizzaButton = new JRadioButton("Pizza");
        burgerButton = new JRadioButton("Burger");
        saladButton = new JRadioButton("Salad");

        foodGroup = new ButtonGroup();
        foodGroup.add(pizzaButton);
        foodGroup.add(burgerButton);
        foodGroup.add(saladButton);
        
        Dimension bd = new Dimension(20, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(bd);        
        submitButton.setBackground(Color.GREEN);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(bd);
        cancelButton.setBackground(Color.RED);
        cancelButton.setOpaque(true);
        cancelButton.setBorderPainted(false);

        add(nameLabel);
        add(nameField);
        add(studentIDLabel);
        add(studentIDField);
        add(foodLabel);
        add(new JLabel());

        add(pizzaButton);
        add(burgerButton);
        add(saladButton);

        add(submitButton);
        add(cancelButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateInput();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
    }

    private void validateInput() {
        String name = nameField.getText();
        String studentID = studentIDField.getText();
        String selectedFood = getSelectedFood();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name.");
            return;
        }

        if (!name.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Name should only contain letters.");
            return;
        }

        if (studentID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your Student ID.");
            return;
        }

        if (!studentID.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Student ID should only contain numbers.");
            return;
        }

        if (selectedFood == null) {
            JOptionPane.showMessageDialog(this, "Please select a favorite food.");
            return;
        }

        displayInfo(name, studentID, selectedFood);
    }

    private String getSelectedFood() {
        if (pizzaButton.isSelected()) {
            return "Pizza";
        } else if (burgerButton.isSelected()) {
            return "Burger";
        } else if (saladButton.isSelected()) {
            return "Salad";
        } else {
            return null;
        }
    }

    private void displayInfo(String name, String studentID, String favoriteFood) {
        JFrame infoFrame = new JFrame("Student Information");
        infoFrame.setSize(300, 200);
        infoFrame.setLayout(new GridLayout(3, 1));

        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel studentIDLabel = new JLabel("Student ID: " + studentID);
        JLabel favoriteFoodLabel = new JLabel("Favorite Food: " + favoriteFood);

        infoFrame.add(nameLabel);
        infoFrame.add(studentIDLabel);
        infoFrame.add(favoriteFoodLabel);

        infoFrame.setVisible(true);
    }

    private void clearForm() {
        nameField.setText("");
        studentIDField.setText("");
        foodGroup.clearSelection();
    }

    public static void main(String[] args) {
        lab3 form = new lab3();
        form.setVisible(true);
    }
}
