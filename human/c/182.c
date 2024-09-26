#include <linux/module.h>
#include <linux/syscalls.h>
#include <asm/paravirt.h>

MODULE_LICENSE("GPL");

// Assuming you want to hijack the open syscall
asmlinkage int (*original_open)(const char __user *, int, umode_t);

asmlinkage int hijacked_open(const char __user *filename, int flags, umode_t mode)
{
    printk(KERN_INFO "Open syscall hijacked!\n");
    return original_open(filename, flags, mode);
}

static unsigned long read_cr0(void)
{
    unsigned long val;
    asm volatile("mov %%cr0, %0\n\t" : "=r" (val));
    return val;
}

static void write_cr0(unsigned long val)
{
    asm volatile("mov %0, %%cr0\n\t" : : "r" (val));
}

static int __init init(void)
{
    // Save the original syscall
    original_open = (void *)sys_call_table[__NR_open];

    // Temporarily disable write protection
    write_cr0(read_cr0() & (~0x10000));

    // Overwrite the syscall table entry
    sys_call_table[__NR_open] = (unsigned long)hijacked_open;

    // Re-enable write protection
    write_cr0(read_cr0() | 0x10000);

    return 0;
}

static void __exit exit(void)
{
    // Restore the original syscall
    write_cr0(read_cr0() & (~0x10000));
    sys_call_table[__NR_open] = (unsigned long)original_open;
    write_cr0(read_cr0() | 0x10000);
}

module_init(init);
module_exit(exit);