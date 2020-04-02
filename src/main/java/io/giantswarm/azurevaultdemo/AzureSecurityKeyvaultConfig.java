package io.giantswarm.azurevaultdemo;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.keys.KeyClient;
import com.azure.security.keyvault.keys.KeyClientBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AzureSecurityKeyvaultConfig {
    Logger logger = LoggerFactory.getLogger(AzureSecurityKeyvaultConfig.class);
    private final AzureKeyvaultConnectionConfig azureKeyvaultConnectionConfig;

    @Bean
    public ClientSecretCredential clientSecretCredential() {
        return new ClientSecretCredentialBuilder()
                .clientId(azureKeyvaultConnectionConfig.getClientId())
                .clientSecret(azureKeyvaultConnectionConfig.getClientSecret())
                .tenantId(azureKeyvaultConnectionConfig.getTenantId())
                .build();
    }

    @Bean
    public KeyClient keyClient() {
        return new KeyClientBuilder()
                .vaultUrl(azureKeyvaultConnectionConfig.getUrl())
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

    @Bean
    public SecretClient secretClient(ClientSecretCredential clientSecretCredential) {
        logger.debug("This is the tenant ID: " + azureKeyvaultConnectionConfig.getTenantId() + "\n");
        return new SecretClientBuilder()
                .vaultUrl(azureKeyvaultConnectionConfig.getUrl())
                .credential(clientSecretCredential)
                .buildClient();
    }
}
