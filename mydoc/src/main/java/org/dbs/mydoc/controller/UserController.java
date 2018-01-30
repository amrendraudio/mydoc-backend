package org.dbs.mydoc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.dbs.mydoc.business.entity.User;
import org.dbs.mydoc.persistence.document.DBUser;
import org.dbs.mydoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(value = "/mydoc/users/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DBUser> registerUser(@Valid @RequestBody User user) {
		DBUser dbUser = new DBUser();
		try {

			dbUser.setId(new ObjectId().getCounter());
			dbUser.setFirstName(user.getFirstName());
			dbUser.setLastName(user.getLastName());
			dbUser.setEmailId(user.getEmailId());
			dbUser.setMobileNumber(user.getMobileNumber());
			dbUser.setPracticeId(user.getPracticeId());
			dbUser.setUserType(user.getUserType());
			userRepository.save(dbUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<DBUser>(dbUser, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "getallusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DBUser> getAll() {
		return userRepository.findAll();
	}
}
