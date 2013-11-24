package com.etk.data;

import java.util.ArrayList;
import java.util.List;

public class ValueCandidate {
	private String subject;
	private List<String> values;
	
	public ValueCandidate(String subject, List<String> values) {
		this.subject = subject;
		this.values = values;
	}
	
	public ValueCandidate(String subject){
		this(subject, new ArrayList<String>());
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public void addOneValue(String value){
		values.add(value);
	}	
	
}
