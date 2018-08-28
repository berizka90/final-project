package controler;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SessionRequestContent {
    private Map<String, Object> reqAttributes;
    private Map<String, String[]> reqParameters;
    private Map<String, Object> sessionAttributes;
    private static final Logger log = Logger.getLogger(SessionRequestContent.class);

    public SessionRequestContent(HttpServletRequest request) {
        sessionAttributes=new HashMap<>();
        reqAttributes=new HashMap<>();
        try {
            reqParameters=request.getParameterMap();
            Enumeration<String> reqAtributeNames=request.getAttributeNames();
            while (reqAtributeNames.hasMoreElements()){
                String atribyteName=reqAtributeNames.nextElement();
                reqAttributes.put(atribyteName,request.getAttribute(atribyteName));
            }
            HttpSession currentSession=request.getSession(false);
            if (currentSession!=null){
                Enumeration<String> sessionAtributesNames=currentSession.getAttributeNames();
                while (sessionAtributesNames.hasMoreElements()){
                    String attributeName=sessionAtributesNames.nextElement();
                    sessionAttributes.put(attributeName,currentSession.getAttribute(attributeName));
                }
            }
        }
        catch (NullPointerException e){
            log.error(e);
        }
    }
public boolean checkRequestParameter(String atrName){
        return reqParameters.containsKey(atrName);
}
public boolean checkSessionAttribute(String atrName){
        return sessionAttributes.containsKey(atrName);
}

    private Object getReqAttributes(String key) {
        return reqAttributes.get(key);
    }

    private   String[] getReqParameters(String key) {
        return reqParameters.get(key);
    }
    public Map< String,String[]> getReqParameters() {
        return reqParameters;
    }
    private   Object getSessionAttributes(String key) {
        return sessionAttributes.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        Set<String> keys=reqAttributes.keySet();
        for (String key: keys)
            sb.append("\nRequest attribute: key = " + key + " value = " + getReqAttributes(key));
        keys=reqParameters.keySet();
        for (String key: keys)
            sb.append("\nRequest parameter: key = " + key + " value = " + getReqParameters(key)[0]);
        keys=sessionAttributes.keySet();
        for (String key: keys)
            sb.append("\nSession attribute: key = " + key + " value = " + getSessionAttributes(key));
        return sb.toString();
    }
}
