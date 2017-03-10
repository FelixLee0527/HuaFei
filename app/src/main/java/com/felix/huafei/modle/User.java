package com.felix.huafei.modle;

import java.io.Serializable;

/**
 * Created by felix on 2017/3/8.
 */

public class User implements Serializable
{
    private int    id;
    private String userName;
    private String password;
    private String email;
    private String cellphoneNumber;
    private String telephoneNumber;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCellphoneNumber()
    {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber)
    {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }
}
