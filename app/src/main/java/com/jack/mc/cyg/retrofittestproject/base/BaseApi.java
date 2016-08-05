package com.jack.mc.cyg.retrofittestproject.base;

import android.os.AsyncTask;

import com.jack.mc.cyg.retrofittestproject.callback.FileDownloadCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * BaseApi
 * Created by tsy on 16/7/21.
 */
public abstract class BaseApi {

    protected abstract String getUri();

    protected Retrofit mRetrofit;

    public BaseApi() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(getUri())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 下载文件
     *
     * @param fileUrl  下载url
     * @param filePath 本地保存path
     * @param callback FileDownloadCallback回调
     */
    public void downloadFile(final String fileUrl, final String filePath, final FileDownloadCallback callback) {
        final ApiStore apiStore = mRetrofit.create(ApiStore.class);
        new AsyncTask<Void, Long, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Call<ResponseBody> call = apiStore.downloadFile(fileUrl);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            new AsyncTask<Void, Void, Void>() {

                                private boolean mWrittenToDisk;

                                @Override
                                protected Void doInBackground(Void... voids) {
                                    mWrittenToDisk = writeResponseBodyToDisk(response.body(), filePath, callback);
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(Void aVoid) {
                                    if (mWrittenToDisk) {
                                        callback.onSuccess();
                                    } else {
                                        callback.onFailure();
                                    }
                                }
                            }.execute();


                        } else {
                            callback.onFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        callback.onFailure();
                    }
                });
                return null;
            }
        }.execute();
    }

    /**
     * responsebody写入文件
     *
     * @param body
     * @param filePath
     * @param callback
     * @return
     */
    private boolean writeResponseBodyToDisk(ResponseBody body, String filePath, FileDownloadCallback callback) {
        try {
            File file = new File(filePath);

            String dir = filePath.substring(0, filePath.lastIndexOf('/'));
            File fileDir = new File(dir);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(file);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    callback.onProcess(fileSizeDownloaded, fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                file.delete();
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    public interface ApiStore {
        @Streaming
        @GET
        Call<ResponseBody> downloadFile(@Url String fileUrl);
    }
}