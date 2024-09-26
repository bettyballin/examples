Route::get('/v1/user/{id}', 'Api\V1\UserController@show')
     ->middleware('check-user-authorization');