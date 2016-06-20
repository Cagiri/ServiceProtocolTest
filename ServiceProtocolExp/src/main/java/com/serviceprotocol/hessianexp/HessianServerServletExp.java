package com.serviceprotocol.hessianexp;

import com.caucho.hessian.server.HessianServlet;
import com.serviceprotocolfacade.hessian.CommunicationService;

public class HessianServerServletExp extends HessianServlet implements CommunicationService {

	private static final long serialVersionUID = -8936738982214210517L;

	public String communicate(String str) {

		return "Hessian protocol test.... ->" + str;
	}

}
