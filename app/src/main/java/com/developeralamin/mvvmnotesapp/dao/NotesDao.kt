package com.developeralamin.mvvmnotesapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.developeralamin.mvvmnotesapp.model.Notes

@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes():LiveData<List<Notes>>

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun inserNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id:Int)

    @Update
    fun updateNotes(notes: Notes)
}