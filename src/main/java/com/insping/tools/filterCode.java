package com.insping.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用于处理,temp_zh_CN.lua为基准,扫描客户端和服务器所有的文件,用以判断当前code是否被使用.
 *
 * @Author: houshanping
 * @Date: 2020/03/20 11:19
 */
public class filterCode {

    public static List<String> ignoreFileName = new ArrayList<>(Arrays.asList(
            "temp_es",
            "temp_ar",
            "temp_de",
            "temp_en",
            "temp_fr",
            "temp_id",
            "temp_it",
            "temp_jp",
            "temp_kr",
            "temp_pe",
            "temp_pt",
            "temp_ru",
            "temp_tr",
            "temp_vn",
            "temp_zh_CN",
            "temp_zh_FN"
    ));
    public static final String CLIENT_WIN32_PATH = "E:\\workspace\\client\\win32_gok_new_cc\\src";
    public static final String SERVER_PATH = "E:\\workspace\\server\\src\\com\\hireal\\slg";
    public static final String SERVER_INGAME_PATH = "E:\\workspace\\server\\WEB-INF\\config\\ingame_8000";

    public static final String BASE_PATH = "E:\\workspace\\client\\win32_gok_new_cc\\src\\config\\temp_zh_CN.lua";

    public static List<String> invalidCode = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        File file = new File(BASE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String uidStr;
        int index = 1;
        while ((uidStr = bufferedReader.readLine()) != null) {
            String code = splitCode(uidStr);
            if (code == null) continue;
            System.out.println(index++ + ",处理code:" + code);
            boolean isInvalid = isInvalid(code);
            if (isInvalid) {
                invalidCode.add(code);
//                System.out.println("无效");
            } else {
//                System.out.println("有效");
            }
        }
        System.out.println("扫描结束,打印结果:");
        invalidCode.forEach(a -> System.out.println(a));
    }

    private static String splitCode(String line) {
        String[] strs = line.split("]=\"");
        if (strs.length < 2 || strs[0].length() < 1) {
            return null;
        }
        return strs[0].substring(1);
    }

    private static boolean isInvalid(String code) throws Exception {
        boolean isInvalid = true;
        if (fileContainCode(CLIENT_WIN32_PATH, code)) {
            isInvalid = false;
        }
        if (isInvalid && fileContainCode(SERVER_PATH, code)) {
            isInvalid = false;
        }
        if (isInvalid && fileContainCode(SERVER_INGAME_PATH, code)) {
            isInvalid = false;
        }

        return isInvalid;

    }

    private static boolean fileContainCode(String path, String code) throws Exception {
        boolean isContain = false;
        File rootFile = new File(path);
        if (rootFile.isDirectory()) {
            // 文件夹的话向下递归
            for (File file : rootFile.listFiles()) {
                isContain = fileContainCode(file.getPath(), code);
                if (isContain)
                    break;
            }
        } else {
            // 过滤掉一部分文件
            if (isIgnoreFile(path)) {
                return isContain;
            }
            // 判断是否在
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rootFile));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                if (lineStr.contains(code)) {
                    isContain = true;
                    System.out.println(rootFile.getName() + "用到:" + code);
                    break;
                }
            }
        }
        return isContain;
    }


    private static boolean isIgnoreFile(String path) {
        for (String ignoreFile : ignoreFileName) {
            if (path.contains(ignoreFile)) {
                return true;
            }
        }
        return false;
    }
}
