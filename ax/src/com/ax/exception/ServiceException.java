package com.ax.exception;

/**
 * 服务层异常
 * @author Administrator
 *
 */
public class ServiceException extends Exception{

   private static final long serialVersionUID = 1L;
   
   public ServiceException(){
	   super();
   }
   
   public ServiceException(String msg){
	   super(msg);
   }

}
