package com.jack.mc.cyg.retrofittestproject.callback;

/**
 *
 */
public interface FileDownloadCallback {
    void onSuccess();   //下载成功返回

    void onProcess(long fileSizeDownloaded, long fileSize);   //下载进度

    void onFailure();   //网络请求失败
}
