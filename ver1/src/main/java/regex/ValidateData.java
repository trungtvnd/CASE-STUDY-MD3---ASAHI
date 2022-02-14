package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    public static final String nameRegex = "^[^\\d]+$";
    public static final String idRegex = "^\\d{6}$";
    public static final String gmailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*(@gmail.com)$";
    public static final String numberRegex = "^[0][0-9]{9}";


    public static boolean validateName( String regex){
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public  static boolean validatePassword( String regex){
        Pattern pattern = Pattern.compile(idRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateGmail( String regex){
        Pattern pattern = Pattern.compile(gmailRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
