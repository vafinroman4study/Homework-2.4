import exceptions.*;

public class Main {
    public static void main(String[] args) {
        String login = "java_skypro";
        String password = "1234_";
        String otherPassword = "qwerty";

        if (task1(login, password, password)) {
            System.out.println("pass");
        } else {
            System.out.println("no pass");
        }
    }

    public static Boolean task1(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Длина логина должна быть не больше 20 символов");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Не совпадают пароли");
            return false;
        }
        return checkAllowedCharacters(login) &&  checkAllowedCharacters(password);
    }

    public static void checkLogin(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
    }

    public static void checkPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    public static Boolean checkAllowedCharacters(String s) {
        String setCharactersAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
        for (int i = 0; i < s.length(); i++) {
            if (setCharactersAllowed.indexOf(s.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}