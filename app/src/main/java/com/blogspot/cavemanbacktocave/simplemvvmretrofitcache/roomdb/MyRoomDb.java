package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.roomdb;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyResponseDao;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyResponseModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MyResponseModel.class}, version = 1)
public abstract class MyRoomDb extends RoomDatabase {
    /**
     * References https://developer.android.com/codelabs/android-room-with-a-view#0
     * */
    public abstract MyResponseDao getMyResponseDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile MyRoomDb INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MyRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyRoomDb.class, "my_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onCreate method to populate the database.
     * For this sample, we clear the database every time it is created.
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
              /*  WordDao dao = INSTANCE.wordDao();
                dao.deleteAll();
                Word word = new Word("Hello");
                dao.insert(word);
                word = new Word("World");
                dao.insert(word);*/
            });
        }
    };
}