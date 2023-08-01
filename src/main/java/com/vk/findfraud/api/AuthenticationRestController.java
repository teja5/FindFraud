package com.vk.findfraud.api;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.findfraud.database.DatabaseUtil;
import com.vk.findfraud.database.model.Proof;
import com.vk.findfraud.database.model.User;

@RestController
@RequestMapping("authentication")
public class AuthenticationRestController {

	// Register Application
	// pass data
	@RequestMapping(value = "/register")
	public String register(@RequestParam("details") String details) {

		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User();
		// Proof proof = (Proof) session.get(Proof.class, proof_id);

		session.save(user);

		return "added Successfully";
	}

	// Login Application
	// pass data
	@RequestMapping(value = "/login")
	public String login(@RequestParam("details") String details) {

		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		User user = session.get(User.class, 0);

		return "added Successfully";
	}

	// ForgetPassword Application
	// pass data
	@RequestMapping(value = "/forgetPassword")
	public String forgetPassword(@RequestParam("details") String details) {

		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		User user = session.get(User.class, 0);

		return "Forget Password";
	}
}