package exceptions.faults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Lines is null");
        }
        List<String> faults = new ArrayList<>();
        for (String line : lines) {
            String[] splits = line.split(",");
            boolean isNumber = true;
            int lineNumber = -1;
            try {
                lineNumber = Integer.parseInt(splits[0]);
            } catch (NumberFormatException nfe) {
                isNumber = false;
            }
            if (isNumber) {
                ProcessingResult result = processLine(splits);
                if (result != ProcessingResult.NO_ERROR) {
                    faults.add(lineNumber + "," + result.getCode());
                }
            }
        }
        return faults;
    }

    private ProcessingResult processLine(String[] splits) {
        if (splits.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }
        if (!isDouble(splits[1]) && !isDate(splits[2])) {
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        } else if (!isDouble(splits[1])) {
            return ProcessingResult.VALUE_ERROR;
        } else if (!isDate(splits[2])) {
            return ProcessingResult.DATE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isDate(String str) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd.");
            df.parse(str);
            return true;
        } catch (ParseException pe) {
            return false;
        }
    }


}
