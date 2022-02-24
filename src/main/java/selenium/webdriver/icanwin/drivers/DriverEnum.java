package selenium.webdriver.icanwin.drivers;

public enum DriverEnum {
    CHROME("Chrome"),
    FIREFOX("Firefox");

    private final String browser;

    DriverEnum(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
