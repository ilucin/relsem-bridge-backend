package com.etk.manager.schema;

import com.etk.manager.schema.mappings.EntityMapping;

/**this one should keep mappings between attrbutes and rdf predicates
 * Created by mladen on 11/9/13.
 */
public class Attribute {
    private String uri;
    private String name;
    private Type type;
    private boolean notnull;
    private String defaultVal;
    private int length;



    public void setNotnull(boolean notnull) {
        this.notnull = notnull;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public boolean isNotnull() {
        return notnull;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {

        return length;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static class Builder {

        private Attribute instance;

        public Builder() {
            this.instance = new Attribute();
        }
        public Builder setNotNull(boolean notNull) {
            this.instance.setNotnull(notNull);
            return this;
        }
        public Builder setDefaultValue(String defaultValue) {
            this.instance.setDefaultVal(defaultValue);
            return this;
        }
        public Builder setName(String name) {
            this.instance.setName(name);
            return this;
        }
        public Builder setUri(String uri) {
            this.instance.setUri(uri);
            return this;
        }
        public Builder setLength(int length) {
            this.instance.setLength(length);
            return this;
        }
        public Builder setType(String type) {
           // Type.
           type = type.toLowerCase();
           Type domainType = null;
           if(type.equals("int")) {
               domainType = Type.INT;
           } else if (type.equals("real")) {
               domainType = Type.REAL;
           } else if (type.equals("string")) {
               domainType = Type.STRING;
           } else {
               throw new IllegalArgumentException("unknown type: "+type);
           }
           this.instance.setType(domainType);
           return this;
        }
        public Attribute build() {
            if(this.instance.getName() == null || this.instance.getType() ==null || this.instance.getUri() == null)
                throw new IllegalStateException("Attribute not fully built!");
            return this.instance;

        }
    }
    
    @Override
    public String toString() {
    	return "[ attr " + name + "]";
    }
    
}

