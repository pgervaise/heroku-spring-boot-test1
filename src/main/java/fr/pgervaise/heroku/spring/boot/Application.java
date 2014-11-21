package fr.pgervaise.heroku.spring.boot;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import fr.pgervaise.heroku.spring.boot.config.Constants;

/**
 * 
 * @author pgervaise
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    private final Logger log = LoggerFactory.getLogger(Application.class);

    @Inject
    private Environment env;

    /**
     * Initializes jhipster.
     * <p/>
     * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
     * <p/>
     */
    @PostConstruct
    public void initApplication() throws IOException {
        if (env.getActiveProfiles().length == 0) {
            log.warn("Pas de profile Spring configuré, démarrage avec la configuration par défaut");
        } else {
            log.info("D�marrage avec le(s) profile(s) Spring : {}", Arrays.toString(env.getActiveProfiles()));
        }
    }

    /**
     * D�marrage du projet
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        // Vérification si le profil sélectionné a été positionné en tant qu'argument
        // sinon le profil de développement sera ajouté
        addDefaultProfile(app, source);

        app.run(args);
    }
    
    /**
     * Set a default profile if it has not been set
     */
    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }
    }
}
