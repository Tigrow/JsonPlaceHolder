package iceblood.jsonplaceholder;

import android.os.AsyncTask;


public class DownloadAsyncListener extends AsyncTask<String, Object, Object> {

    public static interface DownloadListener {
        public void onFinish(Object object);
    }

    public DownloadListener downloadListener;

    /*public DownloadAsyncListener(DownloadListener listener) // Мне нужно, чтобы класс мог реализовывать интерфейс,
    {
        downloadListener = listener;
    }*/

    public void setDownloadListener(DownloadListener listener) // а мог и не реализовывать.
    {
        downloadListener = listener;
    }

    @Override
    protected void onCancelled(Object result)
    {
        super.onCancelled(result);
    }

    @Override
    protected void onCancelled()
    {
        super.onCancelled();
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(String... params)
    {
        return params;
    }

    @Override
    protected void onProgressUpdate(Object... progress)
    {
        super.onProgressUpdate(progress);
    }

    @Override
    protected void onPostExecute(Object result)
    {
        super.onPostExecute(result);
        if (downloadListener != null)
        {
            downloadListener.onFinish(result);
        }
    }
}
