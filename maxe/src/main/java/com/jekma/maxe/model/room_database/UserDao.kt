package com.jekma.maxe.model.room_database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>

    @Query("DELETE  FROM user_table WHERE id = :id")
    fun deleteData(id: Int)

//
//    /**======================================================================================= */
//    /**簡易新增所有資料的方法 */
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun  //預設萬一執行出錯怎麼辦，REPLACE為覆蓋
//            insertData(myData: User?)
//
//    /**複雜(?)新增所有資料的方法 */
//    @Query("INSERT INTO " + tableName + "(name,phone,hobby,elseInfo,age) VALUES(:name,:phone,:hobby,:elseData,:age)")
//    fun insertData(name: String?, phone: String?, hobby: String?, elseData: String?, age: Int)
//    /**======================================================================================= */
//    /**撈取全部資料 */
//    @Query("SELECT * FROM " + tableName)
//    fun displayAll(): List<User?>
//
//    /**撈取某個名字的相關資料 */
//    @Query("SELECT * FROM " + tableName + " WHERE name = :name")
//    fun findDataByName(name: String?): List<User?>?
//    /**======================================================================================= */
//    /**簡易更新資料的方法 */
//    @Update
//    fun updateData(myData: User?)
//
//    /**複雜(?)更新資料的方法 */
//    @Query("UPDATE " + tableName + " SET name = :name,phone=:phone,hobby=:hobby,elseInfo = :elseInfo,age= :age WHERE id = :id")
//    fun updateData(id: Int, name: String?, phone: String?, hobby: String?, elseInfo: String?, age: Int)
//    /**======================================================================================= */
//    /**簡單刪除資料的方法 */
//    @Delete
//    fun deleteData(myData: User?)
//
//    /**複雜(?)刪除資料的方法 */
//    @Query("DELETE  FROM " + tableName + " WHERE id = :id")
//    fun deleteData(id: Int)
//
//    companion object {
//        const val tableName = "MyTable"
//    }
}