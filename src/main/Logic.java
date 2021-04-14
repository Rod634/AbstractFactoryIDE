package main;

import interfaces.IAbstractFactory;
import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Logic
{
	public void createFactories(IAbstractFactory factory, String path) throws IOException
	{
		
		File file = new File(path);
		ISyntaxHighlighter  p1 = factory.syntaxHighligther();
		p1.showEditor(path);;
		IBuilder p2 = factory.builder();
		p2.compile(file);

	}
  
  	public int LoadPlugins(String path, String extensao) throws MalformedURLException, InstantiationException, IllegalAccessException,
	ClassNotFoundException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		int op = -1;
		do
		{
			File currentDir = new File("./src/plugins");
			String []plugins = currentDir.list();
			int i;
			URL[] jars = new URL[plugins.length];
			
			for (i = 0; i < plugins.length; i++)
			{
				jars[i] = (new File("./src/plugins" + plugins[i])).toURL(); 
				if(plugins[i].split("\\.")[0].toLowerCase().contains(extensao.toLowerCase()) ) {
					op = i+1;
				}
			}
			
			URLClassLoader ulc = new URLClassLoader(jars);
			
			if (op != 0 && op != i+1)
			{
				String factoryName = plugins[op-1].split("\\.")[0];
				Class metaClass = Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc);
				Method getInstanceMethod = metaClass.getDeclaredMethod("getInstance");
				IAbstractFactory factory = (IAbstractFactory) getInstanceMethod.invoke(metaClass);
				// IAbstractFactory factory = (IAbstractFactory) Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc).newInstance();
				createFactories(factory, path);
				op = 0;
			}
			
			if(op == -1) {
				return op;
			}
		} while (op != 0);
	return op;
  }

}