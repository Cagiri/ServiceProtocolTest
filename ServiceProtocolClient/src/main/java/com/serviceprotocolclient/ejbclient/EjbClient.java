package com.serviceprotocolclient.ejbclient;

import java.io.BufferedReader;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.service.MsgServiceRemote;

public class EjbClient {

	InitialContext context;
	BufferedReader reader = null;
	Properties jndiProps;

	{
		jndiProps = new Properties();
		try {
			// props.load(new
			// FileInputStream("C:\\dev\\workspace\\ServiceProtocolsExp\\ServiceProtocolModel\\src\\main\\java\\configuration\\jndi.properties"));
			jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put(Context.PROVIDER_URL, "remote://localhost");
			jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			jndiProps.put(Context.SECURITY_PRINCIPAL, "client");
			jndiProps.put(Context.SECURITY_CREDENTIALS, "client");
			jndiProps.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
			jndiProps.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
			context = new InitialContext(jndiProps);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NamingException {

		new EjbClient().ejbTestStateless();

	}

	private void ejbTestStateless() {

		try {
			MsgServiceRemote bsr = (MsgServiceRemote) context.lookup(MsgServiceRemote.class.getName() + "/remote");

			System.out.println(bsr.sendMsg("first ejb ..."));
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
