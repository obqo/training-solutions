package stringtype.registration;

public class UserValidator {

    public Boolean isValidUsername(String username){
        return username !="";
    }

    public Boolean isValidPassword(String password1, String password2){
        return password1.equals(password2) && password1.length() >=8;
    }

    public Boolean isValidEmail(String email){
        return email.indexOf("@") > 0 && email.indexOf(".") < email.length() - 1 && email.indexOf("@") < (email.indexOf(".") - 1);
    }

}
