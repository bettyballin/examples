
   $app['user_provider'] = function ($app) {
       return new Adh\Security\UserProvider($app['db']);
   };
   
