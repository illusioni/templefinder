package com.dd.templefinder;

import com.dd.templefinder.repository.TempleRepositoryDummyImpl;
import com.dd.templefinder.repository.TempleRepositoryI;
import com.dd.templefinder.repository.TempleRepositoryJsonImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class TemplefinderConfiguration {

    @Profile({"Test"})
    @Bean
    @Primary
    public TempleRepositoryI testTempleRepository() {
        return new TempleRepositoryDummyImpl();
    }

    @Bean
    @Profile({"Dev"})
    @Primary
    public TempleRepositoryI devTempleRepository() {
        return new TempleRepositoryJsonImpl();
    }

}
