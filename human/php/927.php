This is not PHP code, it appears to be a YAML configuration file for a Symfony application. 

However, if you want to use this configuration in a PHP script, you would need to use a YAML parser to parse the YAML data into a PHP array, and then use that array to configure your application.

Here is an example of how you might do this using the Symfony Yaml component:

use Symfony\Component\Yaml\Yaml;

$config = Yaml::parseFile('security.yml');

// Do something with the config array...
print_r($config);

Assuming the YAML file is named `security.yml` and is located in the same directory as the PHP script. 

Please note that the above code is just an example, you need to adjust it to your needs and also make sure you have the Symfony Yaml component installed and configured properly. 

Also, the provided YAML file seems to be a Symfony security configuration file, it's not meant to be used as a standalone PHP script, but rather as a configuration file for a Symfony application.