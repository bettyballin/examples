csharp
using System;
using System.Data.SqlClient;

class Program
{
    static void Main(string[] args)
    {
        string connectionString = "Server=(local);Database=TestDB;Integrated Security=True";
        string password = "topsecret";
        string dbPassword = "dbpassword";

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            connection.Open();

            // Backup service master key
            string backupServiceMasterKey = "BACKUP SERVICE MASTER KEY TO FILE = 'C:\\ServiceMasterKey.smk' ENCRYPTION BY PASSWORD = '" + password + "'";
            SqlCommand command = new SqlCommand(backupServiceMasterKey, connection);
            command.ExecuteNonQuery();

            // Create database master key
            string createMasterKey = "CREATE MASTER KEY ENCRYPTION BY PASSWORD = '" + dbPassword + "'";
            command = new SqlCommand(createMasterKey, connection);
            command.ExecuteNonQuery();

            // Create certificate
            string createCertificate = "CREATE CERTIFICATE TestCertificate WITH SUBJECT = 'Test Certificate', EXPIRY_DATE = '01/01/2016'";
            command = new SqlCommand(createCertificate, connection);
            command.ExecuteNonQuery();

            // Create symmetric key
            string createSymmetricKey = "CREATE SYMMETRIC KEY TestKey WITH ALGORITHM = TRIPLE_DES, KEY_SOURCE ='pass_phrase' ENCRYPTION BY CERTIFICATE TestCertificate";
            command = new SqlCommand(createSymmetricKey, connection);
            command.ExecuteNonQuery();

            // Create table
            string createTable = "CREATE TABLE CCInfo (ID int, Plain varchar(16), Encrypted varbinary(128))";
            command = new SqlCommand(createTable, connection);
            command.ExecuteNonQuery();

            // Insert data
            string insertData = "INSERT INTO CCInfo (ID, Plain) VALUES (1, '1234567890ABCDEF'), (2, '1234123412341234'), (3, '1234567890ABCDEF'), (4, '1111111123456789')";
            command = new SqlCommand(insertData, connection);
            command.ExecuteNonQuery();

            // Encrypt data
            string openSymmetricKey = "OPEN SYMMETRIC KEY TestKey DECRYPTION BY CERTIFICATE TestCertificate";
            command = new SqlCommand(openSymmetricKey, connection);
            command.ExecuteNonQuery();

            string encryptData = "UPDATE CCInfo SET Encrypted = EncryptByKey(Key_GUID('TestKey'), Plain)";
            command = new SqlCommand(encryptData, connection);
            command.ExecuteNonQuery();

            string closeSymmetricKey = "CLOSE SYMMETRIC KEY TestKey";
            command = new SqlCommand(closeSymmetricKey, connection);
            command.ExecuteNonQuery();

            // Decrypt data
            openSymmetricKey = "OPEN SYMMETRIC KEY TestKey DECRYPTION BY CERTIFICATE TestCertificate";
            command = new SqlCommand(openSymmetricKey, connection);
            command.ExecuteNonQuery();

            string decryptData = "SELECT ID, Plain, Encrypted, CONVERT(varchar(16), DecryptByKey(Encrypted)) AS Decrypted FROM CCInfo";
            command = new SqlCommand(decryptData, connection);
            SqlDataReader reader = command.ExecuteReader();

            while (reader.Read())
            {
                Console.WriteLine(reader["ID"].ToString() + " " + reader["Plain"].ToString() + " " + reader["Encrypted"].ToString() + " " + reader["Decrypted"].ToString());
            }

            reader.Close();

            closeSymmetricKey = "CLOSE SYMMETRIC KEY TestKey";
            command = new SqlCommand(closeSymmetricKey, connection);
            command.ExecuteNonQuery();
        }
    }
}