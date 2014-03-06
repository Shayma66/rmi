/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class FenetreClient extends JFrame implements ActionListener  {
    String adresseip;
    String port;
            
	JLabel password;
	JTextField passwordText;
	JComboBox operation;
	JButton conf;
	@SuppressWarnings("deprecation")
	public FenetreClient(String adresseip,String port)
        {       super("Client");
        this.adresseip=adresseip;
        this.port=port;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  //On centre la fenêtre sur l'écran
			setResizable(false);  //On interdit la redimensionnement de la fenêtre
		password=new JLabel("           Mot de Pass :");
		passwordText=new JTextField();
		operation =new JComboBox();
		conf=new JButton(" Confirmer ");
                conf.setBackground(new Color(255,240,245));
		conf.addActionListener(this);
		this.setLayout(new GridLayout(2,2));
		add(password);
                add(passwordText);
                add(conf);
               getContentPane().setBackground( new Color(255,20,147) );
		this.pack();
		this.show();
			}
	@Override
	public void actionPerformed(ActionEvent arg0) {
           //    new Client (this.ip.getText(),this.port.getText(),Integer.toString(this.operation.getSelectedIndex()+1),this.val.getText(),this.montant);
	
        //banque b ;
       // b= new banque();
            
            String nomService ="rmi://10.0.0.10:1099/Banque";
      IBanque b=null;
        try {
                 
        	b = (IBanque)Naming.lookup("rmi://10.0.0.10:1099/Banque");
            //b = (IBanque)Naming.lookup(nomService);
        } catch (NotBoundException ex) {
            Logger.getLogger(FenetreClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FenetreClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(FenetreClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                compte c= b.authentification(this.passwordText.getText());
            
            if (c== null)
              JOptionPane.showMessageDialog(null,"mot de passe erroné veuillez resaisir","Confirmation", 1);
            else{
                
             //   Client client=new Client(this.passwordText.getText());
                 Fenetre_Compte f1=new Fenetre_Compte(c);
                 f1.setSize(400,200);
            }
            } catch (SQLException ex) {
                Logger.getLogger(FenetreClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		/*public static void main(String a[])
	{
		new FenetreClient();	
}*/
}


