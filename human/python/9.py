import pexpect
import time

def change_password(user, password):
    passwd = pexpect.spawn("/usr/bin/passwd %s" % user)

    for _ in range(2):
        # wait for password: to come out of passwd's stdout
        passwd.expect("password: ")
        # send password to passwd's stdin
        passwd.sendline(password)
        time.sleep(0.1)

change_password('foo', 'bar') # changes user "foo"'s password to "bar"