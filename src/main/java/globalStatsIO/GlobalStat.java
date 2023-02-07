package globalStatsIO;

import java.util.HashMap;
import java.util.List;

import io.github.fvarrui.globalstats.GlobalStats;
import io.github.fvarrui.globalstats.model.Rank;
import io.github.fvarrui.globalstats.model.Stats;

public class GlobalStat {

	String clientId="nL8l9XT08r7gzzsaPC3f2Dhyu1pjqOWOA4aJ23Ja", clientSecret="Rq4qTegwhwyUN6pPvJfkF3UJeEMinWMenRFg5WMn";
	GlobalStats client;
	Stats stats;

	public GlobalStat() throws Exception {
		client = new GlobalStats(clientId, clientSecret);
		String token = client.getAccessToken();
		System.out.println(token);
	}

	@SuppressWarnings("serial")
	public void User() throws Exception {
		stats = client.createStats("username", new HashMap<String, Object>() {{
			
			put("highscore", 100);
			
		}});
		System.out.println(stats);
	}

	@SuppressWarnings("serial")
	public void updateUser() throws Exception {
		Stats stats = client.updateStats("63d8f9d59f5e8817248b4577", 
				new HashMap<String, Object>() {{
					
				put("highscore", "+20");
				
			}});
		System.out.println(stats);
	}

	public void GetLeaderBorad() throws Exception {
		List<Rank> leader=  client.getLeaderboard("highscore", 3);
		System.out.println(leader);
	}

}
