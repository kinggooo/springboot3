package com.wangnz.springboot.hello.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileUtil {
    private static Logger log = LoggerFactory.getLogger(FileUtil.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static void appendWithList(String fileName, List<String> rows) {
        BufferedWriter bw = null;
        try {
            FileWriter writer = new FileWriter(fileName, true);
            bw = new BufferedWriter(writer);
            for (String row : rows) {
                bw.write(row);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void backupExistsFile(String dataFile) {
        String dateStr = sdf.format(new Date());

        File file = new File(dataFile);
        if (file.exists()) {
            log.info("文件{}存在，备份文件。", dataFile);
            file.renameTo(new File(dataFile + ".bak." + dateStr));
        }
    }
}
