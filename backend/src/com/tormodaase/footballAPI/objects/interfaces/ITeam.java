package com.tormodaase.footballAPI.objects.interfaces;

import com.tormodaase.footballAPI.objects.Venue;

public interface ITeam extends JSONInheritance{
    public int getID();
    public String getName();
    public String getCountry();
    public int getFounded();
    public boolean getNational();
    public String getLogo();
    public Venue getVenue();
}
