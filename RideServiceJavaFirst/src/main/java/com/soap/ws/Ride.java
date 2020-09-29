package com.soap.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.soap.ws.dto.RideRequest;
import com.soap.ws.dto.RideResponse;

@WebService(name="Ride")
public interface Ride {

	@WebMethod
	public RideResponse ride(@WebParam(name="rideRequest") RideRequest rideRequest);	
	
	
}
