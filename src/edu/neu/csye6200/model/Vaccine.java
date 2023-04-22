package edu.neu.csye6200.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author eraricamehra
 *
 */
public class Vaccine {

	private int id;
	private String name;
	private int dosestaken;
	private int totalDoses;
	private LocalDate lastShotDate;
	private LocalDate nextShotDate;
	private int studentId;
	private boolean isVaccinated;
	private List<LocalDate> vaccinationRecord = new ArrayList<>();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Vaccine() {

	}

	public Vaccine(int id, String name, int dosestaken, int totalDoses, LocalDate lastShotDate, LocalDate nextShotDate,
			int studentId, boolean isVaccinated, List<LocalDate> vaccinationRecord) {
		super();
		this.id = id;
		this.name = name;
		this.dosestaken = dosestaken;
		this.totalDoses = totalDoses;
		this.lastShotDate = lastShotDate;
		this.nextShotDate = nextShotDate;
		this.studentId = studentId;
		this.isVaccinated = isVaccinated;
		this.vaccinationRecord = vaccinationRecord;
	}

//constructor to parse from CSV
//data in the format (eg: "HepatatisB:2020-10-12|2020-11-12|2020-12-12")
	public Vaccine(String vaccine, int studentId) {
		String[] vaccineData = vaccine.split(":");
		this.name = vaccineData[0];
		String vaccinationDates = vaccineData[1];
		String[] dates = vaccinationDates.split("&");
		for (String value : dates) {
			this.vaccinationRecord.add(LocalDate.parse(value, formatter));
		}
		this.studentId = studentId;
		this.dosestaken = vaccinationRecord.size();
		this.lastShotDate = vaccinationRecord.get(vaccinationRecord.size() - 1);

	}

	public boolean isVaccinationCompleted() {
		return (totalDoses == vaccinationRecord.size());
	}

	public int getTotalDoses() {
		return totalDoses;
	}

	public void setTotalDoses(int totalDoses) {
		this.totalDoses = totalDoses;
	}

	public LocalDate getLastShotDate() {
		return lastShotDate;
	}

	public void setLastShotDate(LocalDate lastShotDate) {
		this.lastShotDate = lastShotDate;
	}

	public LocalDate getNextShotDate() {
		return nextShotDate;
	}

	public void setNextShotDate(LocalDate nextShotDate) {
		this.nextShotDate = nextShotDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public boolean isVaccinated() {
		return isVaccinated;
	}

	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LocalDate> getVaccinationRecord() {
		return vaccinationRecord;
	}

	public void setVaccinationRecord(List<LocalDate> vaccinationRecord) {
		this.vaccinationRecord = vaccinationRecord;
	}

	public int getDosestaken() {
		return dosestaken;
	}

	public void setDosestaken(int dosestaken) {
		this.dosestaken = dosestaken;
	}

	@Override
	public String toString() {
		return "Vaccine [id=" + id + ", name=" + name + ", dosestaken=" + dosestaken + ", totalDoses=" + totalDoses
				+ ", lastShotDate=" + lastShotDate + ", nextShotDate=" + nextShotDate + ", studentId=" + studentId
				+ ", isVaccinated=" + isVaccinated + ", vaccinationRecord=" + vaccinationRecord + "]";
	}

}
