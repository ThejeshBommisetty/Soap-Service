package com.soap.ws.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long,Patient> patients = new HashMap<>();
	long currentId=123;
	
	public PatientServiceImpl(){
		init();
	}
	
	public void init() {
		Patient pat = new Patient();
		pat.setId(currentId);
		pat.setName("theju");
		patients.put(pat.getId(), pat);
		
	}
	@Override
	public List<Patient> getPatients() {
		Collection<Patient> values = patients.values();
		List<Patient> result = new ArrayList<>(values);
		return result;
	}

	@Override
	public Patient getPatient(Long id) {
		Patient patient = patients.get(id);
		return patient;
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient pat = patients.get(patient.getId());
		Response resp = null;
		if(pat!=null) {
			patients.put(pat.getId(), patient);
			resp.ok().build();
		}
		else
			resp.notModified().build();
		return resp;
	}

	@Override
	public Response deletePatient(Long id) {
		Response resp=null;
		Patient pat = patients.get(id);
		if(pat!=null) {
			patients.remove(id);
			resp.ok().build();
		}else
			resp.notModified().build();
		return resp;
	}

}
