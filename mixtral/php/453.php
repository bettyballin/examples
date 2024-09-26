// app/Http/Kernel.php

protected $middlewareGroups = [

   // ...

   'api' => [
        \App\Http\Middleware\CheckUserAuthorization::class,

       // Other middleware...
    
];