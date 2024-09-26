This is not PHP code, it appears to be a configuration snippet for a dependency manager like Composer. However, I'll provide the equivalent Composer configuration:

json
{
    "repositories": [
        {
            "type": "git",
            "url": "git://github.com/FriendsOfSymfony/FOSUserBundle.git"
        }
    ],
    "require": {
        "friendsofsymfony/user-bundle": "1.0.0"
    },
    "config": {
        "bin-dir": "bin",
        "vendor-dir": "/bundles"
    },
    "extra": {
        "symfony-app-dir": "app"
    }
}


If you need to install it via PHP, you can use the following code:


use Composer\Console\Application;
use Symfony\Component\Console\Input\ArrayInput;

require 'vendor/autoload.php';

$input = new ArrayInput(array(
    'command' => 'require',
    'packages' => array('friendsofsymfony/user-bundle:1.0.0'),
    '--repository' => 'git://github.com/FriendsOfSymfony/FOSUserBundle.git',
    '--working-dir' => getcwd(),
));

$application = new Application();
$application->setAutoExit(false);
$application->run($input);