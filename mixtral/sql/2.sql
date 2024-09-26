SET @ip = '192.168.1.1';

INSERT IGNORE INTO blocked_ips (ip) VALUES (@ip);
UPDATE blocked_ips SET blocktime = NOW() WHERE ip = @ip;