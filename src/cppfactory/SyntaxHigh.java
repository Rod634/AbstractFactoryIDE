package cppfactory;

import javax.swing.*;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

import interfaces.ISyntaxHighlighter;

public class SyntaxHigh extends JFrame implements ISyntaxHighlighter{
	
	public void showEditor(String path) throws IOException {
	
	  JPanel cp = new JPanel(new BorderLayout());

      RSyntaxTextArea textArea = new RSyntaxTextArea(40, 80);
      textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
      textArea.setCodeFoldingEnabled(true);
      
      if(path != null) {
        FileReader reader = new FileReader( path );
        BufferedReader br = new BufferedReader(reader);
        textArea.read(br, null);
        br.close();
      }
      
      RTextScrollPane sp = new RTextScrollPane(textArea);
      cp.add(sp);

      setContentPane(cp);
      setTitle("Sintax highlighter to c++");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);	
      
      
      this.setVisible(true);
     
	}
}
