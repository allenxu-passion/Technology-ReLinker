package com.yixia.liblink;

import java.io.File;
import android.content.Context;

public class YZBLinker {

    /**
     * TODO ALLEN
     * 1)库更新
     */

    private YZBLinker() {}

    public static void loadLibrary(final Context context, final String library) {
        loadLibrary(context, library, null);
    }

    public static void loadLibrary(final Context context,
                                   final String library,
                                   final YZBLinker.LoadListener listener) {
        new YZBLinkerInstance().loadLibrary(context, library, listener);
    }

    public interface LoadListener {
        void success();
        void failure(Throwable t);
    }

    public interface DownloadListener {
        void success();
        void failure(Throwable t);
    }

    public interface LinkerLoader {
        void loadLibrary(String name);
        void loadPath(String path);
        String mapLibraryName(String libraryName);
        String[] supportedAbis();
    }

    public interface LinkerDownloader {
        void downloadLibrary(Context context, String[] abis, String mappedLibraryName, File destination, DownloadListener listener);
    }

}
