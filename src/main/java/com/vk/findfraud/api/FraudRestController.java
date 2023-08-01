package com.vk.findfraud.api;

import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vk.findfraud.database.DatabaseUtil;
import com.vk.findfraud.database.model.Fraud;
import com.vk.findfraud.database.model.Proof;
import com.vk.findfraud.database.model.User;
import com.vk.findfraud.util.Util;
import com.vk.findfraud.util.ValidationMessage;

@RestController
@RequestMapping("fraud")
public class FraudRestController {

	// Add Fraud
	@RequestMapping(value = "/addFraud")
	public ResponseEntity<String> addFraud(@RequestParam("user_id") String user_id, @RequestParam("unit") String unit) {

		Gson gson = new Gson();
		String jsonRequest = unit;

		// TODO read data from mobile
		Fraud fraud = new Fraud();
		fraud.setCreatedDate(Util.getCurrentDate());

		HttpStatus httpStatus;

		JSONObject resultObject = new JSONObject();
		JSONObject errorObect = new JSONObject();

		// ValidationMessage message = requestTable.validate(requestTable);
		ValidationMessage message = new ValidationMessage("", true);
		if (!message.isValue()) {
			errorObect.put("errorStatus", true);
			errorObect.put("errorMessage", message.getMessage());
			errorObect.put("errorId", 2);

			httpStatus = HttpStatus.BAD_REQUEST;
			resultObject.put("status", httpStatus.value());
			resultObject.put("error", errorObect);
			return new ResponseEntity<String>(resultObject.toString(), httpStatus);
		}

		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// TODO retrieve PROOFS LIST
		User user = (User) session.get(User.class, user_id);
		fraud.setUser(user);

		// fraud.setProofList(proofList);

		long id = (Long) session.save(fraud);

		if (id != 0) {
			fraud.setFraud_id(id);
			// String reponseData = gson.toJson(requestTable);
			JSONObject responseObject = new JSONObject();

			responseObject.put("fraud_id", fraud.getFraud_id());
			responseObject.put("name", fraud.getIssueType());
			responseObject.put("createdDate", fraud.getCreatedDate());
			responseObject.put("modifiedDate", fraud.getModifiedDate());

			resultObject.put("fraud", responseObject);
			errorObect.put("errorStatus", false);
			errorObect.put("errorMessage", "Fraud Added Successfully");
			errorObect.put("errorId", -1);
			httpStatus = HttpStatus.ACCEPTED;
		} else {
			errorObect.put("errorStatus", true);
			errorObect.put("errorMessage", "Please check the Unit data");
			errorObect.put("errorId", 1);
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		resultObject.put("status", httpStatus.value());
		resultObject.put("error", errorObect);
		session.getTransaction().commit();
		session.close();
		return new ResponseEntity<String>(resultObject.toString(), httpStatus);
	}

	// update Fraud
	@RequestMapping(value = "/updateFraud")
	public String updateFraud(@RequestParam("user_id") String user_id, @RequestParam("fraud") String fraudRequest) {

		long fraud_id = 0;
		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Fraud fraud = (Fraud) session.get(Fraud.class, fraud_id);

		session.update(fraud);

		return "updateSuccessfully";
	}

	// delete Fraud
	@RequestMapping(value = "/deleteFraud")
	public String deleteFraud(@RequestParam("user_id") String user_id, @RequestParam("fraud") long fraud_id) {

		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Fraud fraud = (Fraud) session.get(Fraud.class, fraud_id);

		session.delete(fraud);

		return "updateSuccessfully";
	}

	// delete Proof
	@RequestMapping(value = "/deleteProof")
	public String deleteProof(@RequestParam("user_id") String user_id, @RequestParam("proof_id") long proof_id) {

		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Proof proof = (Proof) session.get(Proof.class, proof_id);

		session.delete(proof);

		return "updateSuccessfully";
	}

	// update Proof
	@RequestMapping(value = "/updateProof")
	public String updateProof(@RequestParam("user_id") String user_id, @RequestParam("proof_id") long proof_id) {

		Session session = DatabaseUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Proof proof = (Proof) session.get(Proof.class, proof_id);

		session.update(proof);

		return "updateSuccessfully";
	}
}
