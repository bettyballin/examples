SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
GO

BEGIN TRANSACTION

--select * from A
-- update B ....
--update A

WAITFOR DELAY '00:00:02'   -- tables remain locked for 2 secs   hh:mm:ss

COMMIT TRANSACTION
GO