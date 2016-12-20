package com.ss.test;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GoogleGeocodingApplication implements CommandLineRunner {
	private static final String GEOCODE_LATLAG_URL = "http://maps.googleapis.com/maps/api/geocode/xml?sensor=false";

	public static void main(String[] args) {
		SpringApplication.run(GoogleGeocodingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String place = "&address=Kharadi";
		RestTemplate restTemplate = new RestTemplate();
		Response response = restTemplate.getForObject(GEOCODE_LATLAG_URL + place, Response.class);
		printLatLang(response.get());
	}

	@SuppressWarnings("unchecked")
	void printLatLang(Map<String, Object> resp) {
		for (Entry<String, Object> entry : resp.entrySet()) {
			if (entry.getValue() instanceof Map) {
				printLatLang((Map<String, Object>) entry.getValue());
			}
			if (entry.getKey().equalsIgnoreCase("location")) {
				System.out.println(entry.getValue());
				break;
			}
		}
	}

}
