package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Controller {

    private File currentFile;

    // Costruttore che imposta il file di default su "output.txt" nella cartella home dell'utente
    public Controller() {
        String homeFolder = System.getProperty("user.home");
        String fileSeparator = System.getProperty("file.separator");
        this.currentFile = new File(homeFolder + fileSeparator + "output.txt");
    }

    // Metodo per impostare un nuovo file corrente
    public void setCurrentFile(File file) {
        this.currentFile = file;
    }

    // Metodo per ottenere il file corrente
    public File getCurrentFile() {
        return currentFile;
    }

    // Metodo per ottenere il percorso del file corrente come stringa
    public String getCurrentFilePath() {
        return currentFile.getPath();
    }

    // Metodo per salvare una stringa nel file corrente
    public void save(final String text) throws IOException {
        try (PrintStream out = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            out.println(text);
        }
    
    }

    public static void main(String[] args) {
        // Esempio di utilizzo della classe Controller
        Controller controller = new Controller();

        // Impostare un nuovo file corrente (es. "nuovoFile.txt")
        File nuovoFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "nuovoFile.txt");
        controller.setCurrentFile(nuovoFile);

        // Ottenere e stampare il percorso del file corrente
        System.out.println("Percorso del file corrente: " + controller.getCurrentFilePath());

        try {
            // Salvare una stringa nel file corrente
            controller.save("Contenuto di esempio");
            System.out.println("Contenuto salvato con successo.");
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante il salvataggio del contenuto.");
            e.printStackTrace();
        }
    }
}

