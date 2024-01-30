package com.app.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.modal.Payment;
import com.app.modal.PaymentNotFoundException;
import com.app.modal.Student;
import com.app.modal.StudentNotFoundException;
import com.app.repository.PaymentRepository;
import com.app.repository.StudentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Map<String, Object> addPayment(String student_id, Payment payment) {
		Map<String, Object> map = new HashMap<>();
		Student student = studentRepository.findById(student_id)
                .orElseThrow(
               		 ()-> new StudentNotFoundException("Student: "+student_id+", not Found")
               		 );
//		System.out.println(student);
		
		LocalDate payment_date = payment.getPayment_date();
		LocalDate admission_date = student.getAdmission_date();
		
//		System.out.println(payment_date+" "+admission_date);
		
		int days_delay = Period.between(admission_date, payment_date).getDays();
		
		 double fine_amount = days_delay*100.0;
		
		
//		 System.out.println(fine_amount);
		Double payable_amount = payment.getPaying_amount()+fine_amount;
		payment.setPayable_amount(payable_amount);
		payment.setStudent_id(student);
//		System.out.println(payable_amount);
		
		
		student.setCurrent_debt(
				student.getCurrent_debt() - payment.getPaying_amount()
				);
		student.getPayments().add(payment);
		
		Payment saved_payment = paymentRepository.save(payment);
		
		map.put("days_delay",days_delay );
		map.put("charged_fine", fine_amount);
		map.put("payable_amount",payable_amount );
		map.put("student", student);
		map.put("payment", saved_payment);
		
		return map;
	}

	@Override
	public Payment getPaymentById(String _id) {
		Payment payment = paymentRepository.findById(_id)
                .orElseThrow(
               		 ()-> new PaymentNotFoundException("Payment: "+_id+", not Found!!!")
               		 );
		return payment;
	}

	@Override
	public List<Payment> getAllPayments() {

		List<Payment> list = paymentRepository.findAll();
		if(list.isEmpty()) throw new PaymentNotFoundException("No Payment Found!!!");
		
		return list;
	}

}
