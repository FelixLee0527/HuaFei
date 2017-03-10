package com.felix.huafei.modle;

import java.io.Serializable;

/**
 * Created by felix on 2017/3/8.
 */

public class Consumer implements Serializable
{
    private int    id;
    private String consumerName;
    private String consumerAccount;
    private String consumerAddress;
    private String cellphoneNumber;
    private String telephoneNumber;
    private String email_address;
    private String qqNumber;
    private String remarks;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getConsumerName()
    {
        return consumerName;
    }

    public void setConsumerName(String consumerName)
    {
        this.consumerName = consumerName;
    }

    public String getConsumerAccount()
    {
        return consumerAccount;
    }

    public void setConsumerAccount(String consumerAccount)
    {
        this.consumerAccount = consumerAccount;
    }

    public String getConsumerAddress()
    {
        return consumerAddress;
    }

    public void setConsumerAddress(String consumerAddress)
    {
        this.consumerAddress = consumerAddress;
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

    public String getEmail_address()
    {
        return email_address;
    }

    public void setEmail_address(String email_address)
    {
        this.email_address = email_address;
    }

    public String getQqNumber()
    {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber)
    {
        this.qqNumber = qqNumber;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}
