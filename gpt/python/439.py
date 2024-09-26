
   # You need to install pysqlcipher3 for this
   from pysqlcipher3 import dbapi2 as sqlite
   
   con = sqlite.connect('encrypted.db')
   con.execute("PRAGMA key = 'your-password-here'")
   con.execute("CREATE TABLE test (id integer primary key, name text)")
   con.close()
   
