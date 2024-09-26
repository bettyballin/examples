<?php

class RateLimiter {
  private $requestCounts = [];

  public function isRateLimited($ip, $userAgent) {
    // Simple implementation, you may want to use a database or cache for production
    return false;
  }

  public function getRequestCount($ip, $userAgent, $timeWindow) {
    $key = $this->getKey($ip, $userAgent, $timeWindow);
    return $this->requestCounts[$key] ?? 0;
  }

  public function incrementRequestCount($ip, $userAgent, $timeWindow) {
    $key = $this->getKey($ip, $userAgent, $timeWindow);
    $this->requestCounts[$key] = ($this->requestCounts[$key] ?? 0) + 1;
  }

  private function getKey($ip, $userAgent, $timeWindow) {
    return $ip . '_' . $userAgent . '_' . $timeWindow;
  }
}

$rateLimiter = new RateLimiter();

function rateLimit($ip, $userAgent, $limit, $timeWindow) {
  global $rateLimiter;
  // Check if the IP or user agent is already rate-limited
  if ($rateLimiter->isRateLimited($ip, $userAgent)) {
    return true;
  }

  // Calculate the number of requests allowed in the time window
  $requestsAllowed = floor($timeWindow / $limit);

  // Check if the request exceeds the limit
  if ($rateLimiter->getRequestCount($ip, $userAgent, $timeWindow) >= $requestsAllowed) {
    return true;
  }

  // Increment the request count and return false
  $rateLimiter->incrementRequestCount($ip, $userAgent, $timeWindow);
  return false;
}

// Example usage:
$limit = 5; // limit
$timeWindow = 60; // time window in seconds
$ip = '192.168.1.1';
$userAgent = 'Mozilla/5.0';

if (rateLimit($ip, $userAgent, $limit, $timeWindow)) {
  echo 'Rate limit exceeded';
} else {
  echo 'Request allowed';
}