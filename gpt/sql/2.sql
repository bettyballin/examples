
   CREATE VIEW dbo.SupportViewWithNoLock
   AS
   SELECT *
   FROM dbo.YourTable WITH (NOLOCK)
   
