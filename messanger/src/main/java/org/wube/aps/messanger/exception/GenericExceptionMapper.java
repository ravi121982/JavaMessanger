package org.wube.aps.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.wube.aps.messanger.model.ErrorMessage;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404,"http://javabrains.koushik.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
					   .entity(errorMessage)
					   .build();
	}
	
}
