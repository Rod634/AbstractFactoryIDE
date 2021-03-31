package cppfactory;

import interfaces.IAbstractFactory;
import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;

public class CppFactory implements IAbstractFactory {

	@Override
	public ISyntaxHighlighter syntaxHighligther() {
		return new SyntaxHigh();
	}

	@Override
	public IBuilder builder() {
		return new Builder();
	}
}
