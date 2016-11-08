package authenticate;

/**
 * Created by bazarsad on 11/7/2016.
 */
public class PasswordValidator {
    private String passwordToValidate;

    public PasswordValidator(String password){
        this.passwordToValidate = password;
    }
    public Boolean validatePassword(){
        /*
            (?=.*[0-9]) a digit must occur at least once
            (?=.*[a-z]) a lower case letter must occur at least once
            (?=.*[A-Z]) an upper case letter must occur at least once
            (?=\\S+$) no whitespace allowed in the entire string
            .{8,} at least 8 characters
         */
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
        if(passwordToValidate.matches(pattern)) {
            return true;
        }else{
            return false;
        }
    }
}
