csharp
cmd.CommandText = string.Format("SELECT * FROM {0} WHERE col = @col;", tableName);
cmd.Parameters.AddWithValue("@col", "your_value_here");