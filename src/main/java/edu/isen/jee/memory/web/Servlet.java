package edu.isen.jee.memory.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.criteria.Predicate.BooleanOperator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet(urlPatterns = "/g/*")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Log LOG = LogFactory.getLog(Servlet.class);

	@Inject
	MemoryBean game;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = getTokenFromRequest(req);

		if (StringUtils.isEmpty(token) || req.getParameter("reset") != null) {
			game.createNewGame();
			redirectToGameRoot(req, resp);
			return;
		}
		game.loadFromToken(token);

		String wait = req.getParameter("wait");
		if(wait!=null){
			game.returnLastCards();
			redirectToGameRoot(req, resp);
			return;
		}
		
		String playCard = req.getParameter("playCard");		
		if (playCard != null) {
			game.play(Integer.parseInt(playCard));
			redirectToGameRoot(req, resp);
			return;
		}
		if (!game.getIfReplay()) {
			System.out.println("go refresh");
			resp.setHeader("Refresh", "1;url="+getGameURL(req)+"?wait=true");
		}
		
		req.getRequestDispatcher("/game.jsp").include(req, resp);
	}

	private void redirectToGameRoot(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(getGameURL(request));
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		if (request == null) {
			return "";
		}

		String token = request.getRequestURI()
				.substring(request.getContextPath().length() + request.getServletPath().length() + 1);
		return token;
	}
	
	private String getGameURL(HttpServletRequest request){
		return request.getContextPath() + request.getServletPath() + "/" + game.getToken();
	}
}
