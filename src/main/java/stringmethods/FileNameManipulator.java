package stringmethods;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        }
        return str.trim().charAt(str.trim().length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        if (fileName.trim().indexOf('.') < 1 || fileName.trim().indexOf('.') == fileName.trim().length() - 1) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        return fileName.trim().substring(fileName.trim().indexOf('.'));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (fileName.trim().indexOf('.') < 1 || fileName.trim().indexOf('.') == fileName.trim().length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.lastIndexOf(ext) == fileName.length() - ext.length();
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (fileName.trim().indexOf('.') < 1 || fileName.trim().indexOf('.') == fileName.trim().length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.replace(findFileExtension(fileName), findFileExtension(fileName).toLowerCase());
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        return fileName.replace(present, target);
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
