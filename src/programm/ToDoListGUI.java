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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Schlie�verhalten beim Klicken auf das Schlie�en-Symbol

        
      
        
        
        // Initialisieren der Aufgabenliste
        tasks = new ArrayList<>();

        // Erstellen des Textfelds
        textField = new JTextField(40);
        
        
       

        // Erstellen des Scrollbalken f�r die Textfl�che
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Erstellen der Schaltfl�chen (Buttons)
        JButton hinzufuegenButton = new JButton("Hinzuf�gen");
        JButton loeschenButton = new JButton("L�schen");

        // Hinzuf�gen von ActionListenern zu den Buttons
        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Aktion, die beim Klicken auf die Hinzuf�gen-Schaltfl�che ausgef�hrt wird
                String task = textField.getText();
                if (!task.isEmpty()) {
                    tasks.add(task); // Hinzuf�gen der Aufgabe zur Liste
                    updateTextArea(); // Aktualisieren der Anzeige
                    textField.setText(""); // L�schen des Textfelds nach dem Hinzuf�gen
                }
            }
        });

        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion, die beim Klicken auf die L�schen-Schaltfl�che ausgef�hrt wird
                tasks.clear(); // L�schen der Aufgabenliste
                updateTextArea(); // Aktualisieren der Anzeige
            }
        });

        
        // Erstellen der Textfl�che
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false); // Damit Benutzer die Textfl�che nicht bearbeiten k�nnen
       
        
        // Hinzuf�gen der Komponenten zum Rahmen
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
        textArea.setText(""); // L�schen des bisherigen Inhalts der Textfl�che
        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            textArea.append((i + 1) + ". " + task + "\n"); // Nummerierung und Hinzuf�gen der Aufgaben
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
