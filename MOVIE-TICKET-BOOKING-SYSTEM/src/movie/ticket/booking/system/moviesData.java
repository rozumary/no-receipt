/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.ticket.booking.system;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class moviesData {
    
    private String title;
    private String genre;
    private String duration;
    private String image;
    private Date date;
    private String current;
    
    public moviesData(String title, String genre, String duration, String image, Date date, String current){
        
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.image = image;
        this.date = date;
        this.current = current;
        
    }

    public String getTitle(){
        return title;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public String getDuration(){
        return duration;
        
    }
    
    public String getImage(){
        return image;
    }
    
    public Date getDate(){
        return date;
    }    
    
    public String getCurrent(){
        return current;
    }
}
