package io.github.fernandoferreira.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.fernandoferreira.servico.AgendamentoEmailServico;

@WebServlet("/emails")
public class AgendamentoEmailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		this.agendamentoEmailServico.listar().forEach(email -> pw.print("Os emails disponiveis sao: " + email));
	}
}
