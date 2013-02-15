package se.swejug.squads.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.swejug.squads.filters.DispatchFilter;

public class HtmlServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final List<String> parts = new ArrayList<String>();
    
    public List<String> getParts() {
	return parts;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	// TODO: gather info and select appropriate jsp file
	request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
	throws ServletException, IOException {
	this.parts.clear();
	this.parts.addAll((List<String>) request.getAttribute(DispatchFilter.REQUEST_PARTS));
	super.service(request, response);
    }

}
