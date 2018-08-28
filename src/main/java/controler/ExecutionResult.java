package controler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/** Object of ExecutionResult Class is a result of Command execution*/


public class ExecutionResult {
    private String page;
    private Direction direction;
    private boolean isInvalidated;
    private Map<String,Object> sessionAttributes=new HashMap<>();
    private Map<String,Object> requestAttributes=new HashMap<>();
    private Map<String,Object> requestParameters=new HashMap<>();

    public void setPage(String page) {
        this.page = page;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void invalidatedSession() {
        isInvalidated = true;
    }

    public void addSessionAttributes(String string, Object object) {
        sessionAttributes.put(string,object);
    }

    public void addRequestAttributes(String string, Object object) {
        sessionAttributes.put(string,object);
    }

    public void addRequestParameters(String string, Object object) {
        sessionAttributes.put(string,object);
    }

    public String getPage() {
        return page;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isInvalidated() {
        return isInvalidated;
    }

    public void updateRequest(HttpServletRequest request){
        requestAttributes.forEach(request::setAttribute);
        sessionAttributes.forEach(request.getSession()::setAttribute);
    }

    public void addParametersToPage(){
        requestParameters.forEach((String key,Object value)->{
            page=page.concat(key).concat("=").concat((String)value).concat("&");});
    }
}
