package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream os, List<String> shoppingList) {
        try (PrintStream printStream = new PrintStream(new BufferedOutputStream(os))) {
            for (String shopping : shoppingList) {
                printStream.println(shopping);
            }
        }
    }

    public List<String> loadShoppingList(InputStream is) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }
}
