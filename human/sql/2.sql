DECLARE @xml xml = '<languages><language id="en-US">English</language><language id="fr-FR">French</language></languages>';
DECLARE @languageCode nvarchar(10) = 'en-US';

SELECT @xml.value('(/languages/language[@id=sql:variable("@languageCode")])[1]', 'nvarchar(50)');