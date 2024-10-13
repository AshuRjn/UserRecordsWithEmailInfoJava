package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.RegistrationDto;
import com.webapp.enity.Registration;
import com.webapp.service.RegistrationService;
import com.webapp.util.EmailService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	  
	
	
	//@Autowired
	//private EmailService emailService;

	// http://localhost:8080/view
	
	// http://localhost:8080/listAll
	@RequestMapping("/view")
	public String viewCreateRegistrationpage() {
		return "create_registration";
	}

	// 1> method to save data n database :
//	@RequestMapping("/saveReg")
//	public String getRegistration(@ModelAttribute Registration registration) {
//	    registrationService.createregistration(registration);
//		return "create_registration";
//	}

	// 2> method to save data in database :
//	@RequestMapping("/saveReg")
//	public String getRegistration(@RequestParam("firstname") String name, @RequestParam("email") String email,
//			@RequestParam("mobile") String mobile
//
//	) {
//		Registration registration = new Registration();
//		registration.setFirstname(name);
//		registration.setEmail(email);
//		registration.setMobile(mobile);
//		registrationService.createregistration(registration);
//		return "create_registration";
//	}

//_________________________________________________________________________________________________
	
//	// 3> method save data in databse :
//	@RequestMapping("/saveReg")
//	public String getRegistration(@ModelAttribute RegistrationDto registrationDto, ModelMap model) {
//		
//		Registration registration = new Registration();
//		registration.setFirstname(registrationDto.getFirstname());
//		registration.setEmail(registrationDto.getEmail());
//		registration.setMobile(registrationDto.getMobile());
//		
//		// to send the msg in email 
//	//	emailService.sendEmail(registrationDto.getEmail(), "Registration", "Your registratin is  saved  Sucessfully!!");
//
//		// to print the msg in jsp page 
//		model.addAttribute("msg", "Record is Saved!!!");
//
//		// return to registration page 
//		registrationService.createregistration(registration);
//		return "create_registration";
//	}
	
//------------------------------------------------------------------------------------------------------------------------------
	
	//chatgpt part 
	   @RequestMapping("/saveReg")
	    public String getRegistration(@ModelAttribute RegistrationDto registrationDto, ModelMap model) {
	        
	        Registration registration = new Registration();
	        registration.setFirstname(registrationDto.getFirstname());
	        registration.setEmail(registrationDto.getEmail());
	        registration.setMobile(registrationDto.getMobile());

	        // Save the registration details
	        registrationService.createregistration(registration);

	        // Send registration details via email
	        registrationService.registerUser(
	            registrationDto.getFirstname(),
	            registrationDto.getEmail(),
	            registrationDto.getMobile()
	        );

	        // To print the message on the JSP page
	        model.addAttribute("msg", "Record is Saved and Email Sent!!!");

	        return "create_registration";
	    } 
	  

	   
//........................................................................................................................
	// Reading all registration method 
	@RequestMapping("/listAll")
	public String getAllRegistration(ModelMap model) {
		List<Registration> registrations = registrationService.getAllRegistrations();
		model.addAttribute("registrations",registrations);
		return "list_registration";
	}
	
	//delete registration method
	@RequestMapping("/deleteReg")
	public String deleteRegistration(
			@RequestParam long id , 	ModelMap model
			) {
		registrationService.deleteRegistrationById(id);
		List<Registration> registrations = registrationService.getAllRegistrations();
		model.addAttribute("registrations",registrations);
		return "list_registration";
	}
	
	// getting data on update page  by id method
	@RequestMapping("/getRegById")
	public String getRegistrationById(
			@RequestParam long id ,	ModelMap model
			) {
		Registration registrations = registrationService.getRegById(id);
		model.addAttribute("registrations",registrations);
		return "update_registration"; // sent data to update page 
	}
	
	// update method
//	@RequestMapping("/updateReg")
//	public String updateRegistration(
//            Registration registration, // entity class object 
//			ModelMap model
//			) {
//		// create updateregistration method and pass registration object in it 
//		registrationService.updateRegistration(registration);
//		List<Registration> registrations = registrationService.getAllRegistrations();
//		model.addAttribute("registrations",registrations);
//		return "list_registration"; // get back to list page 
//		
//	}	
	//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
	@RequestMapping("/updateReg")
    public String updateRegistration(
            @ModelAttribute Registration registration, // Ensure this matches your form fields
            ModelMap model
    ) {
        // Update registration and send email
        registrationService.updateRegistration(registration);

        // Fetch all registrations and add them to the model
        List<Registration> registrations = registrationService.getAllRegistrations();
        model.addAttribute("registrations", registrations);

        return "list_registration"; // Redirect to list page or appropriate view
    }
}

