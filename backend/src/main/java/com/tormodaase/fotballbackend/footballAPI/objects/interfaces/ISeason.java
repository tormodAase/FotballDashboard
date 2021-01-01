package main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces;

import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Coverage;

public interface ISeason extends JSONInheritance{
    public int getYear();
    public String getStart();
    public String getEnd();
    public boolean getCurrent();
    public Coverage getCoverage();
}
