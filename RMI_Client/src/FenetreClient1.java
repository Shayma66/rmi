import java.awt.Color;
import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.rmi.Naming;
	import java.rmi.registry.LocateRegistry;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
import javax.swing.JTextField;
	
	public class FenetreClient1 extends JFrame implements ActionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JLabel label1;
		private JLabel label2;
		private JTextField port;
		private JTextField adresseip;
		private JButton lancer ;
		private boolean lanced =false ;
		public FenetreClient1()
		{
			super("Lancement du serveur");
				
			//setBackground(Color.white);
			setLocationRelativeTo(null);  //On centre la fenêtre sur l'écran
			setResizable(false);  //On interdit la redimensionnement de la fenêtre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		
			 label1 = new JLabel("  saisir l'@ IP du serveur :");
			 label2 = new JLabel("  saisir le Port :");
			 getContentPane().setBackground( new Color(255,20,147) );
			this.setLayout(new GridLayout(3,2));
			adresseip =new JTextField("");
			adresseip.setBackground(new Color(255,240,245));
			port=new JTextField("");
			port.setBackground(new Color(255,240,245));
			lancer=new JButton("Lancer");
			lancer.setBackground(new Color(255,240,245));
			lancer.addActionListener(this);
			this.add(label1);
			this.add(port);
			this.add(label2);
			this.add(adresseip);
			this.add(lancer);
			this.pack();
			this.show();
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
	FenetreClient f=new FenetreClient(adresseip.getText(),port.getText());	
               f.setSize(400,150);
                    /*
			if((!lanced))
	        {
				
	          try {
	        	 System.out.println("Serveur : Construction de l’implementation");				
	        	
	        	 //CompteServeur cpt = new CompteServeur(100);
	     	   	
	        
				LocateRegistry.createRegistry(1099);
			
				
				Naming.rebind("rmi://10.0.0.10:1099/CompteServeur", cpt);
				
				System.out.println("Objet Compte enregistré dans RMIregistry");
				System.out.println("Attente des invocations des clients ");
				
				System.out.println("Connect to localhost:1099");
				JOptionPane.showMessageDialog(null,"Serveur Lancé ","Confirmation", 1);	
			} 
	        	  
	            catch (Exception e) {
				System.out.println("Erreur de liaison de l'objet Compte");
				System.out.println(e.toString());
			}
	            	lanced=true;
	        }*/
			}
                
			 public static void main(String a[])
		    {
		        FenetreClient1 f=new FenetreClient1();
		       f.setSize(400,200);  //On donne une taille à notre fenêtre
		        
		    } 
	}

	
	