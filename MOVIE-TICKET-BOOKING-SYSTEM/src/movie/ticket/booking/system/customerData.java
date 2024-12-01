/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.ticket.booking.system;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ASUS
 */
public class customerData {
    
    private Integer id;
    private String type;
    private String title;
    private Integer quantity;
    private double total;
    private Date date;
    private Time time;
    
    public customerData(Integer id, String type, String title, Integer quantity, double total, Date date, Time time){
        
        this.id = id;
        this.type = type;
        this.title = title;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
        this.time = time;
    }
    
    public Integer getId(){
        return id;  
    }
    
    public String getType(){
        return type;  
    }
    
     public String getTitle(){
        return title;  
    }
     
    public Integer getQuantity(){
        return quantity;    
    }
    
    public double getTotal(){
        return total;
    }
    
    public Date getDate(){
        return date;
    }
    
    public Time getTime(){
        return time;
    }
}
