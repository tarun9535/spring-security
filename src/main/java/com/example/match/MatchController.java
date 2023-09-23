package com.example.match;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/matches")
public class MatchController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	private final String url = "https://jsonmock.hackerrank.com/api/football_matches?page=1&year=";


	@GetMapping(value = "/draw/{year}")
	public List<Match> list(@PathVariable int year) throws JSONException {
		JSONObject response = new JSONObject(restTemplate.getForEntity(url + year, String.class).getBody());
		JSONArray data = response.getJSONArray("data");
		List<Match> matches = new ArrayList<>() {
		};
		for (int i = 0; i < data.length(); i++) {
			Match match = new Match(data.getJSONObject(i));
			if (match.getTeamOneGoals() == match.getTeamTwoGoals()) {
				matches.add(match);
			}
		}
		return matches;
	}

	@GetMapping(value = "/load-data")
	public List<Match> loadData() throws JSONException {
		JSONObject response = new JSONObject(restTemplate.getForEntity(url + "2011", String.class).getBody());
		JSONArray data = response.getJSONArray("data");
		List<Match> matches = new ArrayList<>() {
		};
		for (int i = 0; i < data.length(); i++) {
			Match match = new Match(data.getJSONObject(i));
			if (match.getTeamOneGoals() == match.getTeamTwoGoals()) {
				matches.add(match);
			}
		}
		return matches;
	}
}
