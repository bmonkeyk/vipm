package com.yingling.vipm.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * �����ļ�����
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
            FileOutputStream oFile = new FileOutputStream(file, newFlag);//true��ʾ׷�Ӵ�
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
     * ��ȡ�����ļ���ֵ������Ĭ��ֵ
     *
     * @param key
     * @return
     */
    public String getPropByKey(String key) {
        return getPropByKeyAndFileName(key, DEFAULTPROPFILENAME);
    }

    /**
     * ��ȡ�����ļ���ֵ��ָ��Ĭ��ֵ
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public String getPropByKey(String key, String defaultValue) {
        return getPropByKeyAndFileName(key, DEFAULTPROPFILENAME, defaultValue);
    }

    /**
     * ָ�������ļ�����ȡ�����ļ���ֵ
     *
     * @param key
     * @param fileName
     * @return
     */
    public String getPropByKeyAndFileName(String key, String fileName) {
        return getPropByKeyAndFileName(key, fileName, "");
    }

    /**
     * ָ�������ļ���ָ��Ĭ��ֵ����ȡ�����ļ���ֵ
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
