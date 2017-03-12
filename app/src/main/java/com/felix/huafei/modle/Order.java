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

    private float element1Price;
    private float element2Price;
    private float element3Price;
    private float element4Price;
    private float element5Price;
    private float element6Price;
    private float element7Price;

    private float element1Weight;
    private float element2Weight;
    private float element3Weight;
    private float element4Weight;
    private float element5Weight;
    private float element6Weight;
    private float element7Weight;

    private float element1Volume;
    private float element2Volume;
    private float element3Volume;
    private float element4Volume;
    private float element5Volume;
    private float element6Volume;
    private float element7Volume;

    private float element1PriceSubtotal;
    private float element2PriceSubtotal;
    private float element3PriceSubtotal;
    private float element4PriceSubtotal;
    private float element5PriceSubtotal;
    private float element6PriceSubtotal;
    private float element7PriceSubtotal;


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

    public float getElement1Price()
    {
        return element1Price;
    }

    public void setElement1Price(float element1Price)
    {
        this.element1Price = element1Price;
    }

    public float getElement2Price()
    {
        return element2Price;
    }

    public void setElement2Price(float element2Price)
    {
        this.element2Price = element2Price;
    }

    public float getElement3Price()
    {
        return element3Price;
    }

    public void setElement3Price(float element3Price)
    {
        this.element3Price = element3Price;
    }

    public float getElement4Price()
    {
        return element4Price;
    }

    public void setElement4Price(float element4Price)
    {
        this.element4Price = element4Price;
    }

    public float getElement5Price()
    {
        return element5Price;
    }

    public void setElement5Price(float element5Price)
    {
        this.element5Price = element5Price;
    }

    public float getElement6Price()
    {
        return element6Price;
    }

    public void setElement6Price(float element6Price)
    {
        this.element6Price = element6Price;
    }

    public float getElement7Price()
    {
        return element7Price;
    }

    public void setElement7Price(float element7Price)
    {
        this.element7Price = element7Price;
    }

    public float getElement1Weight()
    {
        return element1Weight;
    }

    public void setElement1Weight(float element1Weight)
    {
        this.element1Weight = element1Weight;
    }

    public float getElement2Weight()
    {
        return element2Weight;
    }

    public void setElement2Weight(float element2Weight)
    {
        this.element2Weight = element2Weight;
    }

    public float getElement3Weight()
    {
        return element3Weight;
    }

    public void setElement3Weight(float element3Weight)
    {
        this.element3Weight = element3Weight;
    }

    public float getElement4Weight()
    {
        return element4Weight;
    }

    public void setElement4Weight(float element4Weight)
    {
        this.element4Weight = element4Weight;
    }

    public float getElement5Weight()
    {
        return element5Weight;
    }

    public void setElement5Weight(float element5Weight)
    {
        this.element5Weight = element5Weight;
    }

    public float getElement6Weight()
    {
        return element6Weight;
    }

    public void setElement6Weight(float element6Weight)
    {
        this.element6Weight = element6Weight;
    }

    public float getElement7Weight()
    {
        return element7Weight;
    }

    public void setElement7Weight(float element7Weight)
    {
        this.element7Weight = element7Weight;
    }

    public float getElement1PriceSubtotal()
    {
        return element1PriceSubtotal;
    }

    public void setElement1PriceSubtotal(float element1PriceSubtotal)
    {
        this.element1PriceSubtotal = element1PriceSubtotal;
    }

    public float getElement2PriceSubtotal()
    {
        return element2PriceSubtotal;
    }

    public void setElement2PriceSubtotal(float element2PriceSubtotal)
    {
        this.element2PriceSubtotal = element2PriceSubtotal;
    }

    public float getElement3PriceSubtotal()
    {
        return element3PriceSubtotal;
    }

    public void setElement3PriceSubtotal(float element3PriceSubtotal)
    {
        this.element3PriceSubtotal = element3PriceSubtotal;
    }

    public float getElement4PriceSubtotal()
    {
        return element4PriceSubtotal;
    }

    public void setElement4PriceSubtotal(float element4PriceSubtotal)
    {
        this.element4PriceSubtotal = element4PriceSubtotal;
    }

    public float getElement5PriceSubtotal()
    {
        return element5PriceSubtotal;
    }

    public void setElement5PriceSubtotal(float element5PriceSubtotal)
    {
        this.element5PriceSubtotal = element5PriceSubtotal;
    }

    public float getElement6PriceSubtotal()
    {
        return element6PriceSubtotal;
    }

    public void setElement6PriceSubtotal(float element6PriceSubtotal)
    {
        this.element6PriceSubtotal = element6PriceSubtotal;
    }

    public float getElement7PriceSubtotal()
    {
        return element7PriceSubtotal;
    }

    public void setElement7PriceSubtotal(float element7PriceSubtotal)
    {
        this.element7PriceSubtotal = element7PriceSubtotal;
    }

    public float getElement1Volume()
    {
        return element1Volume;
    }

    public void setElement1Volume(float element1Volume)
    {
        this.element1Volume = element1Volume;
    }

    public float getElement2Volume()
    {
        return element2Volume;
    }

    public void setElement2Volume(float element2Volume)
    {
        this.element2Volume = element2Volume;
    }

    public float getElement3Volume()
    {
        return element3Volume;
    }

    public void setElement3Volume(float element3Volume)
    {
        this.element3Volume = element3Volume;
    }

    public float getElement4Volume()
    {
        return element4Volume;
    }

    public void setElement4Volume(float element4Volume)
    {
        this.element4Volume = element4Volume;
    }

    public float getElement5Volume()
    {
        return element5Volume;
    }

    public void setElement5Volume(float element5Volume)
    {
        this.element5Volume = element5Volume;
    }

    public float getElement6Volume()
    {
        return element6Volume;
    }

    public void setElement6Volume(float element6Volume)
    {
        this.element6Volume = element6Volume;
    }

    public float getElement7Volume()
    {
        return element7Volume;
    }

    public void setElement7Volume(float element7Volume)
    {
        this.element7Volume = element7Volume;
    }
}
