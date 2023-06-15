package init;

import java.io.File;
import java.io.IOException;

import view.terminal.ViewTerminal;

public class Init {

    public static void main(String[] args) {
    	try {
    	      File myObjA = new File("Alunos.csv");
    	      File myObjC = new File("Cursos.csv");
    	      File myObjR = new File("Relacao.csv");
    	      myObjA.createNewFile();
    	      myObjC.createNewFile();
    	      myObjR.createNewFile();
    	    } catch (IOException e) {
    	      System.out.println("Algum erro ocorreu ao tentar gravar arquivos de banco de dados.");
    	      e.printStackTrace();
    	    }    	  
        ViewTerminal view = new ViewTerminal();
        view.init();
        
    }
}
