/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public interface compte extends java.rmi.Remote{
   
   void debiter(double montant) throws SQLException, RemoteException;

   void crediter1(double montant) throws SQLException,RemoteException;

   double lire_solde() throws SQLException,RemoteException;
}
