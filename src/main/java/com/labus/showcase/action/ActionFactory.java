package com.labus.showcase.action;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory  {
    public static final Map<String, Action> actionsMap = new HashMap<>();
    static {
        actionsMap.put("/index", new DefaultAction());
    }


    public static Action defineAction(HttpServletRequest req) {
        String actionPath = req.getPathInfo();
        Action command = actionsMap.get(actionPath);
        return command!=null?command:new DefaultAction();

    }

}
