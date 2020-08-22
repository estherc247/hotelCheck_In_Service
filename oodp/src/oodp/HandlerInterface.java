package oodp;

import java.util.ArrayList;

public interface HandlerInterface {
    public <T> ArrayList<T> readSerializedObject(String filename);
    public <T> void writeSerializedObject(String filename, ArrayList<T> list);
}
