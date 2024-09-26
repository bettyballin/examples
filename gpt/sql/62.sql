
SELECT
   csv(DISTINCT dv.title) AS "Vulnerability Title",
   assets.host_name AS "Asset Hostname", 
   assets.ip_address AS "Asset IP", 
   assets.description AS "OS",
   round(sum(dv.riskscore)) AS "Asset Risk",
   summary AS "Solution",
   fix as "Fix"
FROM remediations r
   JOIN dim_asset_vulnerability_solution dvs USING (
