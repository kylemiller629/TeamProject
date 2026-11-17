
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 * Configures the REST application and registers
 * the controller package for API endpoints.
 *
 * @author Katie Schmidt
 */
@ApplicationPath("/api")
public class RestApplication extends ResourceConfig {

    /**
     * Initializes the REST application and scans
     * the controller package for resources.
     */
    public RestApplication() {
        packages("controller");
    }
}