package io.github.fernandoferreira.servlet;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import io.github.fernandoferreira.entidade.AgendamentoEmail;
//import io.github.fernandoferreira.servico.AgendamentoEmailServico;

/* Deixei esta classe apenas para estudo de como era feito antes de usar o JAX-RS */

//@WebServlet("/emails")
//public class AgendamentoEmailServlet extends HttpServlet {
//	
//	private static final long serialVersionUID = 1L;
//	
//	@Inject
//	private AgendamentoEmailServico agendamentoEmailServico;
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter pw = resp.getWriter();
//		this.agendamentoEmailServico.listar().forEach(email -> pw.print("Os emails disponiveis sao: " + email));
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String email = req.getParameter("email");
//		String assunto = req.getParameter("assunto");
//		String mensagem = req.getParameter("mensagem");
//		
//		System.out.println("Email -> " + email);
//		System.out.println("Assunto -> " + assunto);
//		System.out.println("Mensagem -> " + mensagem);
//		
//		BufferedReader reader = req.getReader();
//		
//		System.out.println(reader);
//		
//		String email = reader.readLine().split(",")[0];
//		String assunto = reader.readLine().split(",")[1];
//		String mensagem = reader.readLine().split(",")[2];
		
//		AgendamentoEmail agendamentoEmail = new AgendamentoEmail();
//		agendamentoEmail.setEmail(email);
//		agendamentoEmail.setAssunto(assunto);
//		agendamentoEmail.setMensagem(mensagem);
//		this.agendamentoEmailServico.inserir(agendamentoEmail);
//	}
//}
