package com.etk.data;

public class AttributeCandidate {
	private String uri;
	private String label;
	
	public AttributeCandidate(String uri, String label){
		this.uri = uri;
		
		if( label.contains("@") ){
			this.label = label.substring(0, label.lastIndexOf('@') );
		}
		else{
			this.label = label;
		}
	}
	
	public AttributeCandidate(String uri){
		this.uri = uri;
		this.label = labelFromURI(uri);
		
	}

	private String labelFromURI(String uri){
		String labelParts[] = uri.substring(uri.lastIndexOf('/') + 1).split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
		StringBuilder out = new StringBuilder();
		
		for( String one : labelParts ){
			out.append(one);
			out.append(" ");
		}
		
		return out.toString().substring(0, out.length()).trim();
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
