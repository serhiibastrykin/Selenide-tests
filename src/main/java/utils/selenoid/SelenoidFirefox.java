package utils.selenoid;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static utils.SettingsSeleniumEasy.DOWNLOAD_DIR;
import static utils.SettingsSeleniumEasy.selenoid_URL;

public class SelenoidFirefox implements WebDriverProvider {

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("pdfjs.disabled", true);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", DOWNLOAD_DIR);
        profile.setPreference("browser.download.useDownloadDir", DOWNLOAD_DIR);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv/xls/xlsx/json/pdf");
        profile.setPreference("browser.helperApps.neverAsk.openFile", "text/csv/xls/xlsx/json/pdf");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("security.mixed_content.block_active_content", false);
        profile.setPreference("security.mixed_content.block_display_content", false);
        return new FirefoxOptions().setProfile(profile);
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {
        DesiredCapabilities browser = DesiredCapabilities.firefox();
        browser.setBrowserName("firefox");
        browser.setVersion("83");
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableVideo", true);
        browser.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());

        try {
            return new RemoteWebDriver(
                    new URL(selenoid_URL),
                    browser
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}