package za.ac.nwu.as.logic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.as.translater.config.TranslatorConfig;

@Import({TranslaterConfig.class})
@Configuration

public class LogicConfig {
}
