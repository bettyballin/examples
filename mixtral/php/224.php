protected $routeMiddleware = [
  // ...
];

protected $middlewareGroups = [
   'web' => [
       \App\Http\Middleware\CsrfForAllRequests::class,
        // other middleware...
   ]
]