package com.tormodaase.footballAPI.objects.interfaces;

public interface IVenue extends JSONInheritance{
    public int getID();
    public String getName();
    public String getAddress();
    public String getCity();
    public int getCapacity();
    public String getSurface();
    public String getImage();
}
