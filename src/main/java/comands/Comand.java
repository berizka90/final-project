package comands;

import controler.ExecutionResult;
import controler.SessionRequestContent;


public interface Comand {
    /**
     * @param content - object that contains session and request attributes and parameters
     * @return object that contains new request and session attributes and parameters as the result of command execution
     */
    ExecutionResult execute(SessionRequestContent content);
}
