<?php

if (isset($user) && $user->last_activity < now()->subMinutes(5)) {
    Auth::logout();
}