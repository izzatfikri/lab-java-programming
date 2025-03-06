/*
        Subject code : CSEB5133 Java Programming
        Section: 01A
        Student name : Muhammad Izzat Fikri Bin Zurilan
        Student ID no: SW01082295
        Question no  : Lab-2 (Question 1)
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        BMICalculator b1 = new BMICalculator();
    }
}

class BMICalculator extends JFrame {
    private JTextField heightField;
    private JTextField weightField;
    private JLabel resultLabel;
    private JLabel categoryLabel;
    private JLabel imageLabel;
    private ImageIcon underweightIcon;
    private ImageIcon normalIcon;
    private ImageIcon overweightIcon;
    private ImageIcon obeseIcon;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLayout(new GridLayout(1, 2));

        // Load images
        loadImages();

        // Left Panel (Input)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        inputPanel.add(new JLabel("Height (cm):"));
        heightField = new JTextField();
        inputPanel.add(heightField);

        inputPanel.add(new JLabel("Weight (kg):"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate BMI");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
        inputPanel.add(calculateButton);

        // Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        inputPanel.add(clearButton);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        inputPanel.add(exitButton);

        // Right Panel (Result)
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));

        // Panel for labels
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1));
        resultLabel = new JLabel("BMI: ");
        categoryLabel = new JLabel("Category: ");
        labelPanel.add(resultLabel);
        labelPanel.add(categoryLabel);
        resultPanel.add(labelPanel, BorderLayout.NORTH);

        // Panel for image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        resultPanel.add(imageLabel, BorderLayout.CENTER);

        // Add panels to frame
        add(inputPanel);
        add(resultPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadImages() {
        try {
            // Load and scale images from the resources folder
            underweightIcon = loadAndScaleImage("/images/underweight.png");
            normalIcon = loadAndScaleImage("/images/normal.png");
            overweightIcon = loadAndScaleImage("/images/overweight.png");
            obeseIcon = loadAndScaleImage("/images/obese.png");
        } catch (Exception e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    }

    private ImageIcon loadAndScaleImage(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        return new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    }

    private void clearFields() {
        heightField.setText("");
        weightField.setText("");
        resultLabel.setText("BMI: ");
        categoryLabel.setText("Category: ");
        imageLabel.setIcon(null);
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText()) / 100; // convert cm to m
            double weight = Double.parseDouble(weightField.getText());

            double bmi = weight / (height * height);

            resultLabel.setText(String.format("BMI: %.2f", bmi));

            String category;
            ImageIcon categoryIcon;

            if (bmi < 18.5) {
                category = "Underweight";
                categoryIcon = underweightIcon;
            } else if (bmi < 25) {
                category = "Normal Weight";
                categoryIcon = normalIcon;
            } else if (bmi < 30) {
                category = "Overweight";
                categoryIcon = overweightIcon;
            } else {
                category = "Obese";
                categoryIcon = obeseIcon;
            }

            categoryLabel.setText("Category: " + category);
            imageLabel.setIcon(categoryIcon);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
