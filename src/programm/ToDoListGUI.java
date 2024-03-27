package ToDoList.src.programm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoListGUI extends JFrame {
    private JPanel panel;
    private JTextField textField;
    private JButton hinzufuegenButton;
    private JButton loeschenButton;
    private List<String> tasks;

    public ToDoListGUI() {
        setTitle("To-Do-Liste");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tasks = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        textField = new JTextField(40);
        hinzufuegenButton = new JButton("Hinzufügen");
        loeschenButton = new JButton("Löschen");

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTasks();
            }
        });

        addTask(); // Füge eine leere Aufgabe beim Start hinzu

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Setzen Sie die gewünschte Größe

        getContentPane().add(scrollPane, BorderLayout.SOUTH);;
        getContentPane().add(textField, BorderLayout.NORTH);
       

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(hinzufuegenButton);
        buttonPanel.add(loeschenButton);
        
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    private void addTask() {
        String taskText = textField.getText().trim();
        if (!taskText.isEmpty()) {
            tasks.add(taskText);
            JCheckBox checkBox = new JCheckBox(taskText);
            panel.add(checkBox);
            textField.setText(""); // Leeres Textfeld
            validate(); // GUI aktualisieren
            repaint();
        }
    }

    private void deleteTasks() {
        tasks.clear();
        panel.removeAll();
        validate(); // GUI aktualisieren
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ToDoListGUI frame = new ToDoListGUI();
                frame.setVisible(true);
            }
        });
    }
}
