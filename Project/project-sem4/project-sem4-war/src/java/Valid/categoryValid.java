/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valid;

/**
 *
 * @author Khoi
 */
public class categoryValid {
    public static boolean isEmpty( String validString ) {
        if( validString == null || validString.trim().equals( "" ) ) {
            return true;
        }
        return false;
    }
}
