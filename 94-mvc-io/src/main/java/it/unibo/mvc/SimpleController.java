package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString;
    private List<String> history = new ArrayList<>();


    @Override
    public void setNextString(String nextString) {
        if(nextString==null){
            throw new IllegalArgumentException("The string is null");

        }

        this.nextString=nextString;    
    }

    @Override
    public String getNextString() {
        return nextString;
        
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public void getCurrentString() {
        if(nextString==null){
            throw new IllegalArgumentException("String null");

        }
        System.out.println(nextString);
        history.add(nextString); 
        
    }

}
