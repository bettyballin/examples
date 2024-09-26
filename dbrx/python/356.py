from pyjail.jailer import Jailer

# Define allowed modules/functions/classes here.
allowlist = {
    "os": ["system"],
    "__builtins__": {"print"}
}

jailer = Jailer(allowlist)
with jailer:
    exec("""
        # Your application code here
        import os
        print("Hello, World!")
        os.system("ls -l")
    """)