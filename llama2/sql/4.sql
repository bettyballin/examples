csharp
string hql = "DECLARE @sortColumn nvarchar(50); SET @sortColumn = @sortColumnParam; SELECT * FROM tbl6 ORDER BY @sortColumn";
var sortColumnParam = new QueryParameter("@sortColumnParam", arguments.sortcolumn, ParameterDbType.NVarChar);
var x = ORM.executeQuery(hql, new[] { sortColumnParam }).EntityToQuery();