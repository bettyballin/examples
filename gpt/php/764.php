
// In your routes file
Route::model('user', 'App\User');
Route::get('app/user/{user}/edit', ['middleware' => 'auth', 'uses' => 'UserController@edit']);

