package com.example.match;

import org.json.JSONException;
import org.json.JSONObject;

public class Match {
	private String competition;
	private int year;
	private String round;
	private String teamOne;
	private String teamTwo;
	private int teamOneGoals;
	private int teamTwoGoals;

	public Match() {
	}

	public Match(JSONObject object) throws JSONException {
		this.competition = object.getString("competition");
		this.year = object.getInt("year");
		this.round = object.getString("round");
		this.teamOne = object.getString("team1");
		this.teamTwo = object.getString("team2");
		this.teamOneGoals = object.getInt("team1goals");
		this.teamTwoGoals = object.getInt("team2goals");
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}

	public int getTeamOneGoals() {
		return teamOneGoals;
	}

	public void setTeamOneGoals(int teamOneGoals) {
		this.teamOneGoals = teamOneGoals;
	}

	public int getTeamTwoGoals() {
		return teamTwoGoals;
	}

	public void setTeamTwoGoals(int teamTwoGoals) {
		this.teamTwoGoals = teamTwoGoals;
	}
}
