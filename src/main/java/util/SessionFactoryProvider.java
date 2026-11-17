
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This file provides a SessionFactory for use with DAOs using Hibernate
 *
 * @author paulawaite
 * @version 3.0
 */
public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    /**
     * Create session factory.
     */
    public static void createSessionFactory() {

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().configure();

        String host = System.getenv("RDS_HOSTNAME");

        if (host != null && !host.isEmpty()) {

            // AWS Elastic Beanstalk database
            String port = System.getenv("RDS_PORT");
            String database = System.getenv("RDS_DB_NAME");
            String username = System.getenv("RDS_USERNAME");
            String password = System.getenv("RDS_PASSWORD");

            String url = "jdbc:mysql://" + host + ":" + port + "/"
                    + database + "?serverTimezone=America/Chicago";

            builder.applySetting("hibernate.connection.driver_class",
                            "com.mysql.cj.jdbc.Driver")
                    .applySetting("hibernate.connection.url", url)
                    .applySetting("hibernate.connection.username", username)
                    .applySetting("hibernate.connection.password", password);

        } else {

            // Local development database
            Properties databaseProperties = new Properties();

            try (InputStream inputStream = SessionFactoryProvider.class
                    .getClassLoader()
                    .getResourceAsStream("database.properties")) {

                if (inputStream == null) {
                    throw new IllegalStateException(
                            "database.properties could not be found on the classpath");
                }

                databaseProperties.load(inputStream);

            } catch (IOException exception) {
                throw new IllegalStateException(
                        "Unable to load database.properties", exception);
            }

            builder.applySetting("hibernate.connection.driver_class",
                            databaseProperties.getProperty("driver"))
                    .applySetting("hibernate.connection.url",
                            databaseProperties.getProperty("url"))
                    .applySetting("hibernate.connection.username",
                            databaseProperties.getProperty("username"))
                    .applySetting("hibernate.connection.password",
                            databaseProperties.getProperty("password"));
        }

        // Create registry
        registry = builder.build();

        // Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);

        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();

        // Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;
    }
}
