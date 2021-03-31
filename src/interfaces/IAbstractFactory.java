package interfaces;

import java.io.IOException;

public interface IAbstractFactory {
	public ISyntaxHighlighter syntaxHighligther() throws IOException;
	public IBuilder builder();
}
