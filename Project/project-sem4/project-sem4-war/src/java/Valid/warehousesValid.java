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
public class warehousesValid {
    public static boolean isEmpty( String validValue ) {
        if( validValue.trim().equals( "" ) || validValue == null ) {
            return true;
        }
        return false;
    }
}
