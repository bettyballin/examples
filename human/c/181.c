#include <linux/module.h>
#include <linux/syscalls.h>
#include <asm/paravirt.h>

void *sys_call_table = NULL;

asmlinkage int (*real_open)(const char __user *filename, int flags, umode_t mode);

asmlinkage int my_open(const char __user *filename, int flags, umode_t mode)
{
    printk(KERN_INFO "my_open called\n");
    return real_open(filename, flags, mode);
}

static int __init my_init(void)
{
    sys_call_table = (void *)kallsyms_lookup_name("sys_call_table");
    real_open = (void *)sys_call_table[__NR_open];
    sys_call_table[__NR_open] = (sys_call_ptr_t)my_open;
    return 0;
}

static void __exit my_exit(void)
{
    sys_call_table[__NR_open] = (sys_call_ptr_t)real_open;
}

module_init(my_init);
module_exit(my_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Your Name");
MODULE_DESCRIPTION("A module to intercept open syscall");