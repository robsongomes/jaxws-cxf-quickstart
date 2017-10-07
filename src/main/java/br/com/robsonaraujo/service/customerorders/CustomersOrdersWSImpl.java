package br.com.robsonaraujo.service.customerorders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.jws.WebService;

import br.com.robsonaraujo.service.customerorders.types.CreateOrdersRequest;
import br.com.robsonaraujo.service.customerorders.types.CreateOrdersResponse;
import br.com.robsonaraujo.service.customerorders.types.DeleteOrdersRequest;
import br.com.robsonaraujo.service.customerorders.types.DeleteOrdersResponse;
import br.com.robsonaraujo.service.customerorders.types.GetOrdersRequest;
import br.com.robsonaraujo.service.customerorders.types.GetOrdersResponse;
import br.com.robsonaraujo.service.customerorders.types.Order;
import br.com.robsonaraujo.service.customerorders.types.Product;

@WebService(serviceName="customerOrdersService",
			endpointInterface="br.com.robsonaraujo.CustomerOrders")
public class CustomersOrdersWSImpl implements CustomerOrders {
	
	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	int currentCustomerId;
	
	public CustomersOrdersWSImpl() {
		init();
	}

	private void init() {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.ONE);
		Product product = new Product();
		product.setId("1");
		product.setDescription("Iphone");
		product.setQuantity(BigInteger.valueOf(3l));
		
		order.getProduct().add(product);
		
		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentCustomerId), orders);
	}

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		
		GetOrdersResponse response = new GetOrdersResponse();
		response.getOrder().addAll(orders);
		
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		Order order = request.getOrder();
		
		customerOrders.get(request.getCustomerId()).add(order);
		
		CreateOrdersResponse response = new CreateOrdersResponse();
		response.setResult(true);
		
		return response;
	}
	
	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		BigInteger orderId = request.getOrderId();
		
		Optional<Order> order = customerOrders.get(customerId)
				.stream()
				.filter(o -> o.getId().equals(orderId))
				.findFirst();
		
		DeleteOrdersResponse response = new DeleteOrdersResponse();
		
		if (order.isPresent()) {
			customerOrders.get(customerId).remove(order.get());
			response.setResult(true);
		} else {
			response.setResult(false);
		}
		
		return response;
	}

}
