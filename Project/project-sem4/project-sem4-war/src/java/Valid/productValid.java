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
public class productValid {
    public static boolean isEmpty( String validValue ) {
        if( validValue == null || validValue.trim().equals("") ) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isNumber( String validValue ) {
        try {
            Integer.parseInt( validValue );
        } catch( Exception ex ) {
            return false;
        }
        
        return true;
    }
    
    public static boolean isDoubleNumber( String validValue ) {
        try {
            Double.parseDouble( validValue );
        } catch( Exception ex ) {
            return false;
        }
        
        return true;
    }
    
    public static boolean isImage( String fileExtension ) {
        if( !fileExtension.equals( "jpg" ) && !fileExtension.equals( "png" ) ) {
            return false;
        }
        
        return true;
    }
}
