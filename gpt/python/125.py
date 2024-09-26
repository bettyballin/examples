
import logging

logger = logging.getLogger(__name__)

def printView(request, x):
    logger.debug(x)  # Use logger.info, logger.warning, etc., as appropriate
