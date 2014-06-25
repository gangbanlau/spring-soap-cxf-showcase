1.	关于单元测试，现在暂时只能用启动服务器的方式测试，还不能做到不用启动服务器测试，未完待续。
2.	@WebService(endpointInterface = "com.maingel.soap.web.IHelloWorld")
	public class HelloWorldImpl implements IHelloWorld {}
	的作用是指明IHelloWorld为SEI，在实现类有多个接口时使用，一个时可省略。
3.	@WebMethod，@WebParam，@WebResult这三个是写在接口上的，如果需要指定如参数名，返回值等可使用，不是必须的。
4.	关于WSDL文件，其中有<wsdl:import>标签，输入location可以进入下一层。