package com.ss.test;

import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "GeocodeResponse")
public class Response {
	private Map<String, Object> geocodeResponse = new TreeMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> get() {
		return geocodeResponse;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		geocodeResponse.put(name, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [map=").append(geocodeResponse).append("]");
		return builder.toString();
	}

}
