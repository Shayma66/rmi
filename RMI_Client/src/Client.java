
import java.rmi.Naming;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

	public class Client {
            public String password ;
            compte cpt;
            public Client(String password)
            {
            this.password=password;
            }

		public Client (String oper,String val,JTextField montant,compte c) throws SQLException
	{
                this.cpt=c;
		boolean faite=false; 
		
                      try
		{
			String nomService = "rmi://10.0.0.10:1099/Banque";
			System.out.println (" Connexion au service : " + nomService);
			
			double valeur = Double.parseDouble(val);
			int operation = Integer.parseInt(oper);
			
			System.out.println("Connecting to "+nomService);
			
			double aux=cpt.lire_solde();	
			System.out.println("Votre montant actuel est :"+aux);	
			if (valeur>=0) 
			{
				if (operation == 2) {
					cpt.crediter1(valeur);
					 System.out.println("Vous avez credité :"+valeur);
					}
				if (operation == 1)
					
				 {
					cpt.debiter(valeur);
                             
					 System.out.println("Vous avez debité :"+valeur);
						
						}
			}
			//faite=true;
			
			System.out.println("Montant actuel " +cpt.lire_solde()); 
			montant.setText(Double.toString(cpt.lire_solde()));
			
		}
		catch (Exception e)
		{e.printStackTrace();
			if(!faite)
			JOptionPane.showMessageDialog(null,"Erreur de connection ","Confirmation", 1);
			else
				JOptionPane.showMessageDialog(null,"Erreur de connection mais l'operation est bien faite","Confirmation", 1);
		}
		}
		
}




		

 