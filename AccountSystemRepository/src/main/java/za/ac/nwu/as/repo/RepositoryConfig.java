package za.ac.nwu.as.repo;

import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.as.repo.persistence")
@EntityScam("za.ac.nwu.as.domain.persistence")//Scans outdated entities
@PropertySource( value = "classpath: application-db.properties")
public class RepositoryConfig {
}
