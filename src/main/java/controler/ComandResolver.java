package controler;

import comands.Comand;
import comands.impl.ComandMissing;
import comands.impl.ComandOpenLoginPage;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ComandResolver {
    private static ComandResolver instance=null;
    Map<String, Comand> comands=new HashMap<>();
    ComandResolver(){
        comands.put("enter",new ComandOpenLoginPage());
    }

    public static ComandResolver getInstance() {
        if (instance == null)
            instance = new ComandResolver();
        return instance;
    }
    public Comand getComand(HttpServletRequest request){
        Comand comand=comands.get(request.getParameter("comand"));
        if (comand==null){
            comand=new ComandMissing();
        }
        return comand;

    }
}
