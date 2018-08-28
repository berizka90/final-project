package comands.impl;

import comands.Comand;
import config.Configuration;
import controler.Direction;
import controler.ExecutionResult;
import controler.SessionRequestContent;

public class ComandOpenLoginPage implements Comand {
    @Override
    public ExecutionResult execute(SessionRequestContent content) {
        ExecutionResult result=new ExecutionResult();
        result.setPage(Configuration.getInstance().getPage("login"));
        result.setDirection(Direction.FORWARD);
        return result;
    }
}
