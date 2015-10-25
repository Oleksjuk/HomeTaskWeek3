package com.geekhub.hw3.auth;

public class AuthenticationService {

    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();

        try {
            User blah = authService.auth("blah", "blah");
        } catch (AuthException e) {
            e.printStackTrace();
        }

        try {
            User batman = authService.auth("Batman", "catwoman");
        } catch (AuthException e) {
            e.printStackTrace();
        }
    }

    private User[] users = {
        new User("Geekhub", "qwe123"),
        new User("Batman", "catwoman")
    };

    private User auth(String login, String password) throws AuthException {
        if (login == null || password==null || login.isEmpty() || password.isEmpty()) throw new WrongCredentialsException("wrong credentials");
        User user = getUserByLogin(login);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new WrongPasswordException("wrong password");
            }
        } else throw new UserNotFoundException("user not found");
    }

    private User getUserByLogin(String login) {
        for (User user: users) {
            if (user.getLogin().equals(login)) {return user;}
        }
        return null;
    }
}
