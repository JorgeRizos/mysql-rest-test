package com.mysqlresttest.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysqlresttest.dto.RequestDto;
import com.mysqlresttest.entity.Team;

@RestController
@RequestMapping(path = "/import-league")
public class ImportLeagueController {
	
	private static final String URL_COMPETITIONS = "https://api.football-data.org/v2/competitions/";
	private static final String TEAMS = "/teams";
	private static final String URL_PLAYERS = "https://api.football-data.org/v2/teams/";
	private static final String AUTH_HEADER_NAME = "X-Auth-Token";
	private static final String AUTH_TOKEN = "e642d4c6411c4ab4b55bda9bf9b00a5f";

	@GetMapping(path = "/{leagueCode}")
	public void getLeagueInfo(@PathVariable("leagueCode") String leagueCode) throws IOException {
		RequestDto competition = getCompetition(leagueCode);
		System.out.println(competition.getCompetition().getCompetitionName());
		Set<Team> teams = competition.getTeams();
		for (Team team : teams) {
			getTeamPlayers(team);
		}
	}

	private RequestDto getCompetition(String leagueCode) throws IOException {
		URL url = new URL(URL_COMPETITIONS + leagueCode + TEAMS);
		URLConnection connection = url.openConnection();
		connection.setRequestProperty(AUTH_HEADER_NAME, AUTH_TOKEN);
		InputStream inputStream = connection.getInputStream();
		String encoding = connection.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(inputStream, encoding);
		Gson gson = new GsonBuilder().create();
		System.out.println(body);
		return gson.fromJson(body, RequestDto.class);
	}

	private void getTeamPlayers(Team team) throws IOException {
		URL url = new URL(URL_PLAYERS + team.getTeamId() );
		URLConnection connection = url.openConnection();
		connection.setRequestProperty(AUTH_HEADER_NAME, AUTH_TOKEN);
		InputStream inputStream = connection.getInputStream();
		String encoding = connection.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(inputStream, encoding);
		Gson gson = new GsonBuilder().create();
		System.out.println(body);
	}				
}
