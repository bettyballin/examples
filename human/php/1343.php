<?php

use Illuminate\Support\Facades\Gate;
use Illuminate\Support\Facades\Auth;

$litter = // define your litter object here

if (Gate::allows('edit-litter', Auth::user(), $litter)) {
    // The user is allowed to edit the litter
} else {
    // The user is not allowed to edit the litter
}