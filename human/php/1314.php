<?php

class Uri
{
    private $scheme;
    private $username;
    private $host;
    private $port;
    private $path;
    private $queryString;
    private $fragment;

    public function __construct($uri)
    {
        $parts = parse_url($uri);
        $this->scheme = $parts['scheme'];
        $this->username = $parts['user'];
        $this->host = $parts['host'];
        $this->port = $parts['port'];
        $this->path = $parts['path'];
        $this->queryString = $parts['query'];
        $this->fragment = $parts['fragment'];
    }

    public function __toString()
    {
        return $this->scheme . '://' .
               ($this->username ? $this->username . '@' : '') .
               $this->host .
               ($this->port ? ':' . $this->port : '') .
               $this->path .
               ($this->queryString ? '?' . $this->queryString : '') .
               ($this->fragment ? '#' . $this->fragment : '');
    }
}

$uri = 'Scheme://foo@host:port/pathes/querystringKey=val#fragment';
echo (new Uri($uri))->__toString();

?>