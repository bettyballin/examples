public void checkAccess(ThreadGroup g) {
        System.out.println("Access for " + g);
        super.checkAccess(g);
    }

    @Override
    public void checkAccess(Thread t) {
        System.out.println("Access for " + t);
        super.checkAccess(t);
    }
}