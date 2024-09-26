public class Temp1795 {
    public static void main(String[] args) {
        System.out.println("Service saslauthd status:");
        System.out.println("● saslauthd.service - LSB: saslauthd startup script");
        System.out.println("   Loaded: loaded (/etc/init.d/saslauthd)");
        System.out.println("   Active: active (running) since Tue 2016-04-26 12:04:59 BST; 1s ago");
        System.out.println("     Docs: man:systemd-sysv-generator(8)");
        System.out.println("  Process: 11569 ExecStop=/etc/init.d/saslauthd stop (code=exited, status=0/SUCCESS)");
        System.out.println("  Process: 11586 ExecStart=/etc/init.d/saslauthd start (code=exited, status=0/SUCCESS)");
        System.out.println("   Memory: 2.0M");
        System.out.println("   CGroup: /system.slice/saslauthd.service");
        System.out.println("           ├─11606 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5");
        System.out.println("           ├─11607 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5");
        System.out.println("           ├─11608 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5");
        System.out.println("           ├─11609 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5");
        System.out.println("           └─11610 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5");
        System.out.println();
        System.out.println("Apr 26 12:04:59 hectorvp-pc systemd[1]: Starting LSB: saslauthd startup script...");
        System.out.println("Apr 26 12:04:59 hectorvp-pc saslauthd[11586]: * Starting SASL Authentication Daemon saslauthd");
        System.out.println("Apr 26 12:04:59 hectorvp-pc saslauthd[11606]: detach_tty      : master pid is: 11606");
        System.out.println("Apr 26 12:04:59 hectorvp-pc saslauthd[11606]: ipc_init        : listening on socket: /var/run/saslauthd/mux");
        System.out.println("Apr 26 12:04:59 hectorvp-pc systemd[1]: Started LSB: saslauthd startup script.");
        System.out.println("Apr 26 12:04:59 hectorvp-pc saslauthd[11586]: ...done.");
    }
}