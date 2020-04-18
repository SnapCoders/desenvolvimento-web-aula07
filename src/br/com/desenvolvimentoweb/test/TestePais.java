package br.com.desenvolvimentoweb.test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.desenvolvimentoweb.model.Pais;
import br.com.desenvolvimentoweb.service.PaisService;

public class TestePais {
	private static String str = "Escolha a ação que deseja realizar.\n\n" +
			 "1 - Criar um novo país\n\n" +
			 "2 - Atualizar um país existente\n\n" +
			 "3 - Excluír um país existenten\n\n" +
			 "4 - Carregar um país\n\n" +
			 "5 - Carregar os países com a maior população\n\n" +
			 "6 - Carregar os países com a menor área\n\n" +
			 "7 - Carregar 3 países em tela\n\n" +
			 "8 - Sair do sistema";
	
	public static void main(String[] args) {
		while (true) {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog(str));
			
			switch (escolha) {
				case 1: cadastrar(); break;
				case 2: atualizar(); break;
				case 3: excluir(); break;
				case 4: carregar(); break;
				case 5: maiorPopulacao(); break;
				case 6: menorArea(); break;
				case 7: vetorTresPaises(); break;
				case 8: System.exit(0); break;
				default: JOptionPane.showMessageDialog(null, "Escolha uma das opções fornecidas!"); break;
			}
		}
	}
	
	static void cadastrar() {
		String nome = JOptionPane.showInputDialog("Digite o nome do país: ");
		long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da população do país: "));
		double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a área total do pais: "));
		
		Pais pais = new Pais(nome, populacao, area);
		
		try {
			PaisService service = new PaisService();
			service.criar(pais);
			
			JOptionPane.showMessageDialog(null, "País cadastrado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	static void atualizar() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do país: "));
		
		String nome = JOptionPane.showInputDialog("Digite o novo nome deste país: ");
		long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite a nova população do país: "));
		double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a nova área total do pais: "));
		
		Pais pais = new Pais(id, nome, populacao, area);
		
		try {
			PaisService service = new PaisService();
			service.atualizar(pais);
			
			JOptionPane.showMessageDialog(null, "País atualizado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	static void excluir() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do país que deseja excluír"));
		
		Pais pais = new Pais();
		pais.setId(id);
		
		try {
			PaisService service = new PaisService();
			service.excluir(pais.getId());
			
			JOptionPane.showMessageDialog(null, "País excluído com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	static void carregar() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do país que deseja excluír"));
		
		try {
			PaisService service = new PaisService();
			Pais pais = service.carregar(id);
			
			JOptionPane.showMessageDialog(null, "País encontrado: " + pais.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	static void maiorPopulacao() {
		try {
			PaisService service = new PaisService();
			Pais pais = service.maiorPopulacao();
			
			JOptionPane.showMessageDialog(null, "País com maior população: " + pais.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	static void menorArea() {
		try {
			PaisService service = new PaisService();
			Pais pais = service.menorArea();
			
			JOptionPane.showMessageDialog(null, "País com menor área: " + pais.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	static void vetorTresPaises() {
		try {
			PaisService service = new PaisService();
			ArrayList<Pais> paises = service.vetorTresPaises();
			
			String paisesString = "";
			
			for (Pais pais : paises) {
				paisesString += pais.toString() + "\n";
			}
			
			JOptionPane.showMessageDialog(null, "3 Países listados:\n\n" + paisesString);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
