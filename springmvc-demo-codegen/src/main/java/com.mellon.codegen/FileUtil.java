package com.mellon.codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {
    /**
     * 删除某个文件夹下的所有文件夹和文件
     *
     * @param delpath String
     * @return boolean
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static boolean deletefile(String delpath) throws Exception {
        try {

            File file = new File(delpath);
            // 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
            if (!file.isDirectory()) {
                file.delete();
                System.out.println(file.getAbsolutePath() + "删除成功");
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    deletefile(delpath + "\\" + filelist[i]);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("deletefile() Exception:" + e.getMessage());
        }
        return true;
    }

    // 递归删除指定路径下的所有文件
    public static void deleteAll(File file) {
        if (file.isFile() || file.list().length == 0) {
            file.delete();
            System.out.println(file.getAbsolutePath() + "删除成功");
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteAll(f);// 递归删除每一个文件
                f.delete();// 删除该文件夹
            }
        }
    }
}
