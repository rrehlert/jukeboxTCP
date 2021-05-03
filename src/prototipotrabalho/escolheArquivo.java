package prototipotrabalho;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class escolheArquivo {

    private String arquivo = null;

    public String escolhe()

    {
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                this.arquivo = selectedFile.getAbsolutePath();
            }
            else
                this.arquivo = null;
        }
        return this.leArquivo();
    }

    public String getArquivo(){
        return this.arquivo;
    }

    private String leArquivo() {
        if (this.arquivo != null) {
            File entrada = new File(this.arquivo);
            try {
                Scanner arquivo = new Scanner(entrada);
                arquivo.useDelimiter("\\Z");
                return arquivo.next();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            }
        }
            return null;
    }
}

