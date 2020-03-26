# Azure Key Vault hello world

## Update the config

Update the `application.properties` file with the required values

- **azure.keyvault.uri:** your-keyvault-endpoint
- **azure.keyvault.client-id:** your-client-id
- **azure.keyvault.client-key:** your-client-secret

For example:

```properties
azure.keyvault.uri=https://gs-hello-world.vault.azure.net/
azure.keyvault.client-id=1a2b3c4d-123e-4567f-bb94-f27d8ecf0dee
azure.keyvault.client-key=zxyv987-123t-987r-9897-61c93034865b
```

## Run the application

Start the application

```bash
$ ./gradlew bootRun
```

Visit the endpoint to show the secret
```
$ curl localhost:8080
This is the secret lastname polo
```

## Build docker image

Build the docker image. The name of the image is in the `build.gradle` file. This will both build and push the image.

```bash
./gradlew jib
```

You can always pass a different image name like:

```bash
./gradlew jib --image=quay.io/giantswarm/azure-vault-demo
```
