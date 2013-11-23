package com.etk.data;

public class EntityCandidate {
	private String uri;
	private String label;
	
	public EntityCandidate(String uri, String label){
		this.uri = uri;
		this.label = label;
	}
	
	public EntityCandidate(String uri){
		this.uri = uri;
		this.label = uri.substring(uri.lastIndexOf('/') + 1);
		
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
