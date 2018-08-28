package config;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Configuration {
    private static Configuration instance=new Configuration();
    private ResourceBundle page;
    private ResourceBundle error;
    private Locale locale;

    public Configuration() {
        locale=Locale.getDefault();
        page=ResourceBundle.getBundle("pages",locale);
        error=ResourceBundle.getBundle("errors",locale);
    }

    public static Configuration getInstance(){return instance;}

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    public String getPage(String key){
      return   (String)page.getObject(key);
    }
    public String getErrorMessage(String key) {
        String message;
        try {
            message = new String(error.getObject(key).toString().getBytes("iso-8859-1"), "windows-1251");
        } catch (UnsupportedEncodingException uex) {
            return error.getObject(key).toString();
        }
        return message;
    }

    public Locale getLocale() {
        return locale;
    }
}
