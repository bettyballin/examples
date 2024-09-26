
app.factory('authInterceptor', function($q, $location) {
    return {
        responseError: function(response) {
            if (response.status === 403) {
                $location.path('/forbidden');
            }
            return $q.reject(response);
        }
    };
});

