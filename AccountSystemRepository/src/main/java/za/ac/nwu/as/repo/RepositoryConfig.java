package za.ac.nwu.as.repo;

import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.as.repo.persistence")
@EntityScam("za.ac.nwu.as.domain.persistence")
@PropertySource( value = "classpath: application-db.properties")
public class RepositoryConfig {
}
