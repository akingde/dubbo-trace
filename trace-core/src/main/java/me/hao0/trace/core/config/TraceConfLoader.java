package me.hao0.trace.core.config;

import me.hao0.trace.core.util.Yamls;

import java.io.InputStream;

/**
 * Author: haolin
 * Email:  haolin.h0@gmail.com
 */
public class TraceConfLoader {

    private TraceConfLoader(){}

    public static TraceConf load(String fileName){
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        TraceConf conf = Yamls.load(in, TraceConf.class);
        formatServer(conf);
        return conf;
    }

    private static void formatServer(TraceConf conf) {
        String server = conf.getServer();
        if (!server.startsWith("http://") &&
                !server.startsWith("https://")){
            conf.setServer("http://" + conf.getServer());
        }
    }
}
