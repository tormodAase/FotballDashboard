package com.tormodaase.footballAPI.objects.interfaces;

import com.tormodaase.footballAPI.objects.Country;
import com.tormodaase.footballAPI.objects.Season;

public interface ILeague extends JSONInheritance {
    public int getID();
    public String getName();
    public String getType();
    public String getLogo();
    public Country getCountry();
    public Season[] getSeasons();
}
