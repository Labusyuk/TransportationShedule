package com.labus.showcase.action;

import com.labus.showcase.entity.Staying;
import com.labus.showcase.entity.TimeOfDay;
import com.labus.showcase.entity.Transport;
import com.labus.showcase.entity.Ways;
import com.labus.showcase.logistics.RoadLogistic;
import com.labus.showcase.sourceInformation.htmlParser.TransportPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultAction implements Action {
    TransportPool transportPool = TransportPool.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            req.setAttribute("stayings",transportPool.getStaying());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(req.getMethod().equals("POST")){
            req.getSession().setAttribute("staying1", req.getParameter("staying1"));
            req.getSession().setAttribute("staying2", req.getParameter("staying2"));
            req.getSession().setAttribute("useTime", req.getParameter("useTime"));
            if(req.getParameter("useTime")!=null && !req.getParameter("time").isEmpty()){
                TimeOfDay timeOfDay = new TimeOfDay(req.getParameter("time"));
                boolean weekend = false;
                if(req.getParameter("weekend")!=null)weekend=true;
                req.getSession().setAttribute("waysList", new RoadLogistic().buildWays(new Staying(req.getParameter("staying1")), new Staying(req.getParameter("staying2")), timeOfDay,weekend));
            }else
                req.getSession().setAttribute("waysList", new RoadLogistic().buildWays(new Staying(req.getParameter("staying1")), new Staying(req.getParameter("staying2"))));
        }

        return "index";
    }
}
