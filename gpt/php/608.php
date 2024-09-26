
require 'vendor/autoload.php';

use Aws\Ec2\Ec2Client;

$ec2Client = new Ec2Client([
    'region' => 'your-region',
    'version' => 'latest',
    'credentials' => [
        'key' => 'your-aws-access-key-id',
        'secret' => 'your-aws-secret-access-key',
    ],
]);

//
