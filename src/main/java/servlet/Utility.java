package servlet;



import model.NotUniqueFieldException;
import model.entity.User;
import service.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

class Utility implements  VerificationConstants {

    static List<String> verifyUserInput(User contact, ResourceBundle bundle) throws NumberFormatException {
        List<String> errors = new ArrayList<>();

        verifyName(errors, contact.getName(), bundle.getString(NAME_PATTERN));
        verifyName(errors, contact.getLogin(), bundle.getString(LOGIN_PATTERN));
        verifyName(errors, contact.getPassword(), bundle.getString(LOGIN_PATTERN));

        return errors;
    }

    static void checkUniquenessInput(ContactService contactService, User contact) throws NotUniqueFieldException {
        contactService.checkLogin(contact.getLogin());

    }

    private static void verifyName(List<String> errors, String firstName, String pattern) {
        if (!firstName.matches(pattern)) {
            errors.add("First name, middle name and last name must be in format " + pattern);
        }
    }

    private static void verifyLogin(List<String> errors, String login, String pattern) {
        if (!login.matches(pattern)) {
            errors.add("Login must be in format " + pattern);
        }

    }


}
