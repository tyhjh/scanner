package com.dhht.library;

import android.graphics.Bitmap;

/**
 * @author HanPei
 * @date 2019/4/3  上午11:03
 */
public interface IScanner {
    /**
     * 获取二维码
     *
     * @param filePath
     * @return
     */
    String getCodeMsg(String filePath);

    /**
     * 获取二维码
     *
     * @param bitmap
     * @return
     */
    String getCodeMsg(Bitmap bitmap);
}
