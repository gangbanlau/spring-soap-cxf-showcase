package com.maingel.soap.web;

public class IHelloWorldProxy implements com.maingel.soap.web.IHelloWorld {
  private String _endpoint = null;
  private com.maingel.soap.web.IHelloWorld iHelloWorld = null;
  
  public IHelloWorldProxy() {
    _initIHelloWorldProxy();
  }
  
  public IHelloWorldProxy(String endpoint) {
    _endpoint = endpoint;
    _initIHelloWorldProxy();
  }
  
  private void _initIHelloWorldProxy() {
    try {
      iHelloWorld = (new com.maingel.soap.web.HelloWorldImplServiceLocator()).getHelloWorldImplPort();
      if (iHelloWorld != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iHelloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iHelloWorld)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iHelloWorld != null)
      ((javax.xml.rpc.Stub)iHelloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.maingel.soap.web.IHelloWorld getIHelloWorld() {
    if (iHelloWorld == null)
      _initIHelloWorldProxy();
    return iHelloWorld;
  }
  
  public java.lang.String addUser(com.maingel.soap.web.UserDTO user) throws java.rmi.RemoteException{
    if (iHelloWorld == null)
      _initIHelloWorldProxy();
    return iHelloWorld.addUser(user);
  }
  
  public com.maingel.soap.web.UserDTO[] findAllUser() throws java.rmi.RemoteException{
    if (iHelloWorld == null)
      _initIHelloWorldProxy();
    return iHelloWorld.findAllUser();
  }
  
  public java.lang.String sayHi(java.lang.String text) throws java.rmi.RemoteException{
    if (iHelloWorld == null)
      _initIHelloWorldProxy();
    return iHelloWorld.sayHi(text);
  }
  
  public com.maingel.soap.web.UserDTO findUserById(long id) throws java.rmi.RemoteException{
    if (iHelloWorld == null)
      _initIHelloWorldProxy();
    return iHelloWorld.findUserById(id);
  }
  
  public java.lang.String addAllUser(com.maingel.soap.web.UserDTO[] arg0) throws java.rmi.RemoteException{
    if (iHelloWorld == null)
      _initIHelloWorldProxy();
    return iHelloWorld.addAllUser(arg0);
  }
  
  
}