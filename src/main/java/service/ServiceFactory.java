package service;

import service.impl.UserService;

public class ServiceFactory {
    public static UserServ getUserService(){
        return new UserService();
    }
}
