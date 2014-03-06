/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
   
import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Fenetre_Compte extends JFrame implements ActionListener{
JLabel mon1,monval1,adress,por,ope,vall,mon,vide;
	JTextField ip,port,val,montant;
	JComboBox operation;
	JButton conf;
        compte c;
	@SuppressWarnings("deprecation")
	public Fenetre_Compte(compte c)
	{super("Client");
		this.c=c;	                
		ope=new JLabel("   Operation : ");
		vall=new JLabel("  Valeur : ");
		mon=new JLabel("   Montant Final : ");
                mon1=new JLabel("   Votre Montant : ");
        try {
            try {
				monval1=new JLabel(Double.toString(c.lire_solde()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
             
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);  //On centre la fenêtre sur l'écran
			setResizable(false);  //On interdit la redimensionnement de la fenêtre
		val=new JTextField("");
		montant=new JTextField("");
		operation =new JComboBox();
		operation.addItem(" Debiter");
		operation.addItem(" Crediter");
		conf=new JButton("    Confirmer   ");
                conf.setBackground(new Color(255,105,180));
                operation.setBackground(new Color(255,240,245));
                vide= new JLabel("");
                getContentPane().setBackground( new Color(255,20,147) );
		conf.addActionListener(this);
		this.setLayout(new GridLayout(5,2));
                add(mon1);
                add(monval1);
                add(vall);
                add(val);
		add(ope);
                add(operation);
                add(vide);
                add(conf);
                add(mon);
		add(montant);
		this.pack();
		this.show();
			}

    Fenetre_Compte() {
       }
        public void actionPerformed(ActionEvent arg0) {
    try {
        new Client (Integer.toString(this.operation.getSelectedIndex()+1),this.val.getText(),this.montant,c);
    } catch (SQLException ex) {
        Logger.getLogger(Fenetre_Compte.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        }
    }
    

