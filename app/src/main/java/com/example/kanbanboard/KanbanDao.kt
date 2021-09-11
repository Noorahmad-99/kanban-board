package com.example.kanbanboard

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface KanbanDao {
    @Insert
    fun insert(kanban : KanbanBoard?) : Completable

    @Delete
    fun delet(kanban : KanbanBoard?) : Completable


    @Update
    fun update(kanban : KanbanBoard?) : Completable


    @Query("SELECT * FROM KANBAN_BOARD ORDER BY id DESC  ")
    fun getAll() : Observable<List<KanbanBoard>?>
}