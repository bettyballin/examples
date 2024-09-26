<?php

use Illuminate\Support\Facades\Auth;

if (Auth::check() && Auth::user()->can('edit-litter', $litter)) {
    // Your code here
    echo "You have permission to edit this litter.";
} else {
    echo "You do not have permission to edit this litter.";
}

?>