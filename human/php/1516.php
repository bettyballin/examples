<?php

declare(strict_types=1);

namespace App\Models;

use Laravel\Passport\Client;

class PassportClient extends Client
{
    /**
     * Determine if the client should skip the authorization prompt.
     *
     * @return bool
     */
    public function skipsAuthorization()
    {
        return $this->name === 'spa-client';
    }
}