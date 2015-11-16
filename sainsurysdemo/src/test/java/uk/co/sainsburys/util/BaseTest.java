package uk.co.sainsburys.util;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;


public class BaseTest {
    @Mock
    private Appender mockAppender;
    @Captor
    private ArgumentCaptor<LoggingEvent> captorLoggingEvent;
    
    public void setup() {
        Logger root = (Logger) Logger.getLogger("log4j.logger.uk.co");
        root.addAppender(mockAppender);
        root.setLevel(Level.INFO);
    }
    
    public void tearDown() {
        mockAppender = null;
        captorLoggingEvent = null;
    }
    
}
