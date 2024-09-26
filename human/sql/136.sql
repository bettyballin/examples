SELECT 
  r.riskscore AS "Risk Score",
  a.host_name AS "Asset Hostname", 
  a.ip_address AS "Asset IP", 
  a.description AS "OS",
  summary AS "Summary",
  fix AS "Fix"
FROM 
  risks AS r
JOIN 
  assets AS a USING (asset_id)
GROUP BY 
  r.riskscore, 
  a.host_name, 
  a.ip_address, 
  asset_id, 
  summary, 
  fix;