package com.etk.data;

import java.util.HashMap;
import java.util.Map;

public class ValueCandidate {
	private String subject;
	private Map<String, String> values;
	
	public ValueCandidate(String subject, Map<String, String> values) {
		this.subject = subject;
		this.values = values;
	}
	
	public ValueCandidate(String subject){
		this(subject, new HashMap<String, String>());
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void addOneValue(String value, String attribute){
		values.put(attribute, value);
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}	
	
}
