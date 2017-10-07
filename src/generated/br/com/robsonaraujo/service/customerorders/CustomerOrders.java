package br.com.robsonaraujo.service.customerorders;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2017-10-07T10:50:06.054-03:00
 * Generated source version: 3.1.6
 * 
 */
@WebService(targetNamespace = "http://customerorders.service.robsonaraujo.com.br/", name = "CustomerOrders")
@XmlSeeAlso({br.com.robsonaraujo.service.customerorders.types.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerOrders {

    @WebMethod
    @WebResult(name = "getOrdersResponse", targetNamespace = "http://types.customerorders.service.robsonaraujo.com.br/", partName = "parameters")
    public br.com.robsonaraujo.service.customerorders.types.GetOrdersResponse getOrders(
        @WebParam(partName = "parameters", name = "getOrdersRequest", targetNamespace = "http://types.customerorders.service.robsonaraujo.com.br/")
        br.com.robsonaraujo.service.customerorders.types.GetOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "createOrdersResponse", targetNamespace = "http://types.customerorders.service.robsonaraujo.com.br/", partName = "parameters")
    public br.com.robsonaraujo.service.customerorders.types.CreateOrdersResponse createOrders(
        @WebParam(partName = "parameters", name = "createOrdersRequest", targetNamespace = "http://types.customerorders.service.robsonaraujo.com.br/")
        br.com.robsonaraujo.service.customerorders.types.CreateOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "deleteOrdersResponse", targetNamespace = "http://types.customerorders.service.robsonaraujo.com.br/", partName = "parameters")
    public br.com.robsonaraujo.service.customerorders.types.DeleteOrdersResponse deleteOrders(
        @WebParam(partName = "parameters", name = "deleteOrdersRequest", targetNamespace = "http://types.customerorders.service.robsonaraujo.com.br/")
        br.com.robsonaraujo.service.customerorders.types.DeleteOrdersRequest parameters
    );
}
