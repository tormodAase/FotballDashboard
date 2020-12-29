package com.tormodaase.footballAPI.objects.interfaces;

import com.tormodaase.footballAPI.objects.Coverage;

public interface ISeason extends JSONInheritance{
    public int getYear();
    public String getStart();
    public String getEnd();
    public boolean getCurrent();
    public Coverage getCoverage();
}
