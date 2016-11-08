package authenticate;

/**
 * Created by bazarsad on 11/7/2016.
 */
public class EmailValidator {
    private String email;
    public EmailValidator(String email){
        this.email = email;
    }
    /*
        2. Valid Emails
        1. mkyong@yahoo.com, mkyong-100@yahoo.com, mkyong.100@yahoo.com
        2. mkyong111@mkyong.com, mkyong-100@mkyong.net, mkyong.100@mkyong.com.au
        3. mkyong@1.com, mkyong@gmail.com.com
        4. mkyong+100@gmail.com, mkyong-100@yahoo-test.com

        3. Invalid Emails
        1. mkyong – must contains “@” symbol
        2. mkyong@.com.my – tld can not start with dot “.”
        3. mkyong123@gmail.a – “.a” is not a valid tld, last tld must contains at least two characters
        4. mkyong123@.com – tld can not start with dot “.”
        5. mkyong123@.com.com – tld can not start with dot “.”
        6. .mkyong@mkyong.com – email’s first character can not start with dot “.”
        7. mkyong()*@gmail.com – email’s is only allow character, digit, underscore and dash
        8. mkyong@%*.com – email’s tld is only allow character and digit
        9. mkyong..2002@gmail.com – double dots “.” are not allow
        10. mkyong.@gmail.com – email’s last character can not end with dot “.”
        11. mkyong@mkyong@gmail.com – double “@” is not allow
        12. mkyong@gmail.com.1a -email’s tld which has two characters can not contains digit
     */

    /*
        The combination means, email address must start with “_A-Za-z0-9-\\+” ,
        optional follow by “.[_A-Za-z0-9-]”, and end with a “@” symbol.
        The email’s domain name must start with “A-Za-z0-9-“, follow by first level Tld (.com, .net) “.[A-Za-z0-9]”
        and optional follow by a second level Tld (.com.au, .com.my) “\\.[A-Za-z]{2,}”,
        where second level Tld must start with a dot “.” and length must equal or more than 2 characters.
     */
    public boolean validateEmail(){
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(email.matches(pattern)) {
            return true;
        }else{
            return false;
        }
    }
}
