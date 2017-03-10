package com.felix.huafei.modle;

import java.io.Serializable;

/**
 * Created by felix on 2017/3/8.
 */

public class Order implements Serializable
{
    private int    id;
    private String orderId;
    private int    consumerId;
    private String consumerName;
    private double money;
    private int    paymentStatus;
    private String orderStatus;
    private String remarks;
    private String orderTime;

    private String plantingArea;
    private String plantingCrops;

    private String growthStage;

    private float nitrogenousPrice;
    private float phosphorusPrice;
    private float kaliumPrice;

    private float nitrogenousWeight;
    private float phosphorusWeight;
    private float kaliumWeight;

    private float nitrogenousPriceSubtotal;
    private float phosphorusPriceSubtotal;
    private float kaliumPriceSubtotal;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public int getConsumerId()
    {
        return consumerId;
    }

    public void setConsumerId(int consumerId)
    {
        this.consumerId = consumerId;
    }

    public String getConsumerName()
    {
        return consumerName;
    }

    public void setConsumerName(String consumerName)
    {
        this.consumerName = consumerName;
    }

    public double getMoney()
    {
        return money;
    }

    public void setMoney(double money)
    {
        this.money = money;
    }

    public int getPaymentStatus()
    {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus)
    {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getOrderTime()
    {
        return orderTime;
    }

    public void setOrderTime(String orderTime)
    {
        this.orderTime = orderTime;
    }

    public String getPlantingArea()
    {
        return plantingArea;
    }

    public void setPlantingArea(String plantingArea)
    {
        this.plantingArea = plantingArea;
    }

    public String getPlantingCrops()
    {
        return plantingCrops;
    }

    public void setPlantingCrops(String plantingCrops)
    {
        this.plantingCrops = plantingCrops;
    }

    public String getGrowthStage()
    {
        return growthStage;
    }

    public void setGrowthStage(String growthStage)
    {
        this.growthStage = growthStage;
    }

    public float getNitrogenousPrice()
    {
        return nitrogenousPrice;
    }

    public void setNitrogenousPrice(float nitrogenousPrice)
    {
        this.nitrogenousPrice = nitrogenousPrice;
    }

    public float getPhosphorusPrice()
    {
        return phosphorusPrice;
    }

    public void setPhosphorusPrice(float phosphorusPrice)
    {
        this.phosphorusPrice = phosphorusPrice;
    }

    public float getKaliumPrice()
    {
        return kaliumPrice;
    }

    public void setKaliumPrice(float kaliumPrice)
    {
        this.kaliumPrice = kaliumPrice;
    }

    public float getNitrogenousWeight()
    {
        return nitrogenousWeight;
    }

    public void setNitrogenousWeight(float nitrogenousWeight)
    {
        this.nitrogenousWeight = nitrogenousWeight;
    }

    public float getPhosphorusWeight()
    {
        return phosphorusWeight;
    }

    public void setPhosphorusWeight(float phosphorusWeight)
    {
        this.phosphorusWeight = phosphorusWeight;
    }

    public float getKaliumWeight()
    {
        return kaliumWeight;
    }

    public void setKaliumWeight(float kaliumWeight)
    {
        this.kaliumWeight = kaliumWeight;
    }

    public float getNitrogenousPriceSubtotal()
    {
        return nitrogenousPriceSubtotal;
    }

    public void setNitrogenousPriceSubtotal(float nitrogenousPriceSubtotal)
    {
        this.nitrogenousPriceSubtotal = nitrogenousPriceSubtotal;
    }

    public float getPhosphorusPriceSubtotal()
    {
        return phosphorusPriceSubtotal;
    }

    public void setPhosphorusPriceSubtotal(float phosphorusPriceSubtotal)
    {
        this.phosphorusPriceSubtotal = phosphorusPriceSubtotal;
    }

    public float getKaliumPriceSubtotal()
    {
        return kaliumPriceSubtotal;
    }

    public void setKaliumPriceSubtotal(float kaliumPriceSubtotal)
    {
        this.kaliumPriceSubtotal = kaliumPriceSubtotal;
    }
}
