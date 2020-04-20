package com.example.level5_example

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ReminderDAO {

    @Query("SELECT * FROM reminderTable")
    fun getAllReminders(): LiveData<List<Reminder>>

    @Insert
    suspend fun insertReminder(rmeinder: Reminder)

    @Delete
    suspend fun deleteReminder(rmeinder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)
}