package main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces;

public interface ICoverage extends JSONInheritance {
    public boolean getEvents();
    public boolean getLineups();
    public boolean getStatisticsFixtures();
    public boolean getStatisticsPlayers();
    public boolean getStandings();
    public boolean getPlayers();
    public boolean getTopScorers();
    public boolean getPredictions();
    public boolean getOdds();
}
