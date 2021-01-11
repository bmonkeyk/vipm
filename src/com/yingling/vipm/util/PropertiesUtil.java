package com.yingling.vipm.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置文件工具
 */
public class PropertiesUtil {
    public static PropertiesUtil instance = null;
    private Map<String, Properties> propertiesMap = new ConcurrentHashMap<>();
    private final static String DEFAULTPROPFILENAME = "vipm.properties";

    public static PropertiesUtil getInstance() {
        if (instance == null) {
            synchronized (PropertiesUtil.class) {
                if (instance == null) {
                    instance = new PropertiesUtil();
                }
            }
        }
        return instance;
    }

    private Properties getProperties(String fileName) {
        Properties props = this.propertiesMap.get(fileName);
        if (props != null) {
            return props;
        } else {
            synchronized (PropertiesUtil.class) {
                File file = new File(System.getProperty("user.home") + "/" + fileName);
                try {
                    if (!file.exists()) {
                        Map<String, String> propMap = new HashMap<>();
                        propMap.put("db.url", "localhost");
                        propMap.put("db.port", "3006");
                        propMap.put("db.user", "root");
                        propMap.put("db.pwd", "root");
                        props = writeProperty(propMap);
                    } else {
                        InputStream is = new FileInputStream(file);
                        props.load(is);
                    }
                } catch (Exception e) {
                    return null;
                }
                this.propertiesMap.put(fileName, props);
                return props;
            }
        }
    }

    public Properties writeProperty(Map<String, String> propMap) {
        Properties props = this.propertiesMap.get(DEFAULTPROPFILENAME);
        File file = new File(System.getProperty("user.home") + "/" + DEFAULTPROPFILENAME);
        boolean newFlag = false ;
        try {
            if (props == null) {
                props = new Properties();
                if (!file.exists()) {
                    file.createNewFile();
                    newFlag = true ;
                }
            } else {
                InputStream is = new FileInputStream(file);
                props.load(is);
            }
            for (String key : propMap.keySet()) {
                props.setProperty(key, propMap.get(key));
            }
            FileOutputStream oFile = new FileOutputStream(file, newFlag);//true表示追加打开
            props.store(oFile, "The New properties file");
            oFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * 获取配置文件键值，不带默认值
     *
     * @param key
     * @return
     */
    public String getPropByKey(String key) {
        return getPropByKeyAndFileName(key, DEFAULTPROPFILENAME);
    }

    /**
     * 获取配置文件键值，指定默认值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public String getPropByKey(String key, String defaultValue) {
        return getPropByKeyAndFileName(key, DEFAULTPROPFILENAME, defaultValue);
    }

    /**
     * 指定配置文件，获取配置文件键值
     *
     * @param key
     * @param fileName
     * @return
     */
    public String getPropByKeyAndFileName(String key, String fileName) {
        return getPropByKeyAndFileName(key, fileName, "");
    }

    /**
     * 指定配置文件，指定默认值，获取配置文件键值
     *
     * @param key
     * @param fileName
     * @return
     */
    public String getPropByKeyAndFileName(String key, String fileName, String defaultValue) {
        Properties pros = getProperties(fileName);
        return pros == null ? defaultValue : pros.getProperty(key, defaultValue);
    }
}
