<?php

require __DIR__.'/vendor/autoload.php';

use Illuminate\Support\Facades\Cookie;

class Controller {
    public function index()
    {
        Cookie::queue('my_cookie', 'value', 0, true);

        return view('welcome');
    }
}

$app = new Illuminate\Foundation\Application(
    realpath(__DIR__.'/../')
);

$app->singleton(
    Illuminate\Contracts\Http\Kernel::class,
    App\Http\Kernel::class
);

$kernel = $app->make(Illuminate\Contracts\Http\Kernel::class);

$response = $kernel->handle(
    $request = Illuminate\Http\Request::capture()
);

$kernel->terminate($request, $response);

$controller = new Controller();
$controller->index();