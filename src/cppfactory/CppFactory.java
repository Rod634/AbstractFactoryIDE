package cppfactory;

import interfaces.IAbstractFactory;
import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;

public class CppFactory implements IAbstractFactory {
	
	private static CppFactory instance = null;

	public static CppFactory getInstance(){
		if(instance == null){
			instance = new CppFactory();
		}
		return instance;
	}

	@Override
	public ISyntaxHighlighter syntaxHighligther() {
		return new SyntaxHigh();
	}

	@Override
	public IBuilder builder() {
		return new Builder();
	}
}
