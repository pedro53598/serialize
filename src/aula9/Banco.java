package aula9;

import java.io.*;

import javax.swing.JOptionPane;


public class Banco {

	Funcionario func;
	
	public void guardar() {
		func = new Funcionario();
	 
		
		
		func.setNome(JOptionPane.showInputDialog( null, "Digite o nome"));
		func.setCargo(JOptionPane.showInputDialog( null, "Digite o cargo"));
		func.setTelefone(JOptionPane.showInputDialog( null, "Digite o telefone"));
		func.setSalario(Double.parseDouble(JOptionPane.showInputDialog( null, "Digite o salário")));
		
		
		
		try{
			File f = new File("objeto");
			FileOutputStream fos =  new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);			
			oos.writeObject(func);
			oos.close();
			
		}
		catch(Exception e ) {
			e.printStackTrace ();
		}
		
	}
	
	public void ler() {
		try {
			File f = new File("objeto");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream (fis);
			func = (Funcionario ) ois.readObject();
			
			JOptionPane.showMessageDialog( null, "Nome: " + func.getNome() + "\nCargo: " + func.getCargo() + "\nTelefone: " + func.getTelefone() + "\nSalário: " + func.getSalario());
			ois.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}