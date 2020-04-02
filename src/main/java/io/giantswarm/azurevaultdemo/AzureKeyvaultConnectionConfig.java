package io.giantswarm.azurevaultdemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("df.azure.keyvault")
@Data
public class AzureKeyvaultConnectionConfig {
    private String url;
    private String clientId;
    private String clientSecret;
    private String tenantId;
}
