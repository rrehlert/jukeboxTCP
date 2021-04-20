package prototipotrabalho;

import javax.swing.JFileChooser;
import java.io.File;



public class escolheArquivo {

    private String arquivo = null;

    public void escolhe()

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
    }

    public String getArquivo(){
        return this.arquivo;
    }
}

