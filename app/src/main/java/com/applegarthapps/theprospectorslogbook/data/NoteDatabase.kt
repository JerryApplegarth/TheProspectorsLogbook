package com.applegarthapps.theprospectorslogbook.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.applegarthapps.theprospectorslogbook.data.model.Note
import com.applegarthapps.theprospectorslogbook.presentation.utils.DateConverter
import com.applegarthapps.theprospectorslogbook.presentation.utils.UUIDConverter

@Database(entities = [Note::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDatabaseDao

}