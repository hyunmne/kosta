package service;

import java.util.List;
import java.util.Scanner;

import dao.BaseballDAO;
import dto.Player;
import dto.Team;

public class BaseballService {
	Scanner sc = new Scanner(System.in);
	public void start() {
		System.out.println("[야구 관리 프로그램]");
		System.out.println("1.팀");
		System.out.println("2.선수");
		System.out.println("0.종료");
		System.out.print("선택 >> ");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel) {
		case 1: teamMenu(); break;
		case 2: playerMenu(); break;
		case 0: System.exit(0);
		}
	}
	
	public void teamMenu() {
		System.out.println("[팀 메뉴]");
		System.out.println("1.팀 목록 조회");
		System.out.println("2.팀 조회");
		System.out.println("3.팀 등록");
		System.out.print("선택 >> ");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel) {
		case 1: getTeamList(); break;
		case 2: getTeam(); break;
		case 3: regTeam(); break;
		}
	}
	
	public void getTeamList() {
		System.out.println("[팀 목록 조회]");
		List<Team> teamList = BaseballDAO.selectTeamList();
		for (Team team : teamList) {
			System.out.println(team);
		}
	}
	
	public void getTeam() {
		System.out.println("[팀 조회]");
		System.out.print("팀명 : ");
		String name = sc.nextLine();
		Team team = BaseballDAO.selectTeam(name);
		System.out.println(team);
	}
	
	public void regTeam() {
		System.out.println("[팀 등록]");
		System.out.print("팀명 : ");
		String name = sc.nextLine();
		System.out.print("연고지 : ");
		String loc = sc.nextLine();
		
		Team team = new Team(name, loc); // 객체 생성
		boolean success = BaseballDAO.insertTeam(team);
		if (success) {
			System.out.println("<"+team.getName()+"> 팀이 추가 되었습니다.\n");
		}
	}
	
	public void playerMenu() {
		System.out.println("[선수 메뉴]");
		System.out.println("1.선수 목록 조회");
		System.out.println("2.선수 조회");
		System.out.println("3.선수 등록");
		System.out.print("선택 >> ");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel) {
		case 1: getPlayerList(); break;
		case 2: getPlayer(); break;
		case 3: regPlayer(); break;
		}
	}
	
	public void getPlayerList() {
		System.out.println("[선수 목록 조회]");
		List<Player> playerList = BaseballDAO.selectPlayerList();
		for (Player player : playerList) {
			System.out.println(player);
		}
	}
	
	public void getPlayer() {
		System.out.println("[선수 조회]");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		List<Player> playerList = BaseballDAO.selectPlayer(name);
		for (Player player : playerList) {
			System.out.println(player);
		}
	}
	
	public void regPlayer() {
		System.out.println("[선수 등록]");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("등번호 : ");
		int backnum = Integer.parseInt(sc.nextLine());
		System.out.print("팀명 : ");
		String teamName = sc.nextLine();
		Team team = BaseballDAO.selectTeam(teamName); 
		if (team == null) {
			System.out.println("등록되지 않은 팀입니다.");
			return;
		}
		Player player = new Player(name, backnum, team.getNum());
		boolean success = BaseballDAO.insertPlayer(player);
		if (success) {
			System.out.println("<"+player.getName()+"> 선수가 등록 되었습니다.\n");
		}
	}
}
