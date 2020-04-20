package com.example.level5_example

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level5_example.ReminderRoomDatabase
import com.example.level5_example.ReminderDAO
import com.example.level5_example.Reminder

class ReminderRepository(context: Context) {
    private var reminderDao: ReminderDAO?

    init {
        val reminderRoomDatabase = ReminderRoomDatabase.getReminderRoomDatabase(context)
        reminderDao = reminderRoomDatabase?.reminderDao()
    }

    fun getAllReminders() : LiveData<List<Reminder>> {
        return reminderDao?.getAllReminders() ?: MutableLiveData(emptyList())
    }

    suspend fun insertReminder(reminder: Reminder) {
        reminderDao?.insertReminder(reminder)
    }

    suspend fun deleteReminder(reminder: Reminder) {
        reminderDao?.deleteReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDao?.updateReminder(reminder)
    }

}