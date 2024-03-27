package ToDoList.src.programm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoListGUI extends JFrame {

    private JTextArea textArea;
    private JTextField textField;
  
    private List<String> tasks;

    public ToDoListGUI() {
        setTitle("To-Do-Liste");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Schließverhalten beim Klicken auf das Schließen-Symbol

        
      
        
        
        // Initialisieren der Aufgabenliste
        tasks = new ArrayList<>();

        // Erstellen des Textfelds
        textField = new JTextField(40);
        
        
       

        // Erstellen des Scrollbalken für die Textfläche
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Erstellen der Schaltflächen (Buttons)
        JButton hinzufuegenButton = new JButton("Hinzufügen");
        JButton loeschenButton = new JButton("Löschen");

        // Hinzufügen von ActionListenern zu den Buttons
        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Aktion, die beim Klicken auf die Hinzufügen-Schaltfläche ausgeführt wird
                String task = textField.getText();
                if (!task.isEmpty()) {
                    tasks.add(task); // Hinzufügen der Aufgabe zur Liste
                    updateTextArea(); // Aktualisieren der Anzeige
                    textField.setText(""); // Löschen des Textfelds nach dem Hinzufügen
                }
            }
        });

        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion, die beim Klicken auf die Löschen-Schaltfläche ausgeführt wird
                tasks.clear(); // Löschen der Aufgabenliste
                updateTextArea(); // Aktualisieren der Anzeige
            }
        });

        
        // Erstellen der Textfläche
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false); // Damit Benutzer die Textfläche nicht bearbeiten können
       
        
        // Hinzufügen der Komponenten zum Rahmen
        JPanel panel = new JPanel();
        panel.add(new JLabel("Noch zu Tun:"));
       
        panel.add(textField);
       
        panel.add(hinzufuegenButton);
        panel.add(loeschenButton);
        panel.add(textArea);
        

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    // Methode zur Aktualisierung der Anzeige der Aufgabenliste
    private void updateTextArea() {
        textArea.setText(""); // Löschen des bisherigen Inhalts der Textfläche
        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            textArea.append((i + 1) + ". " + task + "\n"); // Nummerierung und Hinzufügen der Aufgaben
        }
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
