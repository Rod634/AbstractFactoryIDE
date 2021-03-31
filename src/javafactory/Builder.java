package javafactory;

import java.io.File;
import java.io.IOException;

import interfaces.IBuilder;

public class Builder implements IBuilder{
	
	public void compile(File file) throws IOException {
		
		try {
	        
            ProcessBuilder pb = new ProcessBuilder("javac",  file.getAbsolutePath().replace("\\", "/"));
            Process p = pb.start();
	            
		}catch(Exception ex) {	
			System.out.println("Erro de compilação arquivo java");
		}
	}
}
