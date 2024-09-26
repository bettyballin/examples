package com.kerb4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kerby.kerberos.kerb.client.KrbConfig;
import org.apache.kerby.kerberos.kerb.server.SimpleKdcServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

public class KerberosSecurityTestcase {

    private static final Log log = LogFactory.getLog(KerberosSecurityTestcase.class);
    private static int i = 10000;
    protected int kdcPort;
    private SimpleKdcServer kdc;
    private File workDir;
    private KrbConfig conf;

    @BeforeAll
    public static void debugKerberos() {
        System.setProperty("sun.security.krb5.debug", "true");
    }

    @BeforeEach
    public void startMiniKdc() throws Exception {

        kdcPort = i++;

        createTestDir();
        createMiniKdcConf();

        log.info("Starting Simple KDC server on port " + kdcPort);

        kdc = new SimpleKdcServer(workDir, conf);
        kdc.setKdcPort(kdcPort);
        kdc.setAllowUdp(false);
        kdc.init();
        kdc.start();
    }

    @AfterEach
    public void stopMiniKdc() throws Exception {
        log.info("Stopping Simple KDC server on port " + kdcPort);
        if (kdc != null) {
            kdc.stop();
            log.info("Stopped Simple KDC server on port " + kdcPort);
        }
    }

    public void createTestDir() {
        workDir = new File(System.getProperty("test.dir", "target"));
    }

    public void createMiniKdcConf() {
        conf = new KrbConfig();
    }

    public SimpleKdcServer getKdc() {
        return kdc;
    }

    public File getWorkDir() {
        return workDir;
    }

    public KrbConfig getConf() {
        return conf;
    }

}