package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.model.Vaccine;

public class ImmunizationRecord {
	
	private List<Vaccine> immunizationRecord = new ArrayList<>();
	
	public List<Vaccine> getImmunizationRecord() {
		return immunizationRecord;
	}

	public void setImmunizationRecord(List<Vaccine> immunizationRecord) {
		this.immunizationRecord = immunizationRecord;
	}
	
	

	
}