package com.dhht.library.camera;

import android.graphics.Bitmap;

import com.dhht.library.CaptureActivity;
import com.dhht.library.IScanner;
import com.dhht.library.common.BitmapUtils;
import com.dhht.library.decode.BitmapDecoder;
import com.google.zxing.Result;
import com.google.zxing.client.result.ResultParser;

/**
 * @author HanPei
 * @date 2019/4/3  上午11:04
 */
public class ScannerManager implements IScanner {

    @Override
    public String getCodeMsg(String photoPath) {
        Bitmap img = BitmapUtils.getCompressedBitmap(photoPath);
        BitmapDecoder decoder = new BitmapDecoder();
        Result result = decoder.getRawResult(img);
        return ResultParser.parseResult(result).toString();
    }

    @Override
    public String getCodeMsg(Bitmap bitmap) {
        BitmapDecoder decoder = new BitmapDecoder();
        Result result = decoder.getRawResult(bitmap);
        return ResultParser.parseResult(result).toString();
    }

}
