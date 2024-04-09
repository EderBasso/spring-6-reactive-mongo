package com.fantasmagorica.spring6reactivemongo.config;

import com.mongodb.*;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

import static java.util.Collections.singletonList;

@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    private final String CONNECTION_STRING = "mongodb+srv://edersdz:EEkespdGHX6dWOg9@cloudtestcluster0.8iflimm.mongodb.net/?retryWrites=true&w=majority&appName=CloudTestCluster0";

    @Override
    protected String getDatabaseName() {
        return "sample_mflix";
    }

    @Override
    public MongoClient reactiveMongoClient(){
        return MongoClients.create(settings);
    }

    ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(CONNECTION_STRING))
            .serverApi(serverApi)
            .build();

    /*@Bean
    public MongoClient mongoClient(){
        return MongoClients.create();
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.credential(MongoCredential.createCredential("edersdz", "admin", "EEkespdGHX6dWOg9".toCharArray()))
                .applyToClusterSettings(settings -> {
                    settings.hosts((singletonList(
                            new ServerAddress("cloudtestcluster0.8iflimm.mongodb.net")
                    )));
                });

        super.configureClientSettings(builder);
    }*/
}
