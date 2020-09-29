package com.soap.ws;

import com.soap.ws.dto.RideRequest;
import com.soap.ws.dto.RideResponse;

public class RideService implements Ride {

	@Override
	public RideResponse ride(RideRequest rideRequest) {
		// TODO Auto-generated method stub
		RideResponse response = new RideResponse();
		response.setResult(true);
		return response;
	}

}
