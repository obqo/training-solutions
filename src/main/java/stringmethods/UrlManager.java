package stringmethods;

public class UrlManager {

    private String protocol;
    private String host;
    private Integer port;
    private String path;
    private String query;

    public UrlManager(String url) {
        this.protocol = getProtocolFromUrl(url);
        this.host = getHostFromUrl(url);
        this.port = getPortFromUrl(url);
        this.path = getPathFromUrl(url);
        this.query = getQueryFromUrl(url);
    }

    private String getProtocolFromUrl(String url) {
        int index = url.indexOf("://");
        if (index == -1 || url.substring(0, index).isEmpty()) {
            throw new IllegalArgumentException("Invalid url");
        }
        return url.substring(0, index).toLowerCase();
    }

    private String getHostFromUrl(String url) {
        String host;
        int start = url.indexOf("://") + 3;
        int end = url.indexOf(":", start);
        if (end == -1) {
            end = url.indexOf("/", start);
        }
        if (end == -1) {
            host = url.substring(start).toLowerCase();
        }
        else {
            host = url.substring(start, end).toLowerCase();
        }
        if (host.isEmpty()) {
            throw new IllegalArgumentException("Invalid url");
        }
        return host;
    }

    private Integer getPortFromUrl(String url) {
        int start = url.indexOf(":", url.indexOf("://") + 3);
        if (start == -1) {
            return null;
        }
        int end = url.indexOf("/", start);
        if (end == -1) {
            return Integer.valueOf(url.substring(start + 1));
        }
        return Integer.valueOf(url.substring(start + 1, end));
    }

    private String getPathFromUrl(String url) {
        int start = url.indexOf("/", url.indexOf("://") + 3);
        if (start == -1) {
            return "";
        }
        int end = url.indexOf("?");
        if (end == -1) {
            return url.substring(start);
        }
        return url.substring(start, end);
    }

    private String getQueryFromUrl(String url) {
        int start = url.indexOf("?");
        if (start == -1) {
            return "";
        }
        return url.substring(start + 1);
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public boolean hasProperty(String key) {
        validateString(key);
        return query.startsWith(key + "=") || query.contains("&" + key + "=");
    }

    public String getProperty(String key) {
        validateString(key);
        String[] properties = query.split("&");
        for (String str : properties) {
            String[] prop = str.split("=");
            if (prop[0].equals(key)) {
                return prop[1];
            }
        }
        return null;
    }

    private void validateString(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty");
        }
    }
}
