/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;

public interface IBanque {
     public compte authentification(String password) throws SQLException;
}
