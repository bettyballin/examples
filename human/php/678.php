**index.php**

<?php
require_once '../classes/autoload.php';
require_once '../includes/config.php';

use App\Router;
use App\Request;

$router = new Router(new Request);

$router->get('/', function () {
    return view('home');
});

$router->get('/{module}/{controller}/{action}', function ($module, $controller, $action) {
    $modulePath = "../modules/$module/$controller.php";
    if (file_exists($modulePath)) {
        require_once $modulePath;
        $controllerClass = ucfirst($controller);
        $controllerInstance = new $controllerClass();
        $controllerInstance->$action();
    } else {
        return view('404');
    }
});

$router->run();


**classes/autoload.php**

<?php
spl_autoload_register(function ($class) {
    $class = str_replace('\\', '/', $class);
    $class = strtolower($class);
    $file = '../classes/' . $class . '.php';
    if (file_exists($file)) {
        require_once $file;
    }
});


**classes/Router.php**

<?php
namespace App;

class Router
{
    private $request;

    public function __construct(Request $request)
    {
        $this->request = $request;
    }

    public function get($route, $callback)
    {
        if ($this->request->method() == 'GET' && $this->request->path() == $route) {
            return $callback();
        }
    }

    public function run()
    {
        // run the router
    }
}


**classes/Request.php**

<?php
namespace App;

class Request
{
    public function method()
    {
        return $_SERVER['REQUEST_METHOD'];
    }

    public function path()
    {
        return $_SERVER['REQUEST_URI'];
    }
}


**includes/config.php**

<?php
define('SITE_URL', 'http://localhost/public');
define('SITE_NAME', 'My Site');


**views/home.php**

<?php
// home view
?>

<h1>Welcome to <?= SITE_NAME ?></h1>


**views/404.php**

<?php
// 404 view
?>

<h1>404 - Page Not Found</h1>