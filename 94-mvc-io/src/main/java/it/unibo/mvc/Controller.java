package it.unibo.mvc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public interface Controller {
    void setNextString(String nextString);

    String getNextString();

    List<String> getHistory();

    void getCurrentString();

}
