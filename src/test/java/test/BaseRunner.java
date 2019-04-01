package test;

import app.Application;
import org.junit.After;
import org.junit.Before;


/**
 * Created by blk
 */
public class BaseRunner {

    public static final ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @Before
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }
        app = new Application();
        tlApp.set(app);
    }

    @After
    public void tearDown() {
        app.quit();
    }
}
