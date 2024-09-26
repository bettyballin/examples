
   Route::get('/video/{filename}', 'VideoController@show')->middleware('auth');
   
