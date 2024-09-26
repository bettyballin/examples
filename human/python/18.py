import pexpect

child = pexpect.spawn('sudo')
child.expect('Password:')
child.sendline('password')
child.interact()