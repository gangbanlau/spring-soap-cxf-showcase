/**
 * IHelloWorld.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.maingel.soap.web;

public interface IHelloWorld extends java.rmi.Remote {
    public java.lang.String addUser(com.maingel.soap.web.UserDTO user) throws java.rmi.RemoteException;
    public com.maingel.soap.web.UserDTO[] findAllUser() throws java.rmi.RemoteException;
    public java.lang.String sayHi(java.lang.String text) throws java.rmi.RemoteException;
    public com.maingel.soap.web.UserDTO findUserById(long id) throws java.rmi.RemoteException;
    public java.lang.String addAllUser(com.maingel.soap.web.UserDTO[] arg0) throws java.rmi.RemoteException;
}
