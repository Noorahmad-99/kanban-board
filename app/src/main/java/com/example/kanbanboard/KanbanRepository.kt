package com.example.kanbanboard

import io.reactivex.rxjava3.core.Completable

class KanbanRepository {

        val dao = KanbanDatabase.getInstanceError().updateDao()

        fun insertNew(kanban : KanbanBoard) : Completable {
            return dao?.insert(kanban)!!
        }

        fun getAll() = dao?.getAll()

    }
