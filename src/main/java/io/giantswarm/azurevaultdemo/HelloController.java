package io.giantswarm.azurevaultdemo;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final SecretClient secretClient;

    @Autowired
    public HelloController(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    @RequestMapping("/")
    public String index() {
        KeyVaultSecret secret = secretClient.getSecret("marco");
        return "This is the secret lastname: '" + secret.getValue() + "'\n";
    }

}
