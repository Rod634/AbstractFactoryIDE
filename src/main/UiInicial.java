package main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.UIManager;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.SystemColor;

public class UiInicial extends JFrame{
	
	private JButton abrirArquivo;
	private Logic logica;

	public UiInicial() {
		this.logica = new Logic();
		this.abrirArquivo = new JButton("Abrir/Criar");
		actionListenners();
		MontarTelaInicial();
	}
	
	private void MontarTelaInicial() {
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rs Code");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(159, 23, 104, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setForeground(UIManager.getColor("Label.disabledShadow"));
		panel.add(lblNewLabel);
		 	
		this.abrirArquivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.abrirArquivo.setBounds(159, 134, 100, 50);
		panel.add(this.abrirArquivo);
		
		JLabel subTitulo = new JLabel("Deseja Abrir um arquivo existente ou criar um novo ?");
		subTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		subTitulo.setForeground(UIManager.getColor("List.background"));
		subTitulo.setBounds(50, 82, 336, 16);
		panel.add(subTitulo);
		
		setSize(433, 300);
		this.setVisible(true);
	}
	
	
	private void actionListenners() {		
		//Abre um selecionador de arquivos
		this.abrirArquivo.addActionListener(e ->
		{
		    JFileChooser escolha = new JFileChooser();
		    
		    int valid = escolha.showOpenDialog(null);
		    
		    if (valid == JFileChooser.APPROVE_OPTION) {
		    	try {
		    		
		    		String extensao = escolha.getSelectedFile().toString();
		    		extensao = extensao.substring(extensao.lastIndexOf(".") + 1, extensao.length());
		    		String path = escolha.getSelectedFile().getAbsolutePath();
		    		
		    		File f = new File(path);
		  		  	if(f.exists() && !f.isDirectory()) { 
		  		      
		  		  	}else {
		  			 f = new File(path);
		  			 f.createNewFile();
		  			}
		    		
					OpenSyntaxHigh(extensao, path);
					
				} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
		    }
		});
	}

	private void OpenSyntaxHigh(String extensao, String path) throws MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		int retorno = this.logica.LoadPlugins(path, extensao);
		
		if(retorno == -1) {
			JOptionPane.showMessageDialog(null, "Não existe plugin que suporte este arquivo");
		}
	}
}