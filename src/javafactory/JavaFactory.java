package javafactory;

import java.io.IOException;

import interfaces.IAbstractFactory;
import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;

public class JavaFactory implements IAbstractFactory{

	private static JavaFactory instance = null;

	public static JavaFactory getInstance(){
		if(instance == null){
			instance = new JavaFactory();
		}
		return instance;
	}

	@Override
	public ISyntaxHighlighter syntaxHighligther() throws IOException {
		return new SyntaxHigh();
	}

	@Override
	public IBuilder builder() {
		return new Builder();
	}
}
