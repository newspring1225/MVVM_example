package kr.co.unioncomm.petid.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "accountResult")
class Account {
    @PrimaryKey
    @SerializedName("UserID")
    @Expose
    var userID: String = ""
    @SerializedName("UniqueID")
    @Expose
        var uniqueID: String = ""
    @SerializedName("Uuid")
    @Expose
    var uuid: String = ""
    @SerializedName("Name")
    @Expose
    var name: String = ""
    @SerializedName("LoginPW")
    @Expose
    var loginPW: String = ""
    @SerializedName("Privilege")
    @Expose
    var privilege: String = ""
    @SerializedName("ServerID")
    @Expose
    var serverID: String = ""
    @SerializedName("LoginAllowed")
    @Expose
    var loginAllowed: String = ""

}