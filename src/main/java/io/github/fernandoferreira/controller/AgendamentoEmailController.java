package io.github.fernandoferreira.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.github.fernandoferreira.entidade.AgendamentoEmail;
import io.github.fernandoferreira.servico.AgendamentoEmailServico;

@Path("emails")
public class AgendamentoEmailController {

	@Inject
	private AgendamentoEmailServico agendamentoServico;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listar() {
		return Response.ok(this.agendamentoServico.listar()).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response inserir(AgendamentoEmail agendamentoEmail) {
		this.agendamentoServico.inserir(agendamentoEmail);
		
		return Response.status(201).build();
	}
}
