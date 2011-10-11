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
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
	        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
 
		context.addServlet(new ServletHolder(new HelloServlet("Buongiorno Mondo")),"/it/*");
		context.addServlet(new ServletHolder(new HelloServlet("Bonjour le Monde")),"/fr/*");
		context.addServlet(new ServletHolder(new HelloServlet()),"/*");
 
		server.start();
		server.join();	
	}

	private static class HelloServlet extends HttpServlet {
		private String greeting="Hello World";

		public HelloServlet(){}
		public HelloServlet(String greeting)
		{
			this.greeting=greeting;
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
		{
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("<h1>"+greeting+"</h1>");
			response.getWriter().println("session=" + request.getSession(true).getId());
		}
	}
}