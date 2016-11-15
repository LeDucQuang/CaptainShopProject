/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cgc_Shyn
 */
public class ValidData {
    
    public static boolean isEmpty( String testString) {
        if( testString == null || testString.trim().equals( "" ) ) {
            return true;
        }
        
        return false;
    }

    public static boolean isName(String name) {
        if (name.trim().equals("") || name == null) {
            return false;
        }
        String reg = "^([a-zA-Z0-9])*$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(name);
        return m.find();
    }

    public static boolean isPassword(String password) {
          if (password.trim().equals("") || password == null || password.length() < 4) {
            return false;
        }
        String reg = "^([a-zA-Z0-9])*$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(password);
        return m.find();
    }

    public static boolean isEmail(String email) {
        String reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static boolean isPhone(String phone) {
        try {
            Integer.parseInt(phone);
        } catch( Exception ex ) {
            return false;
        }
        return true;
    }

}
