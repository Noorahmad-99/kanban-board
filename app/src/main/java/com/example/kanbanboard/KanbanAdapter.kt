package com.example.kanbanboard

class KanbanAdapter (items:List<KanbanBoard>, listener: BaseListener) : BaseAdapter<KanbanBoard>(items, listener) {
        override val layoutId: Int = R.layout.recyceler_item
}

interface KanbanListener : BaseListener