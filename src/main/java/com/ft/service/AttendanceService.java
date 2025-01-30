package com.ft.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.entity.Attendance;
import com.ft.entity.Employee;
import com.ft.repository.AttendanceRepository;
import com.ft.repository.EmployeeRepository;

@Service
public class AttendanceService {
	@Autowired
	private AttendanceRepository attendanceRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public Attendance markCheckIn(long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);

		Employee employee = employeeOptional.get();

		Attendance attendance = new Attendance();
		attendance.setEmployee(employee);
		attendance.setCheckIn(LocalDateTime.now());

		return attendanceRepository.save(attendance);
	}

	public Attendance markCheckOut(Long aid) {

		Attendance attendance = new Attendance();
		attendance.setCheckOut(LocalDateTime.now());
		return attendanceRepository.save(attendance);
	}

	public List<Attendance> getAttendanceByEmployee(Long eid) {
		return attendanceRepository.findByEmployeeId(eid);
	}

}
