package globalStatsIO;

public class GlobalStat {

	GlobalStats client = new GlobalStats(clientId, clientSecret);
	String token = client.getAccessToken();
	System.out.println(token);
	
}
