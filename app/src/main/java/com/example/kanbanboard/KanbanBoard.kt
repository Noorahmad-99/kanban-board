package com.example.kanbanboard


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "KANBAN_BOARD")
data class KanbanBoard(
     @PrimaryKey(autoGenerate = true) val id : Long,
     val text : String ,
     val date : String,
     var color: KanbanBoardColor = KanbanBoardColor.PINK ,
)
