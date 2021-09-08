package com.example.nodoapp.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nodoapp.data.NoDoDao;
import com.example.nodoapp.data.NoDoRoomDatabase;
import com.example.nodoapp.model.NoDo;

import java.util.List;

public class NoDoRepository {

    private NoDoDao noDoDao;
    private LiveData<List<NoDo>> allNoDos;

    public NoDoRepository(Application application) {
        // Here we can get data from remote API and put it on different list
        NoDoRoomDatabase db = NoDoRoomDatabase.getDatabase(application);
        noDoDao = db.noDoDao();
        allNoDos = noDoDao.getAllNoDos();
    }
    public LiveData<List<NoDo>> getAllNoDos(){
        return allNoDos;
    }
    public void insert(NoDo noDo){
        new insertAsyncTask(noDoDao).execute(noDo);
    }

    private class insertAsyncTask extends AsyncTask<NoDo, Void, Void> {
        private NoDoDao asyncTaskDao;
        public insertAsyncTask(NoDoDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(NoDo... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
