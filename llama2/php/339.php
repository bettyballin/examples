use Azure\KeyVault\KeyVault;

class AzureKeyVaultService
{
    private $keyVault;

    public function __construct(KeyVault $keyVault)
    {
        $this->keyVault = $keyVault;
    }

    public function getDatabaseCredentials()
    {
        $vaultSecret = $this->keyVault->getSecret('https://yourvaultname.vault.azure.net/secrets/yoursecretname');

        return [
            'username' => $vaultSecret->value['username'],
            'password' => $vaultSecret->value['password']
        ];
    }
}

,keyVault = new KeyVault();
$azureKeyVaultService = new AzureKeyVaultService($keyVault);
$databaseCredentials = $azureKeyVaultService->getDatabaseCredentials();
print_r($databaseCredentials);