package com.drfloob.irrelevant;

import org.eclipse.jetty.server.Server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServletServer {

	private static ControllerRegistry cr = new ControllerRegistry();

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
	        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
 
		context.addServlet(new ServletHolder(new ControllerServlet()),"/*");
 
		server.start();
		server.join();	
	}

	private static class ControllerServlet extends HttpServlet {
		public ControllerServlet() throws Exception {
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
		{

			response.setStatus(HttpServletResponse.SC_OK);
			String id = request.getSession(true).getId();
			
			try {
				cr.dispatch(id, request.getPathInfo());
			} catch (Exception e) {
				System.err.println(e.getMessage());
				response.getWriter().println(e.getMessage());
			}
		}
	}
}