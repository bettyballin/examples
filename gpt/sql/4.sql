
CREATE TABLE ##example (xmltest xml);

DECLARE @LanguagePath NVARCHAR(75);
SET @LanguagePath = '(/languages/language[@id="en-US"])[1]';

INSERT INTO ##example VALUES ('<languages><language id="en-US">English content</language></languages>');
INSERT INTO ##example VALUES ('<languages><language id="fr-FR">French content</language></languages>');
INSERT INTO ##example VALUES ('<languages><language id="es-ES">Spanish content</language></languages>');

DECLARE @SQL NVARCHAR(MAX);
SET @SQL = N'SELECT * FROM ##example ORDER BY xmltest.value(''' + REPLACE(@LanguagePath, '''', '''''') + ''', ''varchar(max)'')';

EXEC
