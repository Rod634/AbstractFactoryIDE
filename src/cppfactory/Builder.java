package cppfactory;

import java.io.File;
import java.io.IOException;

import interfaces.IBuilder;

public class Builder implements IBuilder {
		
	public void compile(File file) throws IOException {
		
		try {
			
			 ProcessBuilder pb = new ProcessBuilder("g++ -o program" ,  file.getAbsolutePath().replace("\\", "/"));
			 Process p = pb.start();
	            
		}catch(Exception ex) {	
			System.out.println("Erro de compilação arquivo c++");
		}
	}
}
