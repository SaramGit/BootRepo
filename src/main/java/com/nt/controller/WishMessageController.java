package com.nt.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageController extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		  Calendar calender=null;
		  int hour=0;
		   String wmg=null;
		   ModelAndView mav=null;
		  //get the calendar class object
		  calender=Calendar.getInstance();
		  //get current hour of the day
		  hour=calender.get(Calendar.HOUR_OF_DAY);
		  //generate the wish message
		  if(hour<=12)
			  wmg="Good morning";
		  else if(hour<=16)
			  wmg="Good AfterNoon";
		  else if(hour<=20)
			  wmg="Good evening";
		  else
			  wmg="Good night";
		  //get the model and view class object
		  mav=new ModelAndView();
		  //add result into mav object
		  mav.addObject("msg", wmg);
		  mav.addObject("sysDate",new Date());
		  mav.setViewName("result");
		return mav;
	}

}
