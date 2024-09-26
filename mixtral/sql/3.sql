SELECT COUNT(*) 
FROM blocked_ips 
WHERE ip = ? 
AND NOW() <= TIMESTAMPADD(MINUTE, 10, blocktime);