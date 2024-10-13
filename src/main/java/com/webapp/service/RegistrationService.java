package com.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.enity.Registration;
import com.webapp.repository.RegistrationRepository;
import com.webapp.util.EmailService;
import com.webapp.util.RegistrationDetails;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    // method for save data in database :
    public void createregistration(Registration registration) {
        registrationRepository.save(registration);

    }

    // method for read all data from databse :
    public List<Registration> getAllRegistrations() {
        List<Registration> registrations = registrationRepository.findAll();
        return registrations;
    }

    // method for delete registration :
    public void deleteRegistrationById(long id) {

        registrationRepository.deleteById(id);

    }

    // method for get tha data on upadte page by id  :
    public Registration getRegById(long id) {

        Optional<Registration> opReg = registrationRepository.findById(id);
        Registration registration = opReg.get();
        return registration;
    }

    // update method and pass the registration object as argument in it  :
//	public void updateRegistration(Registration registration) {
//       registrationRepository.save(registration);	 // save the update data 	
//	}
//	
    //..............................................

    @Autowired
    private EmailService emailService;


    public void updateRegistration(Registration registration) {
        registrationRepository.save(registration); // Save the updated data

        // Send an update notification email
        RegistrationDetails registrationDetails = new RegistrationDetails(
                registration.getFirstname(),
                registration.getEmail(),
                registration.getMobile()
        );
        emailService.sendUpdateNotification(registration.getEmail(), registrationDetails);
    }

    //-----------------------------------------------------------------------------------------
    public void registerUser(String username, String email, String mobile) {
        // Save user details to the database (not shown)

        // Send registration details via email
        RegistrationDetails registrationDetails = new RegistrationDetails(username, email, mobile);
        emailService.sendRegistrationEmail(email, registrationDetails);
    }
}

