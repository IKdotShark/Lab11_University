package lab_11;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;

public class lab11 {
    private JFrame frame;
    private JComboBox<String> comboBox;

    public lab11() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        comboBox = new JComboBox<String>();
        comboBox.setBounds(10, 10, 180, 20);
        comboBox.addItem("ex1");
        comboBox.addItem("ex2");
        comboBox.addItem("ex3");
        comboBox.addItem("ex4");
        comboBox.addItem("ex5");
        frame.add(comboBox);

        JButton button = new JButton("Выбрать");
        button.setBounds(200, 10, 80, 20);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedExercise = (String) comboBox.getSelectedItem();
                if (selectedExercise.equals("ex1")) {
                    openExercise1();
                } else if (selectedExercise.equals("ex2")) {
                    openExercise2();
                } else if (selectedExercise.equals("ex3")) {
                    openExercise3();
                } else if (selectedExercise.equals("ex4")) {
                    openExercise4();
                } else if (selectedExercise.equals("ex5")) {
                    openExercise5();
                }
            }
        });

        frame.setVisible(true);
    }

    private void openExercise1() {
        JFrame exerciseFrame = new JFrame("Exercise 1");
        exerciseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exerciseFrame.setSize(400, 200);
        exerciseFrame.setLayout(null);
        exerciseFrame.setLocationRelativeTo(frame);

        JLabel label1 = new JLabel("Текст (макс. 25 символов):");
        label1.setBounds(10, 10, 180, 20);
        exerciseFrame.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setBounds(200, 10, 180, 20);
        textField1.setDocument(new JTextFieldLimit(25));
        exerciseFrame.add(textField1);

        JLabel label2 = new JLabel("Путь к файлу:");
        label2.setBounds(10, 40, 180, 20);
        exerciseFrame.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setBounds(200, 40, 180, 20);
        exerciseFrame.add(textField2);

        JButton saveButton = new JButton("Сохранить");
        saveButton.setBounds(140, 80, 120, 20);
        exerciseFrame.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                String filePath = textField2.getText();
                writeToFile(text, filePath);
                exerciseFrame.dispose();
            }
        });

        exerciseFrame.setVisible(true);
    }

    private void openExercise2() {
        JFrame exerciseFrame = new JFrame("Exercise 2");
        exerciseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exerciseFrame.setSize(400, 300);
        exerciseFrame.setLayout(null);
        exerciseFrame.setLocationRelativeTo(frame);

        JLabel label1 = new JLabel("Имя:");
        label1.setBounds(10, 10, 80, 20);
        exerciseFrame.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setBounds(100, 10, 250, 20);
        exerciseFrame.add(textField1);

        JLabel label2 = new JLabel("Фамилия:");
        label2.setBounds(10, 40, 80, 20);
        exerciseFrame.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setBounds(100, 40, 250, 20);
        exerciseFrame.add(textField2);

        JLabel label3 = new JLabel("Отчество:");
        label3.setBounds(10, 70, 80, 20);
        exerciseFrame.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(100, 70, 250, 20);
        exerciseFrame.add(textField3);

        JLabel label4 = new JLabel("Дата рождения:");
        label4.setBounds(10, 100, 120, 20);
        exerciseFrame.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(140, 100, 210, 20);
        exerciseFrame.add(textField4);

        JLabel label5 = new JLabel("Учебная группа:");
        label5.setBounds(10, 130, 120, 20);
        exerciseFrame.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(140, 130, 210, 20);
        exerciseFrame.add(textField5);

        JButton saveButton = new JButton("Записать");
        saveButton.setBounds(140, 170, 120, 20);
        exerciseFrame.add(saveButton);

        JButton loadButton = new JButton("Загрузить");
        loadButton.setBounds(140, 200, 120, 20);
        exerciseFrame.add(loadButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filePath = "data.txt";
                String data = textField1.getText() + "," +
                        textField2.getText() + "," +
                        textField3.getText() + "," +
                        textField4.getText() + "," +
                        textField5.getText();
                writeToFile(data, filePath);
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filePath = "data.txt";
                String data = readFromFile(filePath);
                String[] parts = data.split(",");
                if (parts.length == 5) {
                    textField1.setText(parts[0]);
                    textField2.setText(parts[1]);
                    textField3.setText(parts[2]);
                    textField4.setText(parts[3]);
                    textField5.setText(parts[4]);
                }
            }
        });

        exerciseFrame.setVisible(true);
    }

    private void openExercise3() {
        JFrame exerciseFrame = new lab11_3();
        exerciseFrame.setLocationRelativeTo(frame);
    }
    private void openExercise4() {
        JFrame exerciseFrame = new JFrame("Exercise 4");
        exerciseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exerciseFrame.setSize(300, 200);
        exerciseFrame.setLayout(null);
        exerciseFrame.setLocationRelativeTo(frame);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(10, 10, 260, 140);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 260, 140);
        exerciseFrame.add(scrollPane);

        JButton generateButton = new JButton("Генерировать");
        generateButton.setBounds(80, 160, 140, 20);
        exerciseFrame.add(generateButton);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 7; i++) {
                    int number = random.nextInt();
                    sb.append(number).append("\n");
                }
                textArea.setText(sb.toString());
            }
        });

        exerciseFrame.setVisible(true);
    }
    private void openExercise5() {
        // Implement exercise 5
    }

    private void writeToFile(String text, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(text);
            writer.close();
            JOptionPane.showMessageDialog(null, "Данные успешно записаны в файл");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

    private String readFromFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            reader.close();
            return line;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при чтении из файла");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new lab11();
            }
        });
    }
}

class JTextFieldLimit extends PlainDocument {
    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}

