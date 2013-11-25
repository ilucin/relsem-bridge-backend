package com.etk.data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class EntityCandidate {
	private String uri;
	private String label;
	
	public EntityCandidate(String uri, String label){
		this.uri = uri;
		if( label.contains("@") ){
			this.label = label.substring(0, label.lastIndexOf('@') );
		}
		else{
			this.label = label;
		}
	}
	
	public EntityCandidate(String uri){
		this.uri = uri;
		this.label = labelFromURI(uri);
		
	}
	
	private String labelFromURI(String uri){
		try {
			return URLDecoder.decode((uri.substring(uri.lastIndexOf('/') + 1)), "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
			//e.printStackTrace();
		}
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
