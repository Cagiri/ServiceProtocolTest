package com.serviceprotocol.hessianexp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class HessianServerExp {

	
	public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        		
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(HessianServerServletExp.class,"/communication-service");
        
        server.setHandler(context);
        server.start();
}
}
