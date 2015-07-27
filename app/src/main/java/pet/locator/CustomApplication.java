package pet.locator;

import android.app.Application;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;

/**
 * Created by NSSektor on 7/21/15.
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        AirshipConfigOptions options = new AirshipConfigOptions();
        options.developmentAppKey = "y_n2r2QtRqC1X0hWnV-YHA";
        options.developmentAppSecret = "XkiltE6GQjWY_mJ-sHciNg";
        options.productionAppKey = "mYdxqid2ScW926u7APcO6Q";
        options.productionAppSecret = "w9nAdOdvS2WjFkbZLnYcVQ";
        options.inProduction = false;

        UAirship.takeOff(this, options);

        String channelId = UAirship.shared().getPushManager().getChannelId();
        Logger.info("My Application Channel ID: " + channelId);

        UAirship.shared().getPushManager().setUserNotificationsEnabled(true);
    }
}
