package com.soap.ws.client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.soap.ws.impl.CustomerOrdersWsImplService;
import com.ws.trainings.CreateOrdersRequest;
import com.ws.trainings.CreateOrdersResponse;
import com.ws.trainings.CustomerOrdersPortType;
import com.ws.trainings.GetOrdersRequest;
import com.ws.trainings.GetOrdersResponse;
import com.ws.trainings.Order;
import com.ws.trainings.Product;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:1030/CustomerOrdersService/CustomerOrdersService?wsdl"));
		
		CustomerOrdersPortType port = service.getCustomerOrdersWsImplPort();
		
		GetOrdersRequest getReq = new GetOrdersRequest();
		getReq.setCustomerId(BigInteger.valueOf(1));
		
		GetOrdersResponse gerResp = port.getOrders(getReq);
		List<Order> order = gerResp.getOrder();
		System.out.println("order size is "+order.size());
		
		CreateOrdersRequest createReq = new CreateOrdersRequest();
		createReq.setCustomerId(BigInteger.valueOf(1));
		Order or1 = new Order();
		or1.setId(BigInteger.valueOf(2));
		Product product = new Product();
		product.setId("3456");
		product.setDescription("MAV");
		product.setQuantity(BigInteger.valueOf(10));
		or1.getProduct().add(product);
		createReq.setOrder(or1);
		
		CreateOrdersResponse createResp = port.createOrders(createReq);
		boolean results = createResp.isResults();
		System.out.println("Result is "+ results);
	}
}
