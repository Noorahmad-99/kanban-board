package com.example.kanbanboard


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class KanbanViewModel() :ViewModel() {

   // var todoTaskList = LinkedList<KanbanBoard>()
   // var doingTaskList = LinkedList<KanbanBoard>()
   // var doneTaskList = LinkedList<KanbanBoard>()

    val newText = MutableLiveData<String>()

    private val _kanbanes = MutableLiveData<List<KanbanBoard>>()
    val kanbanes: LiveData<List<KanbanBoard>> = _kanbanes

    private val repository = KanbanRepository()

    init {
        loadData()
    }

    fun addEntity() {
        newText.value?.let {
            repository
                .insertNew(KanbanBoard(0, it,"22/10/2021"))
                .subscribeOn(Schedulers.io())
                .subscribe()
            newText.postValue("")
        }
    }

    fun loadData() {
        repository.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onSuccess ,
                this::onFail
            )
    }

    private fun onSuccess(list : List<KanbanBoard>){
        _kanbanes.postValue(list)
    }
    private fun onFail(t : Throwable){
    }
}