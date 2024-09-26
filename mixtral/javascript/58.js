app.factory('myHttpInterceptor', function ($q) {
    return {
        'responseError': function (rejection) {
            if(rejection.status === 403){
               // Handle the error here e.g redirect to a specific page
              window.location = '/error/forbidden';

             }

           return $q.reject(rejection);
        
        }
    };
});