<?php
ini_set('session.cookie_lifetime', 3600); // Cookie expires after one hour.
ini_set('session.gc_maxlifetime', 1800); // Session data gets deleted by garbage collection if inactive for half-hour.
?>