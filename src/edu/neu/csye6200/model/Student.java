/**
 * 
 */
package edu.neu.csye6200.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.util.ConversionUtil;

/**
 * @author pnakave
 *
 */
public class Student extends Person {

	private int studentId;
	private LocalDate registrationDate;
	private String address;
	private int age;
	private LocalDate dob;
	private Parent parent;
	private int parentId;
	private List<Vaccine> immunizationRecord = new ArrayList<>();
	private Teacher teacher_assigned;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, LocalDate registrationDate, String address, int age, LocalDate dob, Parent parent,
			Teacher teacher_assigned) {
		super();
		this.studentId = studentId;
		this.registrationDate = registrationDate;
		this.address = address;
		this.age = age;
		this.dob = dob;
		this.parent = parent;
		this.teacher_assigned = teacher_assigned;
	}

	public Student(int studentId, String firstName, String lastName, LocalDate registrationDate, LocalDate dob,
			String address, int parentId) {
		super(firstName, lastName);
		this.studentId = studentId;
		this.registrationDate = registrationDate;
		this.address = address;
		this.age = ConversionUtil.getAgeFromDOB(this.dob);
		this.parentId = parentId;
		this.dob = dob;
	}

	public Student(int studentId, String firstName, String lastName, LocalDate registrationDate, LocalDate dob, int age,
			String address, int parentId) {
		super(firstName, lastName);
		this.studentId = studentId;
		this.registrationDate = registrationDate;
		this.address = address;
		this.parentId = parentId;
		this.dob = dob;
		this.age = age;
	}

	public Student(String csvData) {
		super();
		String[] field = csvData.split(",");
		this.studentId = Integer.parseInt(field[0]);
		this.firstName = field[1];
		this.lastName = field[2];
		this.dob = ConversionUtil.StringToLocalDate(field[3]);
		this.registrationDate = ConversionUtil.StringToLocalDate(field[4]);
		this.address = field[5];
		this.parent = new Parent(Integer.parseInt(field[6]), field[7], field[8], field[9], new BigInteger(field[10]));
		this.age = ConversionUtil.getAgeFromDOB(this.dob);

		List<String> vaccinesList = new ArrayList<>();
		vaccinesList.add(field[11]);
		vaccinesList.add(field[12]);
		this.immunizationRecord = getStudentImmunizationRecord(vaccinesList, studentId);

	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Teacher getTeacher_assigned() {
		return teacher_assigned;
	}

	public void setTeacher_assigned(Teacher teacher_assigned) {
		this.teacher_assigned = teacher_assigned;
	}

	public List<Vaccine> getImmunizationRecord() {
		return immunizationRecord;
	}

	public void setImmunizationRecord(List<Vaccine> immunizationRecord) {
		this.immunizationRecord = immunizationRecord;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public List<Vaccine> getStudentImmunizationRecord(List<String> vaccinesList, int studentId) {
		for (String vaccineDetails : vaccinesList) {
			if (vaccineDetails != null) {
				Vaccine vaccine = new Vaccine(vaccineDetails, studentId);
				checkVaccinationRules(vaccine);
				immunizationRecord.add(vaccine);
			}
		}
		return immunizationRecord;
	}

	public void checkVaccinationRules(Vaccine vaccine) {

		if (vaccine.getName().equalsIgnoreCase("Hib")) {
			checkHiBVaccinationRules(vaccine);
		} else if (vaccine.getName().equalsIgnoreCase("DTaP") || (vaccine.getName().equalsIgnoreCase("tdap"))) {
			checkDTaPVaccinationRules(vaccine);
		} else if (vaccine.getName().equalsIgnoreCase("HepatatisB")) {
			checkHepatatisBVaccinationRules(vaccine);
		} else if (vaccine.getName().equalsIgnoreCase("Polio")) {
			checkPolioVaccinationRules(vaccine);
		} else if (vaccine.getName().equalsIgnoreCase("Varicella")) {
			checkVaricellaVaccinationRules(vaccine);
		} else if (vaccine.getName().equalsIgnoreCase("MMR")) {
			checkMMRVaccinationRules(vaccine);
		} else if (vaccine.getName().equalsIgnoreCase("Meningococcal")) {
			checkMeningococcalVaccinationRules(vaccine);
		}
	}

	public void checkHiBVaccinationRules(Vaccine vaccine) {
		if (age / 12 < 2) {
			vaccine.setTotalDoses(4);
		} else {
			vaccine.setTotalDoses(4);
		}
		if (vaccine.getDosestaken() == vaccine.getTotalDoses()) {
			vaccine.setVaccinated(true);
		} else {
			vaccine.setNextShotDate(vaccine.getLastShotDate().plus(3, ChronoUnit.MONTHS));
		}
	}

	public void checkDTaPVaccinationRules(Vaccine vaccine) {

		if (age / 12 < 2) {
			vaccine.setTotalDoses(3);
		} else {
			vaccine.setTotalDoses(4);
		}

		if (vaccine.getDosestaken() == vaccine.getTotalDoses()) {
			vaccine.setVaccinated(true);
		} else {
			if (vaccine.getDosestaken() == 3)
				vaccine.setNextShotDate(dob.plus(4, ChronoUnit.YEARS));
			else
				vaccine.setNextShotDate(vaccine.getLastShotDate().plus(2, ChronoUnit.MONTHS));
		}
	}

	public void checkVaricellaVaccinationRules(Vaccine vaccine) {

		if (age / 12 < 2) {
			vaccine.setTotalDoses(1);
		} else {
			vaccine.setTotalDoses(2);
		}

		if (vaccine.getDosestaken() == vaccine.getTotalDoses()) {
			vaccine.setVaccinated(true);
		} else {
			if (vaccine.getDosestaken() == 0)
				vaccine.setNextShotDate(dob.plus(1, ChronoUnit.YEARS));
			if (vaccine.getDosestaken() == 1)
				vaccine.setNextShotDate(dob.plus(28, ChronoUnit.DAYS));
		}

	}

	public void checkMMRVaccinationRules(Vaccine vaccine) {

		if (age / 12 < 2) {
			vaccine.setTotalDoses(1);
		} else {
			vaccine.setTotalDoses(2);
		}

		if (vaccine.getDosestaken() == vaccine.getTotalDoses()) {
			vaccine.setVaccinated(true);
		} else {
			if (vaccine.getDosestaken() == 0)
				vaccine.setNextShotDate(dob.plus(1, ChronoUnit.YEARS));
			if (vaccine.getDosestaken() == 1)
				vaccine.setNextShotDate(dob.plus(28, ChronoUnit.DAYS));
		}

	}

	public void checkHepatatisBVaccinationRules(Vaccine vaccine) {
		if (age / 12 < 2) {
			vaccine.setTotalDoses(3);
		} else {
			vaccine.setTotalDoses(3);
		}
		if (vaccine.getDosestaken() == vaccine.getTotalDoses()) {
			vaccine.setVaccinated(true);
		} else {
			vaccine.setNextShotDate(vaccine.getLastShotDate().plus(3, ChronoUnit.MONTHS));
		}
	}

	public void checkMeningococcalVaccinationRules(Vaccine vaccine) {

		if (age / 12 < 2) {
			vaccine.setTotalDoses(0);
		} else {
			vaccine.setTotalDoses(2);
		}

		if (vaccine.getDosestaken() == vaccine.getTotalDoses()) {
			vaccine.setVaccinated(true);
		} else {
			if (vaccine.getDosestaken() == 0)
				vaccine.setNextShotDate(dob.plus(11, ChronoUnit.YEARS));
			if (vaccine.getDosestaken() == 1)
				vaccine.setNextShotDate(dob.plus(16, ChronoUnit.YEARS));
		}

	}

	public void checkPolioVaccinationRules(Vaccine vaccine) {

		if (age / 12 < 2) {
			vaccine.setTotalDoses(3);
		} else {
			vaccine.setTotalDoses(4);
		}

		if (vaccine.getDosestaken() == vaccine.getTotalDoses()) {
			vaccine.setVaccinated(true);
		} else {
			if (vaccine.getDosestaken() == 3)
				vaccine.setNextShotDate(dob.plus(4, ChronoUnit.YEARS));
			else
				vaccine.setNextShotDate(vaccine.getLastShotDate().plus(2, ChronoUnit.MONTHS));
		}
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", registrationDate=" + registrationDate + ", address=" + address
				+ ", age=" + age + ", dob=" + dob + ", parent=" + parent + ", parentId=" + parentId
				+ ", immunizationRecord=" + immunizationRecord +  "]";
	}
}
