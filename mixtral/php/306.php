<?php

// routes/web.php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Redirect;

Route::post('/custom-logout', function () {
    Auth::logout();

    return Redirect::to('home');
})->name('logout.custom');

?>

<!-- In your view (e.g. resources/views/welcome.blade.php) -->

<a href="{{ route('logout.custom') }}" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">Log out</a>

<form id="logout-form" action="{{ route('logout.custom') }}" method="POST" style="display: none;">
    @csrf
</form>