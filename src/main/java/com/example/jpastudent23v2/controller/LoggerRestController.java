package com.example.jpastudent23v2.controller;


import ch.qos.logback.classic.Level;
import com.example.jpastudent23v2.JpaStudent23V2Application;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerRestController {

    @GetMapping("info")
    public String setInfoLevel() {
        boolean b = JpaStudent23V2Application.logger.isDebugEnabled();
        String res = "Start debug enabled=" + b;
        // Set the logging level programmatically
        ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger) JpaStudent23V2Application.logger;
        logbackLogger.setLevel(Level.INFO);
        b = JpaStudent23V2Application.logger.isDebugEnabled();
        return res + " after debug enabled =" + b;
    }

    @GetMapping("debug")
    public String setDebugLevel() {
        boolean b = JpaStudent23V2Application.logger.isDebugEnabled();
        String res = "Start debug enabled=" + b;
        // Set the logging level programmatically
        ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger) JpaStudent23V2Application.logger;
        logbackLogger.setLevel(Level.DEBUG);
        b = JpaStudent23V2Application.logger.isDebugEnabled();
        return res + " after debug enabled =" + b;
    }

    @GetMapping("trace")
    public String setTraceLevel() {
        boolean b = JpaStudent23V2Application.logger.isTraceEnabled();
        String res = "Start trace enabled=" + b;
        JpaStudent23V2Application.logger.trace("FØR nu tracer jeg en string");
        // Set the logging level programmatically
        ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger) JpaStudent23V2Application.logger;
        logbackLogger.setLevel(Level.TRACE);
        b = JpaStudent23V2Application.logger.isTraceEnabled();
        JpaStudent23V2Application.logger.trace("EFTER nu tracer jeg en string");
        return res + " after trace enabled =" + b;
    }

}
