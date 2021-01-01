package main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces;

import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Country;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Season;

public interface ILeague extends JSONInheritance {
    public int getID();
    public String getName();
    public String getType();
    public String getLogo();
    public Country getCountry();
    public Season[] getSeasons();
}
