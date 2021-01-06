package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private int[] number = new int[90];

    public LottoReader(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(";");
                for (int i = 11; i < 16; i++) {
                    this.number[Integer.parseInt(temp[i]) - 1] += 1;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file");
        }
    }

    public int getNumber(int i) {
        return number[i - 1];
    }
}
