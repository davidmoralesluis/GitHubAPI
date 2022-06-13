import org.kohsuke.github.*;

import javax.swing.*;
import java.io.*;

public class Main {
    PrintWriter printW;
    FileWriter fileW;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String token = "/Users/davidmoralesluis/Documents/VisualStudioCode/GitHub/token";
        File file = new File(token);
        if (file.exists()) {
            main.creacionRepositorio(token);
        } else {
            main.escribirElToken(token);
            main.creacionRepositorio(token);
        }
    }

    public  void creacionRepositorio(String fichero){
        GitHub github = null;
        try {
            new GitHubBuilder();
            github = GitHubBuilder
                    .fromPropertyFile(fichero)
                    .build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (github != null) {
                GHRepository repo1 = github.createRepository(
                                "GithubAPI")
                        .create();
            }
        } catch (IOException e) {
            System.out.println("Ya existe");
        }
    }

    public  void escribirElToken(String fichero){
        try {
            fileW = new FileWriter(fichero, false);
            printW.println(fichero);
            printW.println("OAuth="+ JOptionPane.showInputDialog(" token ??")); //Crea archivo
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                fileW.close(); //se cierra el archivo
            } catch (IOException e) {
                System.out.println("no se pudo cerrar el archivo");
            }
        }
    }
}
