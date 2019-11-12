package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.GstProduct;
import com.nt.service.GstProductService;

@Controller
public class ProductController {

	@Autowired
    private GstProductService service;
    @GetMapping("/")
    private String home(Model model) {
  	  model.addAttribute("product", new GstProduct());
  	  int  GstRate=service.findGstRate();
  	  model.addAttribute("gstrate",GstRate);
  	  return "view/products";
  	  }
    
    @PostMapping(value = "/fileupload")
    private String uploadFile(@ModelAttribute GstProduct product,RedirectAttributes attributes) {
  	  boolean isflag=service.saveDataFromUploadFile(product.getFile());
  	         if (isflag) {
			           attributes.addAttribute("SuccessMessage", "File Uploaded successfully.............");
		         }
  	         else {
  	        	  attributes.addAttribute("ErrorMessage", "File Upload Failed Try again later..........");
				}
  	         
  	  return "redirect:/";
    }
}
